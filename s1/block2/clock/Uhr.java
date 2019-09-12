package s1.block2.clock;
/*
 * Zeichnen einer analogen Uhr in einem JFrame
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author s@scalingbits.com
 */
public class Uhr extends JPanel {

static int sekunde = 0;
static int minute = 0;
static int stunde = 0;
static String tzString; // aktuelle Zeitzone


     /**
     * Hauptprogramm der Anwendung. Es werden keine Eingabeparameter benötigt
     * @param args dieser Parameter wird nicht ausgewertet
     */
    public static void main(String[] args) {
        JFrame hf; // Das Fenster der Anwendung
        hf = new JFrame("Uhr");
        // Beenden der Anwendung bei Schliesen des Fenster
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Uhr dieUhr = new Uhr();
        // Aufbau des Contentpanes
        Container myPane = hf.getContentPane();
        myPane.add(dieUhr, BorderLayout.CENTER);

        // Erzeuge einen Menüeintrag zum Beenden des Programms
        JMenuBar jmb = new JMenuBar();
        JMenu jm = new JMenu("Datei");
        JMenuItem exitItem = new JMenuItem("Beenden");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jm.add(exitItem);
        jmb.add(jm);
        hf.setJMenuBar(jmb);

        hf.pack();
        // Das JFrame sichtbar machen
        // Gewünschte Größe setzen
        //     1. Parameter: horizontale Größe in Pixel
        //     2. Parameter: vertikale Größe in Pixel
        hf.setSize(2 * ZeigerLoesung.maxRadius + 80, 2 * ZeigerLoesung.maxRadius + 80);
        hf.setVisible(true);
        hf.setAlwaysOnTop(true);
        // Update von Panel in zyklischen Intervallen
        try {
            while (true) {
                Thread.sleep(500); // Schlafe x Millisekunden
                // Hole Systemzeit und belege statische Variablen
                Calendar call = Calendar.getInstance();
                tzString = call.getTimeZone().getDisplayName();
                sekunde = call.get(Calendar.SECOND);
                minute = call.get(Calendar.MINUTE);
                stunde = call.get(Calendar.HOUR);
                dieUhr.repaint();
            }
        } catch (InterruptedException e) {
            System.out.println(
                    "Die Anwendung wird wegen einer Ausnahme beendet");
        }

}

/**
     * Überladene Paintmethode. Sie führt alle Zeichenoperationen im Panel aus
     * @param g vom Laufzeitsystem übergebenes Graphikobjekt.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int xCenter = ZeigerLoesung.maxRadius + 40;
        int yCenter = ZeigerLoesung.maxRadius + 20;
        int maxRadius = ZeigerLoesung.maxRadius;
        int charCenterOffSet = 5;
        String timeString = stunde + ":" + minute + ":" + sekunde
                + " " + tzString;
        // Zeichne Uhrenhintergrung und Koordinatensystem
        g.setColor(Color.BLACK); // Farbe
        g.drawArc(xCenter - 5, yCenter - 5, 10, 10, 0, 360);
        g.drawLine(xCenter, yCenter, xCenter + 40, yCenter);
        g.drawLine(xCenter, yCenter, xCenter, yCenter + 40);
        g.drawString("X", xCenter + 45, yCenter + +charCenterOffSet);
        g.drawString("Y", xCenter - charCenterOffSet, yCenter + 55);
        g.drawString("12", xCenter - charCenterOffSet, yCenter - maxRadius);
        g.drawString("3", xCenter + maxRadius, yCenter + charCenterOffSet);
        g.drawString("6", xCenter, yCenter + maxRadius);
        g.drawString("9", xCenter - maxRadius - charCenterOffSet,
                yCenter + charCenterOffSet);
        // Zeichne aktuelle Zeit zum Debuggen
        g.drawString(timeString, 0, yCenter + maxRadius + 10);

        // Zeichne Stundenzeiger
        g.setColor(Color.BLACK);
        g.drawLine(xCenter, yCenter,
                xCenter + ZeigerLoesung.stundeX(stunde),
                yCenter + ZeigerLoesung.stundeY(stunde));
        g.drawString("h["
                + ZeigerLoesung.stundeX(stunde)
                + "," + ZeigerLoesung.stundeY(stunde) + "]",
                0, yCenter + maxRadius - 40);
        // Zeichne Minutenzeiger
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter,
                xCenter + ZeigerLoesung.minuteX(minute),
                yCenter + ZeigerLoesung.minuteY(minute));
        g.drawString("m["
                + ZeigerLoesung.minuteX(minute) + ","
                + ZeigerLoesung.minuteY(minute) + "]", 0, yCenter + maxRadius - 25);
        // Zeichne Sekundenzeiger
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter,
                xCenter + ZeigerLoesung.sekundeX(sekunde),
                yCenter + ZeigerLoesung.sekundeY(sekunde));
        g.drawString("s["
                + ZeigerLoesung.sekundeX(sekunde) + ","
                + ZeigerLoesung.sekundeY(sekunde) + "]", 0, yCenter + maxRadius - 10);
    }
}