package s2.sort;

/**
 *
 * @author s@sclaingbits.com
 */
public class QuickSort extends Sortierer {

    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche das Feld an die
     * Oberklasse weiter. Der Algorithmus ist nicht parallel (false Argument)
     *
     @param s das zu sortierende Feld
     */
    public QuickSort(int[] s) {
        super(s, false);
    }

    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf dea Feld wieder
     * zurück
     *
     * @param startIndex Beginn des zu sortierenden Intervalls
     * @param endeIndex Ende des zu sortierenden Intervalls
     */
    @Override
    public void sortieren(int startIndex, int endeIndex) {
        int i = startIndex;
        int j = endeIndex;
        int pivotWert = feld[(startIndex + endeIndex)/2];
        //System.out.println("von"+ startIndex+", bis:"+endeIndex +
        //        " pivot:" + pivotWert);
        while (i <= j) {
           // Suche vom unteren Ende des Bereichs aufsteigend einen
            // Feldeintrag welcher groesser als das Pivotelement ist
            while (feld[i] < pivotWert) {
                i++;
                vglZaehler();
            }
           // Suche vom oberen Ende des Bereichs absteigend einen
            // Feldeintrag der kleiner als das Pivotelement ist
            while (feld[j] > pivotWert) {
                j--;
                vglZaehler();
            }
              // Vertausche beide Werte falls die Zeiger sich nicht
            // aufgrund mangelnden Erfolgs überschnitten haben
            if (i <= j) {
                tausche(i, j);
                i++;
                j--;
            }
        }
        // Sortiere unteren Bereich
        if (startIndex < j) {
            sortieren(startIndex, j);
        }
        // Sortiere oberen Bereich
        if (i < endeIndex) {
            sortieren(i, endeIndex);
        }
    }

    /**
     * Liefert den Namen des Insertion Sorts
     *
     * @return Name des Algorithmus
     */
    @Override
    public String algorithmus() {
        return "QuickSort";
    }
}
