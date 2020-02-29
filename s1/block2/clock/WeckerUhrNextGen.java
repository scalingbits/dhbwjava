package s1.block2.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 *
 * @author s@scalingbits.com
 */
public class WeckerUhrNextGen extends JApplet {

    private static boolean appletMode = true;
    int sekunde = 0;
    int minute = 0;
    int stunde = 0;
    boolean klingeln = false;
    String tzString; // aktuelle Zeitzone
    boolean an = false;
    Container hf; // Das Fenster der Anwendung
    final Container myPane;
    final JTextField h, m, s;
    final JButton eingabe;
    final Weckzeit wz;
    int klingelRadius = 0;

    public WeckerUhrNextGen() {
        wz = new Weckzeit();
        hf = null;
        if (appletMode) {
            hf = this;
            myPane = this.getContentPane();
        }
        else            {
            JFrame f = new JFrame("Uhr");
            myPane = f.getContentPane();
            JMenuBar jmb = new JMenuBar();
            JMenu jm = new JMenu("Datei");
            JMenuItem exitItem = new JMenuItem("Beenden");
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            jm.add(exitItem);
            jmb.add(jm);
            f.setJMenuBar(jmb);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            hf = f;
        }
        h = new JTextField(2);
        m = new JTextField(2);
        s = new JTextField(2);
        eingabe = new JButton("OK");
        eingabe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stunde, minute, sekunde;
                try {
                    stunde = Integer.parseInt(h.getText());
                    minute = Integer.parseInt(m.getText());
                    sekunde = Integer.parseInt(s.getText());
                } catch (NumberFormatException ex) {
                    // Es wurde keine korrekte Zahl eingegeben
                    stunde = -100;
                    minute = -100;
                    sekunde = -100;
                }
                wz.setzeWeckzeit(stunde, minute, sekunde);
            }
        });
        // Aufbau des Contentpanes
        myPane.add(this, BorderLayout.CENTER);
        JPanel wzPanel = new JPanel(new GridLayout(1, 0));
        wzPanel.add(new JLabel("hh:mm:ss"));
        wzPanel.add(h);
        wzPanel.add(m);
        wzPanel.add(s);
        wzPanel.add(eingabe);
        myPane.add(wzPanel, BorderLayout.SOUTH);
        if (!appletMode) {
            // Erzeuge einen Menüeintrag zum Beenden des Programms
            ((JFrame)hf).pack();
            hf.setSize(2 * ZeigerLoesung.maxRadius + 80,
                    2 * ZeigerLoesung.maxRadius + 130);
            hf.setVisible(true);
            ((JFrame)hf).setAlwaysOnTop(true);
        }
    }

    /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args
     */
    public static void main(String[] args) {
        appletMode = false;
        WeckerUhrNextGen k = new WeckerUhrNextGen();
        k.tickTack();
    }
       /**
     * Diese Methode verwaltet den Zeitgeber-thread. Dieser Thread belegt
     * die statischen Variablen der Uhrzeit neu
     */
    public void tickTack() {
        try {
            boolean blinken = false;
            while (true) {
                Thread.sleep(250); // Schlafe x Millisekunden
                // Hole Systemzeit und belege statische Variablen
                Calendar call = Calendar.getInstance();
                tzString = call.getTimeZone().getDisplayName();
                sekunde = call.get(Calendar.SECOND);
                minute = call.get(Calendar.MINUTE);
                stunde = call.get(Calendar.HOUR);
                klingeln = wz.klingeln(stunde,minute,sekunde);
                if (blinken){
                    klingelRadius=100;
                }
                else {
                    klingelRadius=30;
                }
                blinken = !blinken;
                repaint();
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
        String klingelString;
        klingelString = wz.wzh +":"+wz.wzm + ":" +wz.wzs +" klingeln";
        if (klingeln) {
            g.setColor(Color.red);
            g.fillOval(xCenter-klingelRadius/2,yCenter-klingelRadius/2,
                    klingelRadius,klingelRadius);
             }

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
        // Zeichne Weckzeit zum Debuggen
        g.drawString(klingelString, 0, yCenter + maxRadius + 25);

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
