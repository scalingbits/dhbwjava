package s2.sort;
/**
 *
 * @author sschneid
 * @version 2.0
 */
public class MainSort {
     /**
     *
     * Das Hauptprogramm sortiert sechs Zahlen in Phase 1
     * Phase 2 wird nur aufgerufen wenn der Sortieralgorithmus
     * für die erste Phase korrekt war
     * @param args
     */
    public static void main(String[] args) {
        int zeit = 3;
        System.out.println("Phase 1: Einfacher Test mit 6 Elementen");
        boolean erfolg = phase1();
        if (erfolg) {
            System.out.println ("Phase 2: Stresstest");
            System.out.print("Der Stresstest wird beendet nachdem mehr ");
            System.out.println("als " + zeit + " Sekunden benötigt werden.");
            phase2(zeit);
        }
        else {System.out.println("Keine Phase 2 (Stresstest) " +
                "aufgrund von Fehlern...");}
    }
    /**
     * Auswahl des Sortieralgorithmus
     * @ param feld das zu sortierende Feld
     * @ return der Sortieralgorithmus
     */
    public static Sortierer algorithmusWahl(int[] feld) {
        Sortierer sort;
        // Wähle ein Sortieralgorithmus abhängig von der
        // gewünschten Implementierung
        //sort= new TrivialSort(feld);
        //sort = new SelectionSort(feld);
        //sort = new InsertionSort(feld);
        // sort = new BubbleSort(feld);
        //sort = new QuickSort(feld);
        //sort = new QuickSortParallel(feld);
        sort = new HeapSort(feld);
        //sort.geschwaetzig = true;
        return sort;
    }
    /**
     * Sortiere 6 Zahlen
     * @return wurde die  Folge korrekt sortiert?
     */
    public static boolean phase1() {
        long anfangszeit = 0;
        long t = 0;
        int[] gz = new int[6];
        gz[0] = 6;
        gz[1] = 2;
        gz[2] = 4;
        gz[3] = 3;
        gz[4] = 5;
        gz[5] = 7;
        Sortierer sort = algorithmusWahl(gz);
        System.out.println("Algorithmus: " + sort.algorithmus());
        System.out.println("Unsortiert:");
        sort.druckenKonsole();
        anfangszeit = System.nanoTime();
        sort.sortieren(0, gz.length - 1);
        t = System.nanoTime() - anfangszeit;
        System.out.print(
                " Zeit(ms): " + t / 1000000
                + " Vergleiche: " + sort.anzahlVergleiche()
                + " Vertauschungen: " + sort.anzahlVertauschungen());
        boolean erfolg = sort.validierung();
        if (erfolg) {System.out.println(". Korrekt sortiert");}
        else {System.out.println(". Fehler in Sortierung");}
        System.out.println("Sortiert:");
        sort.druckenKonsole();
        return erfolg;
   }
     /**
     * Sortieren von zufallsgenerierten Feldern bis eine maximale
     * Zeit pro Sortiervorgang in Sekunden erreicht ist
     * @param maxTime
     */
    public static void phase2(int maxTime) {
        // Maximale Laufzeit in Nanosekunden
        long maxTimeNano = (long) maxTime * 1000000000L;
        long t = 0;
        // Steigerungsfaktor für Anzahl der zu sortierenden Elemente
        double steigerung = 2.0; // Faktor um dem das Feld vergrößert wird
        int anzahl = 5; // Größe des initialen Felds
        long anfangszeit;
        int[] gz;
        Sortierer sort;
        System.out.println("Maximalzeit(s): " + maxTime);
        while (t < maxTimeNano) {
            // Sortiere bis das Zeitlimit erreicht ist
            anzahl = (int) (anzahl * steigerung);
            // Erzeugen eines neuen Feldes
            gz = new int[anzahl];
            for (int i = 0; i < gz.length; i++) {
                gz[i] = 1;
            }
            sort = algorithmusWahl(gz);
            sort.generiereZufallsbelegung();
            sort.zaehlerRuecksetzen();
            anfangszeit = System.nanoTime();
            sort.sortieren(0, gz.length - 1);
            t = System.nanoTime() - anfangszeit;
            System.out.print(
                sort.algorithmus() +
                ". Feldgroesse: " + anzahl + " Zeit(ms): " + t / 1000000 +
                " Vergleiche: " + sort.anzahlVergleiche() +
                " Vertauschungen: " + sort.anzahlVertauschungen());
            if (sort.validierung()) {System.out.println(". Korrekt sortiert");}
            else {System.out.println(". Fehler in Sortierung");}
            sort.zaehlerRuecksetzen();
        }
   }
} 