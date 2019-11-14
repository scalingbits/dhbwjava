package s1.block6.loesung;
/**
 * Dies ist die Dokumentation der Klasse Ware. Ware dient zum Verwalten von Gütern
 * mit Preisen und Namen in einem Lager.
 * @author  Stefan Schneider
 * @version 1.1
 */
public class Ware {
    /**
     * Der aktuelle Mehrwertsteuersatz 2010.
     * Er liegt zur Zeit bei {@value}.
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
    /*
     * 7. Anlegen eine Copy Constructor
     * 7.1 Alle Werte des Objekts werden kopiert
     * 7.2 Es wird bei Bedarf eine neue Empfehlung angelegt
     */
    /**
     * Copy-Konstruktor fuer die Klasse Ware
     * @param w die zu klonende Ware
     */
    public Ware(Ware w) {
        name = w.name;
        nettoPreis = w.nettoPreis;
        halbeMws = w.halbeMws;
        if (w.empfehlung != null)
            empfehlung = new Ware(w.empfehlung);
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
    public void drucken() {
        System.out.println("Name: " + name);
        System.out.println("netto: " + nettoPreis);
        System.out.println("Brutto: " + bruttoPreis());
        System.out.println("Halbe Mws:" + halbeMws);
        if (empfehlung != null) {
            empfehlung.drucken(2);
        }
    }
    /**
     * Ausdrucken aller Werte auf der Konsole mit vorgebener Einrueckung
     * für Empfehlungen
     * @param einruecken eingerueckte Stellen für Empfehlungen
     */    public void drucken(int einruecken) {
        String leerStellen = "";
        for (int i = 0; i < einruecken; i++) {
            leerStellen = leerStellen + " ";
        }
        System.out.println(leerStellen + "Name: " + name);
        System.out.println(leerStellen + "netto: " + nettoPreis);
        System.out.println(leerStellen + "Brutto: " + bruttoPreis());
        System.out.println(leerStellen + "Halbe Mws:" + halbeMws);
        if (empfehlung != null) {
            empfehlung.drucken(einruecken + 2);
        }
    }
    /**
     * Ausgabe des Nettopreis
     * @return der Nettopreis
     */    public double nettoPreis() {
        return nettoPreis;    }
    /**
     * Ausgabe des Bruttopreis
     * @return der Bruttopreis
     */    public double bruttoPreis() {
        double bp; //temporaere Variable; keine Klassenvariable
        if (halbeMws) {
            bp = Math.round(nettoPreis * (mws / 2 + 1) * 100) / 100;
        } else {
            bp = Math.round(nettoPreis * (mws + 1) * 100) / 100;
        }
        return bp;
    }
}
