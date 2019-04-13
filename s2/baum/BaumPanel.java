package s2.baum;

/**
 *
 * @author s@scalingbits.com
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author sschneid
 */
public class BaumPanel extends JPanel{
    final private Binaerbaum b;
    final private int ziffernBreite = 10 ; // Breite einer Ziffer in Pixel
    final private int ziffernHoehe = 20; // Hoehe einer Ziffer in Pixel
    private String fehlerString;

public BaumPanel(Binaerbaum derBaum) {
        fehlerString = "";
        b = derBaum;
        setPreferredSize(new Dimension(600,200));
        setDoubleBuffered(true);
    }

/**
     * Setzen des Fehlertexts des Fehlertexts
     * @param s String mit Fehlertext
     */
    public void fehlerText(String s) {fehlerString = s;}

/**
     * Methode die das Panel überlädt mit der Implementierung
     * der Baumgraphik
     * @param g
     */
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       int maxWidth = getWidth();
       int maxHeight = getHeight();
       Baumknoten k = b.getWurzelknoten();
       if (k != null) { // Male Wurzelknoten falls existierend
          g.setColor(Color.black);
          g.drawString("Hoehe: " + b.hoehe(), 10, 20);
          g.drawString(fehlerString, 10, 40);
          paintKnoten(g,k,getWidth()/2, 20);
      }
      else {
          g.setColor(Color.RED);
          g.drawString("Der Baum ist leer. Bitte Wurzelknoten einfügen.",10,20);
     }
  }

/**
     * Malen eines Knotens und seines Unterbaums
     * @param g Graphicshandle
     * @param k zu malender Knoten
     * @param x X Koordinate des Knotens
     * @param y Y Koordinate des Knotens
     */
    public void paintKnoten(Graphics g,Baumknoten k, int x, int y) {
        int xOffset = 1; // offset Box zu Text
        int yOffset = 7; // offset Box zu Text
        String wertString = k.toString(); // Wert als Text
        int breite = wertString.length() * ziffernBreite;
        int xNextNodeOffset = ((int)java.lang.Math.pow(2,k.hoehe()-1))*10;
        int yNextNodeOffset = ziffernHoehe*6/5; // Vertikaler Offset zur naechsten Kn.ebene
        if (k.getLinkerK() != null) {
            // Male linken Unterbaum
            g.setColor(Color.black); // Schriftfarbe
            g.drawLine(x, y, x-xNextNodeOffset, y+yNextNodeOffset);
            paintKnoten(g,k.getLinkerK(),x-xNextNodeOffset,y+yNextNodeOffset);
            }
        if (k.getRechterK() != null) {
            // Male rechten Unterbaum
            g.setColor(Color.black); // Schriftfarbe
            g.drawLine(x, y, x+xNextNodeOffset, y+yNextNodeOffset);
            paintKnoten(g,k.getRechterK(),x+xNextNodeOffset,y+yNextNodeOffset );
            }
        // Unterbäume sind gemalt. Male Knoten
        g.setColor(Color.LIGHT_GRAY); // Farbe des Rechtecks im Hintergrund
        g.fillRoundRect(x-xOffset, y-yOffset, breite, ziffernHoehe, 3, 3);
        g.setColor(Color.black); // Schriftfarbe
        g.drawString(wertString, x+xOffset, y+yOffset);
    }
}
