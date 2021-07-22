package s1.airlineSolution.block1;

/**
 *
 * @author s@scalingbits.com
 */
public class Passagierflugzeug {
    /**
     * Das ist ein Attribut. Eine Zeichenkette dient zu bestimmen des Flugzeugs
     */
    String kennzeichen;

    /**
     * Die Methode drucken, druckt alle Information zum Flugzeug auf die Konsole
     */
    public void drucken() {
        System.out.println("<--------------------->");
        System.out.println("Kennzeichen: " +kennzeichen);
        System.out.println("<--------------------->");
    }
}
