package s1.block8;
/**
 * Dies ist die Dokumentation der Klasse Ware. Ware dient zum Verwalten von Gütern
 * mit Preisen und Namen in einem Lager.
 * @author  s@scalingbits.com
 * @version 1.3
 * @see     Lager
 */
public class MusikCD extends Ware {
    /*
     * 6. Erzeugen er Klasse MusikCD durch Kopieren der Klasse Ware
     * 6.1 Mehrwertsteuer auf vollen Mehrwertsteuer hart kodieren
     * 7. Die Klasse Ware soll nicht mehr instanziiert werden. Sie soll
     *      abstrakt werden
     */
    /**
     * Konstruktor fuer die Klasse Ware
     * @param n der Name der Ware
     * @param np der Nettorpreis
     */
    MusikCD(String n, double np) {
        super(n,np,false);
    }
    /**
     * tiefes Vergleichen. Berücksichtigt beim Namen nicht
     * die Groß/kleinschreinung. Berücksichtigt rekursiv die
     * Empfehlungen
     * @param dieAndereWare zu vergleichende CD
     * @return wahr wenn beide Waren dem Vergleich entsprechen.
     */
    public boolean equals(MusikCD dieAndereWare) {
        return super.equals(dieAndereWare);
    }
}