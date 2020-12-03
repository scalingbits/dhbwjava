package s1.block9;

/**
 *
 * @author s@scalingbits.com
 */
public class Hund extends Haustier{
    /**
     * Die Rasse des Hundes
     */
    private String rasse;

    /**
     * Get the value of rasse
     *
     * @return the value of rasse
     */
    public String getRasse() {
        return rasse;
    }

    /**
     * Konstruktor fuer Hunde
     * @param name des Hundes
     * @param kostenTierarzt Tierarztkosten
     * @param rasse die Rasse des Hundes
     */
    public Hund(String name, double kostenTierarzt, String rasse) {
        super(name,true,kostenTierarzt);
        this.rasse = rasse;

    }

    /**
     * Eine Beschreibung meines Hundes
     * @return Eine Beschreibung meines Hundes
     */
    public String beschreibung() {
        return super.beschreibung() + ", Rasse: " + rasse;
    }
}