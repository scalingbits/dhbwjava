package s2.listen;

/**
 *
 * @author s@scalingbits.com
 */
public class EineListe {
    protected Listenknoten kopf;
    protected Listenknoten ende;
    /**
     * Konstrukor. Erzeuge eine leere Liste
     */
    public EineListe() {
        kopf = null;
        ende = null;
    }
    /**
    * Berechne die Länge der Liste
    * @return Länge der Liste
    */
    public int laenge() {
        int laenge = 0;
        System.out.println("1. Implementieren Sie EineListe.laenge()");
        return laenge;
    }
    /**
     * Liefert den Kopf der Liste oder einen Null Zeiger
     * @return
     */
    public Listenknoten getKopf() {
        return kopf;
    }
    /**
     * Liefert das Ende der Liste oder einen Null Zeiger
     * @return
     */
    public Listenknoten getEnde() {
        return ende;
    }
    /**
     * Drucke eine Liste alle Objekte auf der Konsole
     */
    public void drucken() {
        System.out.println("Länge Liste: " + laenge());
        Listenknoten k = kopf;
        while (k != null) {
            System.out.println("Knoten: " + k);
            k = k.getNachfolger();
        }
    }
    /**
     * Füge hinter dem Listenknoten "nach" den Knoten "k"ein.
     * Füge nichts ein wenn der Listenknoten "nach" nicht in der Liste
     * vorhanden ist
     * @param nach
     * @param k
     */
    public void einfuegeNach(Listenknoten nach, Listenknoten k) {
        System.out.println("5. Implementieren Sie EineListe.einfuegeNach()");
    }
    /**
     * Füge einen Listenknoten am Kopf der Liste ein
     * @param k neuer Listenknoten
     */
    public void einfuegeAnKopf(Listenknoten k) {
        System.out.println("2. Implementieren Sie EineListe.einfuegeAnKopf()");
        }
    /**
     * Lösche einen Knoten aus der Liste. Mache nichts falls es nichts zu
     * gibt
     * @param k zu löschender Listenknoten
     */
    public void loesche(Listenknoten k) {
        System.out.println("3. Implementieren Sie EineListe.loesche()");
    } // Ende Methode loesche()
    /**
     * Ist wahr wenn ein Knoten mit dem gleichen Wert existiert
     * @param k
     * @return
     */
    public boolean enthaelt(Listenknoten k) {
        boolean result = false;
        System.out.println("4. Implementieren Sie EineListe.enthaelt()");
        return result;
    }  // Ende Methode enhaelt()
} // Ende der Klasse EineListe
