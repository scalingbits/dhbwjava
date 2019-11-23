package s1.block9;

public class Katze extends Haustier {

    private Vogel lieblingsVogel;

    public String vogel() {
        String vname;
        if (lieblingsVogel != null)
            vname = lieblingsVogel.getName();
        else vname = "keinen Vogel";
        return vname;
    }
    /**
     *
     * @param v setzen des Lieblingsvogel
     */
    public void setVogel(Vogel v) { lieblingsVogel=v;}

    public Katze(String name, double kostenTierarzt, Vogel lieblingsVogel) {
        super(name, false, kostenTierarzt);
        if ((lieblingsVogel !=null) && (lieblingsVogel instanceof Vogel))
            this.lieblingsVogel = lieblingsVogel;

    }

    public String beschreibung() {
        return super.beschreibung() + ", mag " + vogel();
    }
}