package s2.sort;
/**
 *
 * @author s@scalingbits.com
 * @version 2.0
 */
public class InsertionSort extends Sortierer {
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist nicht parallel (false Argument)
     * @param s das zu sortierende Feld
     */
    public InsertionSort(int[] s) {
        super(s,false);
    }
    /**
     * sortiert ein Feld im Bereich startIndex bis endeIndex
     * @param startIndex
     * @param endeIndex
     */
    public void sortieren(int startIndex, int endeIndex) {
        for (int sortierGrenze = startIndex;sortierGrenze < endeIndex;
                sortierGrenze++) {
            int probe = sortierGrenze + 1;
            int j = startIndex;
            while (istKleiner(j, probe)) {
                j++;
            }
            // Verschiebe alles nach rechts.
            // Tausche den Probenwert gegen den unteren Nachbarn
            // bis man bei der Position j angekommen ist
            for (int k = probe - 1; k >= j; k--) {
                tausche(k, k + 1);
            }
        }
    }
    /**
     * Liefert den Namen des Insertion Sorts
     * @return
     */
    public String algorithmus() {
        return "Sortieren durch Einfuegen";
    }
}
