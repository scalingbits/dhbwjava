package s2.sort;
/**
 *
 * @author s@scalingbits.com
 * @version 2.0
 */
public class SelectionSort extends Sortierer{
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist nicht parallel (false Argument)
     * @param s
     */
    public SelectionSort(int[] s) {super(s,false);}
    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder
     * zurück
     * @param s ein unsortiertes Feld
     * @return ein sortiertes Feld
     */
    @Override
    public void sortieren(int startIndex, int endeIndex){
        //geschwaetzig=true;
        int minimumIndex;
        for (int unteresEnde=startIndex; unteresEnde<endeIndex; unteresEnde++) {
            minimumIndex = unteresEnde; //Vergleichswert
            // Bestimme Position des kleinsten Element im Intervall
            for (int j=unteresEnde+1; j<=endeIndex; j++) {
                if (istKleiner(j,minimumIndex)) {
                    minimumIndex=j; // neuer Kandidat
                }
            }
            // Tausche kleinstes Element an den Anfang des Intervalls
            tausche(unteresEnde,minimumIndex);
            // das kleinste Element belegt jetzt das untere Ende des Intervalls
         }
    }
    /**
     * Liefert den Namen des SelectionSorts
     * @return
     */
    @Override
    public String algorithmus() {return "Sortieren durch Auswahl";}
}