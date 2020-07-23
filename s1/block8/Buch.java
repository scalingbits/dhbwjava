package s1.block8;
/**
 * Dies ist die Dokumentation der Klasse Ware. Ware dient zum Verwalten von Gütern
 * mit Preisen und Namen in einem Lager.
 * @author  Stefan Schneider
 * @version 1.2
 * @see     Lager
 */
public class Buch extends Ware {
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
    private final String isbn;
    private Buch alteAuflage;
    /**
     * Referenz aus alte Auflage
     * @return ein Buch einer alten Auflage
     */
    public Buch getAlteAuflage() { return alteAuflage; }
    /**
     * zuweisen einer alten Auflage
     * @param alteAuflage ein Buch einer alten Auflage
     */
    void setAlteAuflage(Buch alteAuflage) {
        this.alteAuflage = alteAuflage;
    }
    /**
     * Auslesen der ISBN-Nummer (eine Zeichenkette)
     * @return ISBN Nummer
     */
    public String getISBN() { return isbn; }
    /**
     * Konstruktor fuer die Klasse Ware
     * @param n der Name der Ware
     * @param np der Nettorpreis
     * @param myISBN die ISBN Nummer
     */
    Buch(String n, double np, String myISBN) {
        super(n,np,true);
        isbn=myISBN;
        // zusätzliche Initialiserungen....
    }
    /**
     * tiefes Vergleichen. Berücksichtigt beim Namen nicht
     * die Groß/kleinschreinung. Berücksichtigt rekursiv die
     * Empfehlungen
     * @param dieAndereWare zu vergleichende CD
     * @return wahr wenn beide Waren dem Vergleich entsprechen.
     */
    public boolean equals(Buch dieAndereWare) {
        boolean result;
        result = super.equals(dieAndereWare)
                && (isbn.equals(dieAndereWare.isbn))
                && (((alteAuflage == null) && (dieAndereWare.alteAuflage == null))
                || ((alteAuflage != null)
                && (dieAndereWare.alteAuflage != null)
                && (alteAuflage.equals(dieAndereWare.alteAuflage))
        )
        );
        return result;
    }
    /**
     * Ausdrucken aller Werte auf der Konsole mit vorgebener Einrueckung
     * für Empfehlungen
     * @param einruecken eingerueckte Stellen für Empfehlungen
     */
    protected void drucken(int einruecken) {
        super.drucken(einruecken);
        String leerStellen = "";
        for (int i = 0; i < einruecken; i++) {
            leerStellen = leerStellen + " ";
        }
        System.out.println(leerStellen + "ISBN:" +isbn);
        if (alteAuflage != null) {
            System.out.println(leerStellen + "Alte Auflage:");
            alteAuflage.drucken(einruecken + 2);
        }
    }
}
