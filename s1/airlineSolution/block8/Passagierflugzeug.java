package s1.airlineSolution.block8;

/**
 *
 * @author s@scalingbits.com
 */
public class Passagierflugzeug extends Flugzeug {
    final int maxPassagiere;
    private int passagiere;

    public Passagierflugzeug(String kennz, int maxPas, float leerg) {
        super(kennz,leerg);
        this.maxPassagiere = Math.max(maxPas, 0);
        passagiere = 0;
    }

    private Passagierflugzeug(String kennz) {
        this(kennz,120,400000F);
        besatzung++;
        System.out.println("Flugzeig ist fertig");
    }

    // Das ist eine Factory
    // 1. Privaten Konstruktor
    // 2.. Öffentliche statische Methode (die den Konstruktor aufruft)
    public static Passagierflugzeug baueAirbusA320(String kennz) {
        Passagierflugzeug f = new Passagierflugzeug(kennz);
        // Seriennummer erhöhen
        // Rechnung schreiben
        // ...
        return f;
    }


    /**
     * Schwerstes zulässiges Passagiergewicht in kg
     * @return Passagiergewicht in kg
     */
    static public float maxPassagierGewicht() {
        return DURCHSCHNITTSGEWICHT * 3F;
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

    /**
     * Hier steigen Passagiere und Besatzungsmitglieder ein. Vorsicht bei den
     * Besatzungsmitgliedern wird kein Check durchgeführt
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

    /**
     * Einsteigen eines einzelnen Passagiers.
     * Im wird ohne weitere Warnung das Einsteigen verweigert falls
     * das Flugzeug belegt ist!
     */
    public void einsteigen() {
        final int a;
        if (passagiere + 1 <= maxPassagiere) {
            passagiere++;
        }
    }

    /**
     * Anzahl der Passagiere im Flugzeug
     * @return
     */
    public int anzPassagiere() { return passagiere;}

    /**
     * Gewicht des Flugzeugs. Diese Methode ist ueberschrieben!
     * @return das Gewicht mit dem Gewicht der Passagiere
     */
    @Override
    public float gewicht() {
        float g;
        g = super.gewicht() + passagiere * DURCHSCHNITTSGEWICHT;
        return g;
    }

}
