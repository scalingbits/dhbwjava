package s2.sort;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/**
 *
 * @author s@scalingbits.com
 */
public class QuickSortParallel extends Sortierer{
    static int SIZE_THRESHOLD=1000; // Schwellwert für paralleles Sortieren
    private static final ForkJoinPool THREADPOOL = new ForkJoinPool();
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist  parallel (true Argument)
     * @param s
     */
    public QuickSortParallel(int[] s) {
        super(s, false);
        System.out.println("Größe Threadpool: " + THREADPOOL.getParallelism());
    }
    /**
     * Innere statische Klasse die Fork and Join aus dem Concurrency package
     * implementiert. Sie macht aus Methodenaufrufen, Taskaufrufe von Threads
     */
    static class SortTask extends RecursiveAction {
        int lo, hi;
        QuickSortParallel qsp;

        /**
         * Speichere alle wichtigen Parameter für den Task
         * @param lo untere Intervallgrenze
         * @param hi obere Intervallgrenze
         * @param qsp Referenz auf das zu sortierende Objekt
         */
        SortTask(int lo, int hi, QuickSortParallel qsp) {
            this.lo = lo;
            this.hi = hi;
            this.qsp =qsp;
        }
        /**
         * Führe Task in eigenem Thread aus und nutze Instanzvariablen
         * als Parameter um Aufgabe auszuführen.
         */
        @Override
        protected void compute() {
            //System.out.println(" Thread ID => " + Thread.currentThread().getId());
            if (hi - lo < SIZE_THRESHOLD) {
                // Sortiere kleine Intervalle seriell
                qsp.sortierenSeriell(lo, hi);}
            else { // Sortiere große Intervalle parallel
                int obergrenzeLinkesIntervall;
                obergrenzeLinkesIntervall = qsp.teilsortieren(lo,hi);
                // der serielle rekursive Aufruf wird ersetzt durch
                // den parallelen Aufruf zweier Threads aus dem Threadpool
                //System.out.println("Parallel: "+
                //        lo+","+obergrenzeLinkesIntervall+","+hi);
                invokeAll(new SortTask(lo,obergrenzeLinkesIntervall,qsp),
                          new SortTask(obergrenzeLinkesIntervall+1,hi,qsp));
            }
        }
    }
    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder
     * zurück
     * @param s ein unsortiertes Feld
     * @return ein sortiertes Feld
     */
    @Override
    public void sortieren(int startIndex, int endeIndex) {
        THREADPOOL.invoke(new SortTask(startIndex,endeIndex,this));
    }
    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder
     * zurück
     * @param s ein unsortiertes Feld
     * @return ein sortiertes Feld
     */
    public void sortierenSeriell(int startIndex, int endeIndex) {
        if (endeIndex > startIndex) {
             int obergrenzeLinkesIntervall= teilsortieren(startIndex, endeIndex);
             //System.out.println("Seriell: "+
             //           startIndex+","+obergrenzeLinkesIntervall+","+endeIndex);
             // Sortiere unteren Bereich
             if (startIndex<obergrenzeLinkesIntervall) {
                sortierenSeriell(startIndex,obergrenzeLinkesIntervall);}
             // Sortiere oberen Bereich
             if (obergrenzeLinkesIntervall+1<endeIndex)  {
                sortierenSeriell(obergrenzeLinkesIntervall+1,endeIndex);}
        }
    }
    public int teilsortieren(int startIndex, int endeIndex) {
        int i = startIndex;
        int j = endeIndex;
        int pivotWert = feld[startIndex+(endeIndex-startIndex)/2];
        //druckenKonsole();
        while (i<=j) {
           // Suche vom unteren Ende des Bereichs aufsteigend einen
           // Feldeintrag welcher groesser als das Pivotelement ist
           while (feld[i] < pivotWert) {i++;vglZaehler();}
           // Suche vom oberen Ende des Bereichs absteigend einen
           // Feldeintrag der kleiner als das Pivotelement ist
           while (feld[j]> pivotWert) {j--;vglZaehler();}
              // Vertausche beide Werte falls die Zeiger sich nicht
              // aufgrund mangelnden Erfolgs überschnitten haben
           if (i<=j) {
              tausche(i,j);
              i++;
              j--;
              }
         }
        //System.out.println("von"+ startIndex+", bis:"+endeIndex +
        //        " pivot:" + pivotWert + " , return: " +i);
        return i-1;
    }
    /**
     * Liefert den Namen des Insertion Sorts
     * @return
     */
    public String algorithmus() {
        return "QuickSort mit Fork and Join";
    }
}
