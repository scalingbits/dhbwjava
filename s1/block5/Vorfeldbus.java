package s1.block5;

/**
 * Implementierung einer Fabrik (Factory)
 */
public class Vorfeldbus {
    /**
     * Flugplatz internes Nummerschild
     */
    public final String kennzeichen;
    /**
     * Zaehler der erzeugten Busse. Wird fuer Nummerschild benoetigt
     */
    static int zaehler = 0;
    /**
     * Ein privater Konstruktor!
     * @param name Name des Flughafens fuer den die Busse fahren
     */
    private Vorfeldbus(String name) {
        kennzeichen=name;
    }

    /**
     * Diese Methode liefert die Busse aus
     * @param flughafennamen der Namen des Flughafens wird für ein Nummerschild benoetigt
     * @return ein Bus mit Nummerschild
     */
    static public Vorfeldbus busausliefern( String flughafennamen) {
        zaehler++;
        return new Vorfeldbus(flughafennamen + "-" + zaehler );
    }
}
