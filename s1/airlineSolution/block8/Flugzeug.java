package s1.airlineSolution.block8;

/**
 *
 * @author s@scalingbits.com
 */
public abstract class Flugzeug {

    /**
     * kalkulatorisches Durchschnittsgewicht der Personen
     */
    static final float DURCHSCHNITTSGEWICHT = 80F;
    /**
     * Anzahl der Besatzungsmitglieder
     */
    protected int besatzung;
    /**
     * Gewicht des Treibstoffs
     */
    float treibstoff;
    /**
     * Das Leergewicht des Flugzeugs, ohne Treibstoff und Besatzung
     */
    float leergewicht;
    /**
     * Das Kennzeichen des Flugzeugs
     */
    String kennzeichen;

    /**
     * Konstruktor zum Erzeugen eines Flugzeugs
     * @param kennz das Kennzeichen des Flugzeugs
     * @param leerg das Leergewicht des Flugzeugs
     */
    public Flugzeug(String kennz, float leerg) {
        kennzeichen = kennz;
        treibstoff = 0;
        leergewicht = leerg;
    }

    /**
     * Konstruktor zum Erzeugen eines Flugzeugs
     * Alle Flugzeuge werden 40 Tonnen wiegen und
     * ein Besatzungsmitglied haben
     * @param kennz das Kennzeichen des Flugzeugs
     */
    private Flugzeug(String kennz) {
        this(kennz,40000F);
        besatzung = 1;
        System.out.println("Flugzeug ist fertig");
    }


    /**
     * Auslesen der aktuellen Besatzung
     * @return Anzahl aktuelle Besatzung
     */
    public int lese_Besatzung() {
        return besatzung;
    }

    /**
     * Setzen der Besatzung
     * @param besatzung Besatzungsmitglieder
     */
    public void setBesatzung(int besatzung) {
        if (besatzung >= 0) {
            this.besatzung = besatzung;
        }
    }

    /**
     * Das Gewicht des Flugzeugs
     * @return Das Gewicht des Flugzeugs
     */
    public float gewicht() {
        float g;
        g = leergewicht + treibstoff
                + (besatzung) * DURCHSCHNITTSGEWICHT;
        return g;
    }

    /**
     * Das Kennzeichen des Flugzeugs
     * @return Kennzeichen des Flugzeugs
     */
    public String getKennzeichen() {
        return kennzeichen;
    }

    /**
     * Füllt eine gewisse Anzahl Liter (=kg) ind den Tank
     * @param jetfuel eingefüllter Treibstoff
     */
    public void tanken(float jetfuel) {treibstoff += jetfuel;}
}

