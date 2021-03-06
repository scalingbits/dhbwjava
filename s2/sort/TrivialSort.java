package s2.sort;
/**
 *
 * @author s@scalingbits.com
 * @version 2.0
 */
public class TrivialSort extends Sortierer{
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist nicht parallel (false Argument)
     * @param s das zu sortierende Feld
     */
    public TrivialSort(int[] s) { super(s,false); }
    /**
     * Diese Methode sortiert leider nur die beiden ersten Elemente
     * auf der Position von und (von+1)
     * @param von erste Indexposition die sortiert wird
     * @param bis letzte Indexposition die sortiert
     */
    @Override
    public void sortieren(int von, int bis) {
        geschwaetzig = false;
        int temp; // Zwischenspeicher
        if (istKleiner(von+1,von)) {
            tausche(von,von+1);
        }
        if (istKleiner(von+2,von+1)) {
            tausche(von+1,von+2);
        }
        //druckenKonsole();
    }
    @Override
    public String algorithmus() {
        return "Sortiere drei Werte";
    }
}