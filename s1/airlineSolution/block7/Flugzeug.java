package s1.airlineSolution.block7;

/**
 *
 * @author s@scalingbits.com
 */
public class Flugzeug {

    static final float duchschnittsgewicht = 100F;
    final int maxPassagiere;
    private int passagiere;
    private int besatzung;
    float treibstoff;
    float leergewicht;
    String kennzeichen;
    private static Flugzeug tanker; // Singleton

    public Flugzeug(String kennz, int maxPas, float leerg) {
        kennzeichen = kennz;
        if (maxPas >= 0) {
            this.maxPassagiere = maxPas;
        } else {
            maxPassagiere = 0;
        }
        passagiere = 0;
        treibstoff = 0;
        leergewicht = leerg;
    }

    private Flugzeug(String kennz) {
        this(kennz,120,400000F);
        besatzung++;
        System.out.println("Flugzeig ist fertig");
    }

    // Das ist eine Factory
    // 1. Privaten Konstruktor
    // 2.. Öffentliche statische Methode (die den Konstruktor aufruft)
    public static Flugzeug baueAirbusA320(String kennz) {
        Flugzeug f = new Flugzeug(kennz);
        // Seriennummer erhöhen
        // Rechnung schreiben
        // ...
        return f;
    }

    // Singleton
    // 1. privates statisches Attribut
    // Öffentliche statische Methode
    public static Flugzeug tankFlugzeug() {
        if (tanker == null) tanker = new Flugzeug("D-ESSO");
        return tanker;
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
                + (passagiere + besatzung) * duchschnittsgewicht;
        return g;
    }

    static public float maxPassagierGewicht() {
        return duchschnittsgewicht * 3;
    }

    /**
     * Hier steigen Passagiere ein
     *
     * @param e Anzahl der Passagiere
     */
    public void einsteigen(int e) {
        einsteigen();
        if (e > 1) {
            einsteigen(e - 1);
        }
    }

    public void einsteigen(double e) {
        if ((passagiere + e <= maxPassagiere) && (e >= 0)) {
            passagiere = passagiere + 15;
        }
    }

    /**
     * Hier steigen Passagiere und Besatzungsmitglieder ein Vorsicht bei den
     * Bewsatzsmitgliedern wird kein Check durchgeführt
     *
     * @param e Anzahl der Passagiere.
     * @param besatz Anzahl der Besatzung
     */
    public void einsteigen(int e, int besatz) {
        if ((passagiere + e <= maxPassagiere) && (e >= 0)) {
            passagiere = passagiere + e;
            System.out.println("Bitte einsteigen");
        }
        besatzung = besatz;
    }

    public void einsteigen() {
        final int a;
        if (passagiere + 1 <= maxPassagiere) {
            passagiere++;
        }

    }

    public void alleEinsteigen(int pass, int bes) {
        if ((passagiere + pass <= maxPassagiere) && (pass >= 0)) {
            passagiere = passagiere + pass;
        }
        besatzung = besatzung + bes;
    }

    public int anzPassagiere() { return passagiere;}

    public String getKennzeichen() {
        return kennzeichen;
    }

}
