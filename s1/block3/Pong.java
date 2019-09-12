/*
 * Zeichnen einer analogen Uhr in einem JFrame
 */
package block3;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.abs;

import javax.swing.*;

/**
 *
 * @author sschneid
 */
public class Pong extends JApplet {

    private static boolean appletMode = true;
    public long zeit;
    boolean freeze = false; // friert GUI ein
    boolean detail = false;
    boolean schlaegerHoch = false;
    boolean schlaegerRunter = false;
    boolean schlaegerLinks = false;
    boolean schlaegerRechts = false;
    int schlaegerPosX = 50;
    int schlaegerPosY = 120;
    int schlaegerVX = 100; // Geschwindigkeit Pixel/s
    int schlaegerVY = 100; // Geschwindigkeit Pixel/s
    int feldDimX = 400;
    int feldDimY = 300;
    int ballVX = 50; // Geschwindigkeit Pixel/s
    int ballVY = -50; // Geschwindigkeit Pixel/s
    int ballPosX = 20;
    int ballPosY = 150;
    int ballDurchm = 10;
    int schlaegerGroesseX = 100;
    int schlaegerGroesseY = 200;

    public class SchlaegerListener extends KeyAdapter {
        long zeit;
        @Override
        /**
         * Es wurde eine Taste gedrückt.
         * Der Tastendruck muss analysiert werden
         */
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            if ((c == 'I') || (c == 'i')) schlaegerHoch= true;
            if ((c == 'J') || (c == 'j')) schlaegerRunter= true;
            if ((c == 'N') || (c == 'n')) schlaegerLinks= true;
            if ((c == 'M') || (c == 'm')) schlaegerRechts= true;
            if ((c == 'D') || (c == 'd')) detail = !detail;
            if ((c == 'F') || (c == 'f')) freeze = !freeze;
            else zeit = System.nanoTime();
        }
        @Override
        /**
         * Taste losgelassen. Alle Schlägerbewegungen einstellen
         */
        public void keyReleased(KeyEvent e) {
            schlaegerHoch= false;
            schlaegerRunter= false;
            schlaegerLinks= false;
            schlaegerRechts= false;
        }
    }

    /**
     * Zeichnen eines Pongspeilefelds in einem JPanel
     */
    public class PongPanel extends JPanel {

        /**
         * Überladene Paintmethode. Sie führt alle Zeichenoperationen im Panel
         * aus
         *
         * @param g vom Laufzeitsystem übergebenes Graphikobjekt.
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.BLUE); // Farbe
            g.drawRect(0, 0, feldDimX, feldDimY);
            paintStatus(g);
            g.setColor(Color.BLACK); // Farbe
            // Zeichne Schläger
            g.fillRect(schlaegerPosX, schlaegerPosY,
                    schlaegerGroesseX, schlaegerGroesseY);
            // Zeichne Ball
            g.setColor(Color.RED); // Farbe
            g.fillArc(ballPosX, ballPosY,ballDurchm, ballDurchm, 0, 360);
        }

        public void paintStatus(Graphics g) {;
            if (detail) {
                g.drawString("d: Details an/aus",200,20);
                g.drawString("f: stop/weiter",200,40);
                g.drawString("i: Schläger hoch",200,60);
                g.drawString("j: Schläger hoch",200,80);
                g.drawString("n: Schläger links",200,100);
                g.drawString("m: Schläger rechts",200,120);
                g.setColor(Color.BLUE); // Farbe
                g.drawString("Ball  [" + ballPosX + "," + ballPosY + "]", 200, 140);
                g.drawString("Ball v[" + ballVX + "," + ballVY + "]", 200, 160);
                g.drawString("Balldurchmesser: " + ballDurchm, 200, 180);
                g.drawString("Schläger: [" + schlaegerPosX + ","
                    + schlaegerPosY + "]", 200, 200);
                g.drawString("Schlägergroesse: [" + schlaegerGroesseX + ","
                    + schlaegerGroesseY + "]", 200, 220);
                ;
            }
        }
    }

    /**
     * Anwendung wurde als Standalone Programm gestartet
     * @param args
     */
    public static void main(String[] args) {
        appletMode = false;
        Pong k = new Pong();
    }

    public Pong() {
        zeit = System.nanoTime();
        JFrame hf = null; // Das Fenster der Anwendung
        Container co;
        Container myPane;
        if (!appletMode) { // Füge Menü hinzu
            hf = new JFrame("Pong");
            co = hf;
            myPane = hf.getContentPane();
            JMenuBar jmb = new JMenuBar();
            JMenu jm = new JMenu("Datei");
            JMenuItem hilfeItem = new JMenuItem("Hilfe");
            hilfeItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    detail = !detail;
                }
            });
            jm.add(hilfeItem);
            JMenuItem exitItem = new JMenuItem("Beenden");
            exitItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            jm.add(exitItem);
            jmb.add(jm);
            hf.setJMenuBar(jmb);
            hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            co = this;
            myPane = getContentPane();
        }

        co.addKeyListener(new SchlaegerListener());
        PongPanel dasFeld = new PongPanel();
        // Aufbau des Contentpanes
        myPane.add(dasFeld);

        co.setPreferredSize(new Dimension(feldDimX, feldDimY + 50));

        if (!appletMode) {
            // Erzeuge einen Menüeintrag zum Beenden des Programms

            hf.pack();
            hf.setAlwaysOnTop(true);
            hf.setVisible(true);
        }
        try {
            while (true) {
                Thread.sleep(40); // Schlafe x Millisekunden
                // Hole Systemzeit und belege Variablen
                neuePositionenBerechnen();
                dasFeld.repaint();
            }
        } catch (InterruptedException e) {
            System.out.println(
                    "Die Anwendung wird wegen einer Ausnahme beendet");
        }
    }

    /**
     * Berechne neue Ball und Schlägerpositionen
     */
    public final void neuePositionenBerechnen() {
        long neueZeit = System.nanoTime();
        long deltaMs = (neueZeit - zeit) / 1000000;

        if ((deltaMs * abs(ballVX) / 1000 > 0) && (!freeze)) { //Update notwendig
            ballPosX += ballVX * deltaMs / 1000;
            ballPosY += ballVY * deltaMs / 1000;
            richtungsKorrektur();
            if (schlaegerHoch) {
                schlaegerPosY -= schlaegerVY * deltaMs / 1000;
                schlaegerPosY  =max(schlaegerPosY,0);
            }
            if (schlaegerRunter) {
                schlaegerPosY += schlaegerVY * deltaMs / 1000;
                schlaegerPosY=min(schlaegerPosY,feldDimY-schlaegerGroesseY);
            }
            if (schlaegerLinks) {
                schlaegerPosX -= schlaegerVX * deltaMs / 1000;
                schlaegerPosY  =max(schlaegerPosY,0);
            }
            if (schlaegerRechts) {
                schlaegerPosX += schlaegerVX * deltaMs / 1000;
                schlaegerPosX=min(schlaegerPosX,feldDimX-schlaegerGroesseX);
            }
            zeit = neueZeit; // Setze Zähler für neues Zeitintervall
        }
    }

    /**
     * Prüfe ob der Ball eine Richtungskorrektur benötigt
     * Dies geschieht mit dem Geschwindigkeitsvektor des Balls
     */
    public void richtungsKorrektur() {
        if ((ballPosY <= 0)                      // Oberer Rand erreicht
          ||(ballPosY + ballDurchm>= feldDimY))  // oder unterer Rand erreicht
            { ballVY = -ballVY;}
        if ((ballPosX <= 0) // Linker Rand erreicht
          ||(ballPosX + ballDurchm >= feldDimX))  // oder rechter Rand erreicht
            { ballVX = -ballVX;}
        if ((ballVX<0)                                      //1
          &&(ballPosX < schlaegerPosX + schlaegerGroesseX)  //2
          &&(ballPosX > schlaegerPosX)                      //3
          &&(ballPosY > schlaegerPosY)                      //4
          &&(ballPosY < schlaegerPosY + schlaegerGroesseY)) //5
            { ballVX = -ballVX;}
        //1. Ball bewegt sich nach links
        //2. Linke Ballposition ist kleiner als rechte Schlägerkante
        //3. Linke Ballposition ist größer als linke Schlägerkante
        //4. obere Ballkante ist tiefer als obere Schlägerkante
        //5. obere Ballkante is höher als untere Schlägerkante
        if ((ballVX>0)                                      //1
          &&(ballPosX+ballDurchm>= schlaegerPosX)   //2
          &&(ballPosX < schlaegerPosX)                       //3
          &&(ballPosY > schlaegerPosY)                      //4
          &&(ballPosY < schlaegerPosY + schlaegerGroesseY)) //5
            { ballVX = -ballVX;}
        //1. Ball bewegt sich nach links
        //2. Linke Ballposition ist kleiner als rechte Schlägerkante
        //3. Linke Ballposition ist größer als linke Schlägerkante
        //4. obere Ballkante ist tiefer als obere Schlägerkante
        //5. obere Ballkante is höher als untere Schlägerkante
        if ((ballVY>0)                                      //1
          &&(ballPosX >= schlaegerPosX)                      //2
          &&(ballPosX+ballDurchm < schlaegerPosX+schlaegerGroesseX)  //3
          &&(ballPosY+ballDurchm > schlaegerPosY)                      //4
          &&(ballPosY < schlaegerPosY)) //5
            { ballVY = -ballVY;}
        //1. Ball bewegt sich nach unten
        //2. Linke Ballposition ist größer als linke Schlägerkante
        //3. Rechter Ballrand ist kleiner als rechte Schlägerkante
        //4. obere Ballkante ist tiefer als obere Schlägerkante
        //5. obere Ballkante is höher als untere Schlägerkante
        if ((ballVY<0)                                      //1
          &&(ballPosX > schlaegerPosX)                      //2
          &&(ballPosX+ballDurchm < schlaegerPosX+schlaegerGroesseX)  //3
          &&(ballPosY < schlaegerPosY+schlaegerGroesseY)                      //4
          &&(ballPosY+ballDurchm > schlaegerPosY+schlaegerGroesseY)) //5
            { ballVY = -ballVY;}
        //1. Ball bewegt sich nach oben
        //2. Linke Ballposition ist größer als linke Schlägerkante
        //3. Rechter Ballrand ist kleiner als rechte Schlägerkante
        //4. obere Ballkante ist tiefer als obere Schlägerkante
        //5. obere Ballkante is höher als untere Schlägerkante
    }
}
