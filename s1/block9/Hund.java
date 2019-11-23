package s1.block9;

/**
 *
 * @author s@scalaingbits.com
 */
public class Hund extends Haustier{

    private String rasse;

    /**
     * Get the value of rasse
     *
     * @return the value of rasse
     */
    public String getRasse() {
        return rasse;
    }

    public Hund(String name, double kostenTierarzt, String rasse) {
        super(name,true,kostenTierarzt);
        this.rasse = rasse;

    }

    public String beschreibung() {
        return super.beschreibung() + ", Rasse: " + rasse;
    }
}