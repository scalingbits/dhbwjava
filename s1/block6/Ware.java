package s1.block6;

import s1.block6.loesung.Lager;

/**
 * Dies ist die Dokumentation der Klasse Ware. Ware dient zum Verwalten von Gütern
 * mit Preisen und Namen in einem Lager.
 * @author  Stefan Schneider
 * @version 1.1
 * @see     Lager
 */
public class Ware {
    /*
     * 7. Anlegen eine Copy Constructor
     * 7.1 Alle Werte des Objekts werden kopiert
     * 7.2 Es wird bei Bedarf eine neue Empfehlung angelegt
     */
    /**
     * Der aktuelle Mehrwertsteuersatz 2010.
     * Er liegt zur Zeit bei {@value}.
     * @since 1.0
     * @version 1.0
     */
    public static final double mws = 0.19;
    private double nettoPreis; //Deklaration
    public boolean halbeMws;
    private String name;
    public Ware empfehlung;
    /**
     * Konstruktor fuer die Klasse Ware
     * @param n der Name der Ware
     * @param np der Nettorpreis
     * @param hmws halber Mehrwertsteuersatz für Ware gueltig
     */
    public Ware(String n, double np, boolean hmws) {
        name = n;
        nettoPreis = np;
        halbeMws = hmws;
    }
    /**
     * Liefert den Namen einer Ware zurueck.
     * @return    Name der Ware
     */
    public String get_name() {
        return name;    }
    /**     * Setzen eines neuen Nettopreis
     * @param npr   der neue Nettopreis
     */
    public void set_nettoPreis(double npr) {
        nettoPreis = npr;
    }
    /**
     * Ausdrucken aller Werte auf der Konsole
     */
    public void drucken() { drucken(0); }
    /**
     * Ausdrucken aller Werte auf der Konsole mit vorgebener Einrueckung
     * für Empfehlungen
     * @param einruecken eingerueckte Stellen für Empfehlungen
     */
    private void drucken(int einruecken) {
        String leerStellen = "";
        for (int i = 0; i < einruecken; i++) {
            leerStellen = leerStellen + " ";
        }
        System.out.println(leerStellen + "Name: " + name);
        System.out.println(leerStellen + "netto: " + nettoPreis);
        System.out.println(leerStellen + "Brutto: " + bruttoPreis());
        System.out.println(leerStellen + "Halbe Mws:" + halbeMws);
        if (empfehlung != null) { // Empfohlene Bücher werden eingerückt
            empfehlung.drucken(einruecken + 2);
        }
    }
    /**
     * Ausgabe des Nettopreis
     * @return der Nettopreis
     */
    public double nettoPreis() {
        return nettoPreis;    }
    /**
     * Ausgabe des Bruttopreis
     * @return der Bruttopreis
     */
    public double bruttoPreis() {
        double bp; //temporaere Variable; keine Klassenvariable
        if (halbeMws) {
            bp = Math.round(nettoPreis * (mws / 2 + 1) * 100) / 100;
        } else {
            bp = Math.round(nettoPreis * (mws + 1) * 100) / 100;
        }
        return bp;
    }
}