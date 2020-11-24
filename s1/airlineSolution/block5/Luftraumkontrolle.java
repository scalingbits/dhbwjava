package s1.airlineSolution.block5;

/**
 * Diese Klasse ist ein Beispiel für eine Einzelstück (Singelton)
 * Es gibt nur eine Instanz dieser Klasse
 */
public class Luftraumkontrolle {
    /**
     * Der Name der Luftraumkontrollbehörde
     */
    public final String name;
    /**
     * Ein privater Zeiger auf die einzige Instanz
     */
    private static Luftraumkontrolle meinTower;

    /**
     * gibt einen Zeiger auf die Luftraumkontrolle zurueck
     * und erzeugt sie falls noetig
     * @return die Luftraumkontrollbehörde
     */
    static public Luftraumkontrolle meineLuftraumkontrolle() {
        if (meinTower == null ) {
            meinTower = new Luftraumkontrolle("Eurocontrol");
        }
        return meinTower;
    }

    /**
     * Ein privater Konstruktor
     * @param n Name der Luftraumkontrolle
     */
        private Luftraumkontrolle(String n) {name = n;}
}
