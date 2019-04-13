
package s2.baum;

/**
 *
 * @author s@scalingbits.com
 */
public class BaumknotenLoesung {
    private int wert;
    //private final int maxWert= Integer.MAX_VALUE;
    private final int maxWert= 99;

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    /**
     * Verwalte linken Knoten
     */
    private BaumknotenLoesung l;
    /**
     * verwalte rechten Knoten
     */
    private BaumknotenLoesung r;

    public BaumknotenLoesung(int i) {wert=i;}

    /**
     * Liefere linken Knoten zurück
     * @return linker Knoten
     */
    public BaumknotenLoesung getLinkerK() {
        return l;
    }

    /**
     * Setze linken Knoten
     * @param k Referenz auf linken Knoten
     */
    public void setLinkerK(BaumknotenLoesung k) {
        l = k;
    }

     /**
     * Liefere rechten Knoten zurück
     * @return rechter Knoten
     */
    public BaumknotenLoesung getRechterK() {
        return r;
    }

    /**
     * Setze rechten Knoten
     * @param k rechter Knoten
     */
    public void setRechterK(BaumknotenLoesung k) {
        r = k;
    }


    /**
     * Drucken einen Unterbaum und rücke entsprechend bei Unterbäumen ein
     * @param einruecken
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
     * @return
     */
    public int hoehe() {
        int lmax = 1;
        int rmax = 1;
        if (l != null) lmax = 1 + l.hoehe();
        if (r != null) rmax = 1 + r.hoehe();
        if (rmax > lmax) return rmax;
        else             return lmax;
    }

    /**
     * Generiere eine Zufallsbelegung für den gegebenen Knoten
     * Die Funktion darf nicht mehr nach EInfügen in den Baum
     * aufgerufen werden, da der neue Wert zu einer inkorrekten Ordnung führt
     */
    public void generiereZufallswert() {
       wert= (int)(Math.random()*maxWert);
    }

    /**
     * Erlaubt den Zahlenwert als Text auszudrucken
     * @return
     */
    public String toString() { return Integer.toString(wert);}

}