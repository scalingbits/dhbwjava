package s1.airlineSolution.block8;

/**
 *
 * @author s@scalingbits.com
 */
public class Frachtflugzeug extends Flugzeug{
    private static Frachtflugzeug tanker; // Singleton
    private float ladung;

    public Frachtflugzeug(String kennz, float leerg) {
        super(kennz, leerg);
        ladung = 0;
    }

    public void laden(float l) {
        if (l>0)
            ladung += l;
    }

    public void entladen(float l) {
        if ((l>0) && (ladung -l > 0))
            ladung -= l;
    }

    @Override
    public float gewicht() {
        float g;
        g = ladung + super.gewicht();
        return g;
    }

    // Singleton
    // 1. privates statisches Attribut
    // Öffentliche statische Methode
    public static Frachtflugzeug tankFlugzeug() {
        if (tanker == null) tanker = new Frachtflugzeug("D-ESSO", 5000F);
        return tanker;
    }

}

