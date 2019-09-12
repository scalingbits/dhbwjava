package s1.block2.clock;

import static java.lang.Math.*;
/**
 *
 * @author sschneid
 */
public class Zeiger {
    public static final int maxRadius = 100; // Beeinflusst GUI-Größe !

/**
     * @param s Sekunden der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return aktuelle X Koordinate der Zeigerspitze des Sekundenzeigers
     *             auf dem Bildschirm
     */
    public static int sekundeX(int s) {
        int xs;
        /* Implementierung Beginn */
        xs = s; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return xs;
    }

    /**
     * @param s Sekunden der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return aktuelle Y Koordinate der Zeigerspitze des Sekundenzeigers
     *             auf dem Bildschirm
     */
    public static int sekundeY(int s) {
        int ys;
        /* Implementierung Beginn */
        ys = s; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return ys;
    }

    /**
     * @param m Minuten der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return aktuelle X Koordinate der Zeigerspitze des Minutenzeigers
     *             auf dem Bildschirm
     */
    public static int minuteX(int m) {
        int xm;
        /* Implementierung Beginn */
        xm = m; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return xm;
    }

    /**
     * @param m Minuten der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return int aktuelle Y Koordinate der Zeigerspitze des Minutenzeigers
     *             auf dem Bildschirm
     */
    public static int minuteY(int m) {
        int ym;
        /* Implementierung Beginn */
        ym = m; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return ym;
    }

    /**
     * @param h Stunden der aktuellen Zeit. Ein Wert zwischen 0 und 12
     * @return aktuelle X Koordinate der Zeigerspitze des Stundenzeigers
     *             auf dem Bildschirm
     */
    public static int stundeX(int h) {
        int xs;
        /* Implementierung Beginn */
        xs = h; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return xs;
    }

    /**
     * @param h Stunden der aktuellen Zeit. Ein Wert zwischen 0 und 12
     * @return aktuelle Y Koordinate der Zeigerspitze des Stundenzeigers
     *             auf dem Bildschirm
     */
    public static int stundeY(int h) {
        int ys;
        /* Implementierung Beginn */
        ys = h; // Proformazuweisung. Sie ist zu ersetzen
        /* Implementierung Ende */
        return ys;
    }
}