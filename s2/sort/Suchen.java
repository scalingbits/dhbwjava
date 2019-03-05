package s2.sort;
import java.util.Arrays;
/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Suchen {
    public static int[] feld;
    public static int groesse = 500000000;
    /**
     * Hauptprogramm
     * @param args
     */
    public static void main(String[] args) {
        erzeugeFeld();
        int suchwert =feld[groesse-2];
        System.out.println("Suche feld["+ (groesse-2) +"] = " + suchwert);
        sucheSequentiell(suchwert);
        sortiere();
        binaereSucheSelbst(suchwert);
        binaereSuche(suchwert);

    }
    /**
     * Erzeuge ein Feld mit Zufallszahlen
     */
    public static void erzeugeFeld() {
        feld = new int[groesse];
        for (int i=0; i<feld.length;i++) {
            feld[i]=(int)(Math.random() * Integer.MAX_VALUE);
        }
        System.out.println("Feld mit "+ groesse + " Elementen erzeugt.");
    }
    /**
      * Suche sequentiell einen Wert in einem unsortierten Feld
      * @param suchwert der gesuchte Wert
      */
    public static void sucheSequentiell(int suchwert) {
        System.out.println("Sequentielle Suche nach Schlüssel");
        long t = System.nanoTime();
        int i=0;
        while ( (i<groesse) && (suchwert != feld[i])) i++;
        t = (System.nanoTime() -t)/1000000;
        if (i== groesse) {
            System.out.println("   Der Wert: " + suchwert +
                    " wurde nicht gefunden");
        }
        else {
            System.out.println("   Der Suchwert wurde auf Position " + i +
                    " gefunden");
        }
        System.out.println("   Dauer sequentielle Suche: " + t +"ms");
    }
     /**
      * Sortiere ein Feld mit der Klasse Arrays und messe die Zeit
      * @param suchwert der gesuchte Wert
      */
    public static void sortiere() {
        System.out.println("Sortieren mit Arrays.sort()");
        long t = System.nanoTime();
        Arrays.sort(feld);
        t = (System.nanoTime() -t)/1000000;
        System.out.println("   Feld sortiert in " + t +" ms");
    }
    /**
      * Suche binär einen Wert in einem sortierten Feld
      * @param suchwert der gesuchte Wert
      */
    public static void binaereSucheSelbst(int suchwert) {
        System.out.println("Selbstimplementierte binäre Suche");
        long t = System.nanoTime();
        int intervall = (feld.length+1)/2;
        int pos       = intervall;
        while ((intervall > 1) && (feld[pos] != suchwert)) {
            intervall =(intervall+1)/2;
            if ((feld[pos] > suchwert)) {pos -= intervall;}
            else {pos += intervall;}
        }
        t = (System.nanoTime() -t);
        if (feld[pos]== suchwert) {
            System.out.println("   Der Suchwert wurde auf Position " +
                    pos +" gefunden");
        }
        else {
            System.out.println("   Der Wert: " + suchwert +
                    " wurde nicht gefunden");
        }
        System.out.println("   Dauer binäre Suche " + (t/1000000) +"ms" +
                " (" + t + " ns)");
    }
     /**
      * Suche binär einen Wert in einem sortierten Feld
      * Nutze die binäre Suchmethode der Klasse Arrays
      * @param suchwert der gesuchte Wert
      */
     public static void binaereSuche(int suchwert) {
         System.out.println("Binäre Suche mit Arrays.binarySearch()");
        long t = System.nanoTime();
        int pos = Arrays.binarySearch(feld, suchwert);
        t = (System.nanoTime() -t);
        System.out.println("   Der Suchwert wurde auf Position " +
                pos +" gefunden");
        System.out.println("   Dauer binäre Suche " + (t/1000000) +
                "ms" + " (" + t + " ns)");
    }

}
