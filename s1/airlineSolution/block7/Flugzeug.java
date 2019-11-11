package s1.airlineSolution.block7;

/**
 *
 * @author s@scalingbits.com
 */
public class Flugzeug {

    static final double duchschnittsgewicht = 100F;
    final int maxPassagiere;
    private int passagiere;
    private int besatzung;
    double treibstoff;
    double leergewicht;
    String kennzeichen;
    final double maxGewicht;
    private static Flugzeug tanker; // Singleton

    /**
     * Beim Anlegen eines Flugzeuges werden die wichtigsten invarianten
     * Größen erfasst
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     * @param maxPassagiere maximale Anzahl der Passagiere
     * @param leergewicht Leergewicht des Flugzeugs
     * @param maxGewicht Maximalgewicht des Flugzeugs
     */
    public Flugzeug(String kennzeichen, int maxPassagiere, double leergewicht,
                    double maxGewicht) {
        this.kennzeichen = kennzeichen;
        if (maxPassagiere >= 0)
            this.maxPassagiere = maxPassagiere;
        else
            this.maxPassagiere = 0;
        this.besatzung = 0;
        this.treibstoff = 0;
        this.leergewicht = leergewicht;
        if (maxGewicht > leergewicht)
            this.maxGewicht= maxGewicht;
        else
            this.maxGewicht= leergewicht;
    }
    /**
     * Alternatives Anlegen eines Flugzeugs
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     * @param maxPassagiere maximale Anzahl der Passagiere
     * @param leergewicht Leergewicht des Flugzeugs
     */
    public Flugzeug(String kennzeichen, int maxPassagiere, double leergewicht) {
        this(kennzeichen,maxPassagiere,leergewicht,2*leergewicht);
        // Hier kann man noch spezielles machen...
    }

    /**
     * Anlegen eines Airbus A320 (zum Bsp.)
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     */
    private Flugzeug(String kennzeichen) {
        this(kennzeichen,120,400000F);
        besatzung++; //Ein Pilot
        System.out.println("Flugzeug ist fertig");
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

    public double gewicht() {
        double g;
        g = leergewicht + treibstoff
                + (passagiere + besatzung) * duchschnittsgewicht;
        return g;
    }

    static public double maxPassagierGewicht() {
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
