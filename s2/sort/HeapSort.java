package s2.sort;
/**
 *
 * @author s@scalingbits.com
 * @version 2.0
 */
public class HeapSort extends Sortierer{
    /**
     * Konstruktor: Akzeptiere ein Feld von int. Reiche
     * das Feld an die Oberklasse weiter.
     * Der Algorithmus ist nicht parallel (false Argument)
     * @param s das zu sortierende Feld
     */
    public HeapSort(int[] s) {super(s,false);}
    /**
     * sortiert ein Eingabefeld s
     * @param startIndex Beginn des zu sortierenden Intervalls
     * @param endeIndex Ende des zu sortierenden Intervalls
     */
    public void sortieren(int startIndex, int endeIndex){
        // Erzeugen der Heapbedingung, Bottom up...
        for (int i=(endeIndex-1)/2; i>=0; i--) versickere (i,endeIndex);
        //System.out.println("Heapbedingung hergestellt");
        for (int i=endeIndex; i>0; i--) {
            // Tausche das jeweils letzte Element mit dem Groeßten an der
            // Wurzel. Versickere die neue Wurzel und verkürze
            // das zu sortierende Intervall von hinten nach vorne
            tausche(0,i); // Groesstes Element von der Wurzel an das Ende
                // des Intervals getauscht
            versickere(0,i-1); // versickere die neue Wurzel um Heapbedingung
                // herzustellen
            }
        }
    /**
     * Berechne Index des linken Sohns für gegebenen Index
     * liefere -1 zurück falls keine linker Sohn existiert
     * @param index für den Sohn berechnet wird
     * @param endeIndex letzter belegter Indexplatz
     * @return Index linker Sohn
     */
    private int linkerSohn(int index, int endeIndex) {
        int ls = index*2+1;
        if (ls > endeIndex)
            return -1;
        else return ls;
    }
    /**
     * Berechne Index des rechter Sohns für gegebenen Index
     * liefere -1 zurück falls keine linker Sohn existiert
     * @param index für den Sohn berechnet wird
     * @param endeIndex letzter belegter Indexplatz
     * @return Index rechter Sohn
     */
    private int rechterSohn(int index, int endeIndex) {
        int rs = (index+1)*2;
        if (rs > endeIndex)
            return -1;
        else return rs;
    }
    /**
     * Versickere ein Element auf der Position "vers"
     * @param vers Index des zu versickernden Elements
     * @param endeIndex hoechste Indexposition die zum Verisckern zur Verfügung
     *                  steht. Sie wird bei der Berechnung des rechts Sohns
     *                  benötigt
     */
    private void versickere (int vers, int endeIndex) {
        int ls = linkerSohn(vers,endeIndex);
        int rs = rechterSohn(vers,endeIndex);
        int groessererSohn;
        while (ls != -1) { // Es gibt einen linken Sohn
            // Versickere bis Heapbedingung erfüllt ist oder keine
            // Söhne mehr vorhanden sind
            groessererSohn =ls; // linker Sohn als groesseren Sohn nominieren
            if ((rs != -1) && (istKleiner(ls,rs))) groessererSohn = rs;
                    // der rechte Sohn existiert und war groesser...
            if (istKleiner(vers,groessererSohn)) {
                tausche(vers,groessererSohn); // beide Felder wurden getauscht
                vers = groessererSohn;
                ls = linkerSohn(vers,endeIndex);
                rs = rechterSohn(vers,endeIndex);
            }
            else ls=-1; // Abbruchbedingung für while Schleife
        }
    }
    /**
     * Liefert den Namen des Heap Sorts
     * @return Name des Algorithmus
     */
    public String algorithmus() {return "Heap Sort";}
}