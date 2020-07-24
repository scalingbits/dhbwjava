package s1.block8;

/**
 * Dies ist die Dokumentation der Klasse Ware. Ware dient zum Verwalten von Gütern
 * mit Preisen und Namen in einem Lager.
 * @author  Stefan Schneider
 * @version 1.0
 */
public class Ware {
    /*
     * 1. Erzeugen Sie eine Klasse Buch in dem Sie die Klasse
     *     Ware mit Ihrem Inhalt kopieren
     * 1.1 Anpassen Name
     * 1.2 Anpassen Konstruktoren
     * 1.3 Anpassen equals Methode
     * 1.4 Anlegen einer ISBN Nummer
     * 1.5 Anlegen einer hardcodierten halben Mehrwertsteuer
     * 1.6 Referenz auf eine private, optionale (ältere) Auflage
     *      Zugriffsmethoden anlegen
     * 1.7 Anpassen der Druckenmethode
     * 4. Ableiten der Klasse aus der Klasse aus der Klasse Ware
     * 4.1 extends Schlüsselwort benutzen
     * 4.2 Löschen von allem redundanten Code
     * 6. Erzeugen er Klasse MusikCD durch Kopieren der Klasse Ware
     * 6.1 Mehrwertsteuer auf vollen Mehrwertsteuer hart kodieren
     * 7. Die Klasse Ware soll nicht mehr instanziiert werden. Sie soll
     *      abstrakt werden
     */
    /**
     * Der aktuelle Mehrwertsteuersatz 2010.
     * Er liegt zur Zeit bei {@value}.
     *
     * @since 1.0
     */
    public static final double mws = 0.19;
    private double nettoPreis; //Deklaration
    private final boolean halbeMws;
    private final String name;
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
        // zusätzliche Initialiserungen....
    }
    /**
     * tiefes Vergleichen. Berücksichtigt beim Namen nicht
     * die Groß/kleinschreinung. Berücksichtigt rekursiv die
     * Empfehlungen
     * @param dieAndereWare eine Ware
     * @return wahr wenn beide Waren dem Vergleich entsprechen.
     */
    public boolean equals(Ware dieAndereWare) {
        boolean result;
        result = getName().equalsIgnoreCase(dieAndereWare.getName())
                && (getNettoPreis() == dieAndereWare.getNettoPreis())
                && (getHalbeMws() == dieAndereWare.getHalbeMws())
                && (((getEmpfehlung() == null) && (dieAndereWare.getEmpfehlung() == null))
                || ((getEmpfehlung() != null)
                && (dieAndereWare.getEmpfehlung() != null)
                && (getEmpfehlung().equals(dieAndereWare.getEmpfehlung()))
        )
        );
        return result;
    }
    /**
     * Liefert den Namen einer Ware zurueck.
     * @return    Name der Ware
     */
    public String getName() {
        return name;
    }

    /**
     * Setzen eines neuen Nettopreis
     * @param npr   der neue Nettopreis
     */
    public void setNettoPreis(double npr) {
        nettoPreis = npr;
    }

    /**
     * liefere wahr zurück wenn Mwssatz reduziert ist
     * @return halbe Mwst.
     */
    public boolean getHalbeMws() {return halbeMws;}

    public Ware getEmpfehlung() {  return empfehlung; }

    public void setEmpfehlung(Ware empfehlung) {
        this.empfehlung = empfehlung;
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
    protected void drucken(int einruecken) {
        String leerStellen = "";
        for (int i = 0; i < einruecken; i++) {
            leerStellen = leerStellen + " ";
        }

        System.out.print(leerStellen + "Name: " + getName());
        System.out.print(" ;Netto: " + getNettoPreis());
        System.out.print(" ;Brutto: " + getBruttoPreis());
        if (halbeMws)
            System.out.println(" (Halbe Mws)");
        else
            System.out.println(" (Volle Mws)");
        if (empfehlung != null) {
            System.out.println(leerStellen + "Empfehlung:");
            empfehlung.drucken(einruecken + 2);
        }
    }
    /**
     * Ausgabe des Nettopreis
     * @return der Nettopreis
     */
    public double getNettoPreis() {
        return nettoPreis;
    }
    /**
     * Ausgabe des Bruttopreis
     * @return der Bruttopreis
     */
    public double getBruttoPreis() {
        double bp; //temporaere Variable; keine Klassenvariable
        if (halbeMws) {
            bp = Math.round(nettoPreis * (mws / 2 + 1) * 100) / 100;
        } else {
            bp = Math.round(nettoPreis * (mws + 1) * 100) / 100;
        }
        return bp;
    }
    /**
     * Erzeugt verkette Liste einer Ware
     * @param empf Anzahl der zu verkettenden Waren
     */
    public void generiereEmpfehlungen(int empf) {
        Ware ware1 = this;
        Ware ware2;
        for (int i = 1; i <= empf; i++) {
            ware2 =
                    new Ware(ware1.getName() + " " + i, 31.12, false);
            ware1.setEmpfehlung(ware2);
            ware1 = ware2;
        }
    }
}