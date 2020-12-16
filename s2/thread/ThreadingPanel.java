package s2.thread;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author s@scalingbits.com
 */
public class ThreadingPanel extends JPanel {

    private final int ziffernBreite = 10; // Breite einer Ziffer in Pixel
    private final int ziffernHoehe = 20; // Hoehe einer Ziffer in Pixel

    public ThreadingPanel() {
        setPreferredSize(new Dimension(200, 100));
        setDoubleBuffered(true);
    }
    /**
     * Methode die das Panel überlädt mit der Implementierung
     * der Treads
     * @param g das Grafikobjekt (wird vom Laufzeitsystem gestellt)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        int maxHeight = getHeight();
        g.setColor(Color.black);
        g.drawString("Anzahl threads: " + MainTest.anzahlThreads, 10, 20);
        for (int i = 0; i < MainTest.anzahlThreads; i++) {
           paintThread(g, i, 20 + 25 * i, 30);
        }
    }

     /**
     * Malen eines Threads und seines Zustands
     * @param g Graphicshandle
     * @param id Identifier
     * @param x X Koordinate des Thread
     * @param y Y Koordinate des Thread
     */
    public void paintThread(Graphics g, int id, int x, int y) {
        int xOffset = 1; // offset Box zu Text
        int yOffset = 7; // offset Box zu Text

        if (MainTest.mt[id] != null) {
            switch(MainTest.mt[id].threadStatus) {
                case MainTest.ENDED:             g.setColor(Color.LIGHT_GRAY); break;
                case MainTest.NOTINCRITICALPATH: g.setColor(Color.GREEN); break;
                case MainTest.INCRITICALPATH:    g.setColor(Color.RED); break;
                default: assert(true):"Hier laeuft etwas falsch";
            }
        }
        int breite = 2 * ziffernBreite;
        int xNextNodeOffset = 20;
        int yNextNodeOffset = ziffernHoehe * 6 / 5; // Vertikaler Offset zur naechsten Kn.ebene
        g.fillRoundRect(x - xOffset, y - yOffset, breite, ziffernHoehe, 3, 3);
        g.setColor(Color.black); // Schriftfarbe
        g.drawString(Integer.toString(id), x + xOffset, y + yOffset);
    }
}
