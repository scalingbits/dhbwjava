package s2.sort;

/**
 *
 * @author s@scalingbits.com
 */
public class ShellSortE extends Sortierer {

    public ShellSortE(int[] s) {super(s,false); }

    /**
     * sortiert ein Eingabefeld s und gibt eine Referenz auf das Feld wieder
     * zurück
     * @param startIndex erstes zu sortierendes Feldelement
     * @param endeIndex letztes zu sortierendes Feldelement
     */
    public void sortieren(int startIndex, int endeIndex) {
        int i,j,k;
        int t ; // Hilfsspeicher
        boolean weiter;
        for (int h=((endeIndex-startIndex)/2); h>0; h--) {
            for (i=startIndex; i <=endeIndex; i=i+h) {
                j = i; // Oberes Element
                t = feld[i];
                k =feld[i];
                weiter = true;
                while ((feld[j-h] > k) && weiter) {
                    feld[j] = feld[j-h];
                    j = j-h;
                    weiter = (j>h);
                }
                feld[j]=t;
            }
        }
    }

    /**
     * Liefert den Namen des Insertion Sorts
     */
    public String algorithmus() {
        return "Shell Sort";
    }
}
