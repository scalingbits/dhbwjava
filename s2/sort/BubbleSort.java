package s2.sort;
/**
 *
 * @author s@scalingbits.com
 * @version 2.0
 */
public class BubbleSort extends Sortierer {
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist nicht parallel (false Argument)
     * @param s das zu sortierende Feld
     */
    public BubbleSort(int[] s) {super(s, false); }
    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder
     * zurück
     * @param startIndex erstes zu sortierendes Feldelement
     * @param endeIndex letztes zu sortierendes Feldelement
     */
    public void sortieren(int startIndex, int endeIndex) {
        boolean vertauscht;
        do {
            vertauscht = false;
            for (int i = startIndex; i+1 <= endeIndex; i++) {
                if (istKleiner(i + 1,i)) {
                    tausche(i,i+1);
                    vertauscht = true;
                }
            }
        } while (vertauscht);
    }
    /**
     * Liefert den Namen des Bubble Sorts
     * @return Names des Algorithmus
     */
    public String algorithmus() {
        return "Bubble Sort";
    }
}
