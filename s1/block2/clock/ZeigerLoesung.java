package s1.block2.clock;
import static java.lang.Math.*;
/**
 *
 * @author s@scalingbits.com
 */
public class ZeigerLoesung {
    public static final int maxRadius = 100; // Beeinflusst GUI-Größe !
    /**
     * @param s Sekunden der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return int aktuelle X Koordinate der Zeigerspitze des Sekundenzeigers
     *             auf dem Bildschirm
     */
    public static int sekundeX(int s) {
        int xs;
        /* Implementierung Beginn */
        double sx = sin(s*2*PI/60)*maxRadius;
        xs = (int)sx;
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
        double sy = -cos(s*2*PI/60)*maxRadius;
        ys = (int)sy;
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
        double mx = sin(m*2*PI/60)*maxRadius*0.75;
        xm = (int)mx;
        /* Implementierung Ende */
        return xm;
    }
    /**
     * @param m Minuten der aktuellen Zeit. Ein Wert zwischen 0 und 59
     * @return aktuelle Y Koordinate der Zeigerspitze des Minutenzeigers
     *             auf dem Bildschirm
     */
    public static int minuteY(int m) {
        int ym;
        /* Implementierung Beginn */
        double my = -cos(m*2*PI/60)*maxRadius*0.75;
        ym = (int) my;
        /* Implementierung Ende */
        return ym;
    }
    /**
     * @param h Stunden der aktuellen Zeit. Ein Wert zwischen 0 und 12
     * @return int aktuelle X Koordinate der Zeigerspitze des Stundenzeigers
     *             auf dem Bildschirm
     */
    public static int stundeX(int h) {
        int xs;
        /* Implementierung Beginn */
        double sx = sin(h*2*PI/12)*maxRadius*0.5;
        xs = (int)sx;
        /* Implementierung Ende */
        return xs;
    }
    /**
     * @param h Stunden der aktuellen Zeit. Ein Wert zwischen 0 und 12
     * @return int aktuelle Y Koordinate der Zeigerspitze des Stundenzeigers
     *             auf dem Bildschirm
     */
    public static int stundeY(int h) {
        int ys;
        /* Implementierung Beginn */
        double sy = -cos(h*2*PI/12)*maxRadius*0.5;
        ys = (int)sy;
        /* Implementierung Ende */
        return ys;
    }
}