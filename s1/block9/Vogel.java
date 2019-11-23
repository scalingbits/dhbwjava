package s1.block9;

/**
 *
 * @author s@scalingbits.com
 */
public class Vogel extends Haustier{

    private boolean singvogel;

    /**
     * Get the value of singvogel
     *
     * @return the value of singvogel
     */
    public boolean getSingvogel() {
        return singvogel;
    }

    public Vogel(String name, double kostenTierarzt, boolean singvogel) {
        super(name, false, kostenTierarzt);
        this.singvogel = singvogel;
    }

    public String beschreibung() {
        String saenger = (singvogel) ? "ein" : "kein";
        return super.beschreibung() + ", ist "
                + saenger + " Singvogel";
    }

}