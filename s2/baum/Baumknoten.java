package s2.baum;

/**
 *
 * @author s@scalingbits.com
 */
public class Baumknoten {
    private int wert;
    //private final int maxWert= Integer.MAX_VALUE;
    private final int maxWert= 99;
 
    public int getWert() {
        return wert;
    }

    /**
     * Verwalte linken Knoten
     */
    private Baumknoten l;
    /**
     * verwalte rechten Knoten
     */
    private Baumknoten r;

public Baumknoten(int i) {wert=i;}
    /**
     * Liefere linken Knoten zurück
     * @return linker Knoten
     */
   public Baumknoten getLinkerK() {
        return l;
    }
    /**
     * Setze linken Knoten
     * @param k Referenz auf linken Knoten
     */
    public void setLinkerK(Baumknoten k) {
        l = k;
    }
    /**
     * Liefere rechten Knoten zurück
     * @return rechter Knoten
     */
    public Baumknoten getRechterK() {
        return r;
    }
    /**
     * Setze rechten Knoten
     * @param k rechter Knoten
     */
    public void setRechterK(Baumknoten k) {
        r = k;
    }
    /**
     * Drucken einen Unterbaum und rücke entsprechend bei Unterbäumen ein
     * @param einruecken Anzahl der eingerueckten Stellen
     */
    public void druckeUnterbaum(int einruecken) {
        if (l != null) {
            l.druckeUnterbaum(einruecken + 1);
        }
        for (int i = 0; i < einruecken; i++) {
            System.out.print(".");
        }
        System.out.println(toString());
        if (r != null) {
            r.druckeUnterbaum(einruecken + 1);
        }
    }
    /**
     * Berechne Höhe des Baums durch rekursive Tiefensuche
     * @return die Hoehe des Baumes
     **/
    public int hoehe() {
        System.out.println("Implementieren Sie Baumknoten.hoehe() als rekursive Methode");
        return -1;
    }
    /**
     * Generiere eine Zufallsbelegung für den gegebenen Knoten
     * Die Funktion darf nicht mehr nach EInfügen in den Baum
     * aufgerufen werden, da der neue Wert zu einer inkorrekten Ordnung führt
     */
    public void generiereZufallswert() {
       wert= (int)(Math.random()*(double)maxWert);
    }
    /**
     * Erlaubt den Zahlenwert als Text auszudrucken
     * @return Objekt als Zeichenkette
     **/
    public String toString() { return Integer.toString(wert);}
}
