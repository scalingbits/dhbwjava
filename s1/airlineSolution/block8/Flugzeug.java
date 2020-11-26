package s1.airlineSolution.block8;

/**
 *
 * @author s@scalingbits.com
 */
public abstract class Flugzeug {

    static final float DURCHSCHNITTSGEWICHT = 100F;
    protected int besatzung;
    float treibstoff;
    float leergewicht;
    String kennzeichen;

    public Flugzeug(String kennz, float leerg) {
        kennzeichen = kennz;
        treibstoff = 0;
        leergewicht = leerg;
    }

    private Flugzeug(String kennz) {
        this(kennz,400000F);
        besatzung++;
        System.out.println("Flugzeig ist fertig");
    }


    public int lese_Besatzung() {
        return besatzung;
    }

    public void setBesatzung(int besatzung) {
        if (besatzung >= 0) {
            this.besatzung = besatzung;
        }
    }

    public float gewicht() {
        float g;
        g = leergewicht + treibstoff
                + (besatzung) * DURCHSCHNITTSGEWICHT;
        return g;
    }

    static public float maxPassagierGewicht() {
        return DURCHSCHNITTSGEWICHT * 3;
    }


    public String getKennzeichen() {
        return kennzeichen;
    }

}

