package s1.block11;

/**
 *
 * @author s@scalingbits.com
 * @ version 1.1
 */
public interface Waehrung {
    /**
     *
     * @return Währungssymbol
     */
    String symbol();
    /**
     * Multipliziert den Wert des Objekts mit der Fließkommazahl
     *
     * @param f
     * @return neues Objekt welches das Produkt enthält
     */
    Waehrung mult(double f);
}
