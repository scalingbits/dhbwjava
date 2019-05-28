package s1.array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
/**
 * Das Spiel des Lebens nach Conway
 * @author s@scalingbits.com
 */
public class SpielDesLebens extends JApplet implements Runnable {
    final private int size;
    final private int xRaster=10;
    final private int yRaster=10;
    final private Generation gen;
    final private JButton[][] buttonFeld;
    private static boolean appletMode = true;
    private static boolean autoMode = false;
    private ImageIcon belegtIcon;
    private ImageIcon freiIcon;
    private static SpielDesLebens myself;
    private int sleeptime = 2000; // Millisekunden im Automode

    public class Zelle extends JButton {
        final public int x;
        final public int y;

        public Zelle (Icon ic, int x, int y) {
            super(ic);
            this.x=x;
            this.y=y;
        }
    }
    /**
     * Der Konstruktor ohne Argumente wird nur beim einem Start als Applet
     * benutzt. Hier wird ein Applet mit einem Grid erzeugt.
     */
    public SpielDesLebens() {
        erzeugeIcons();
        myself=this;
        gen = new Generation();
        size = gen.groesse();
        JFrame f = null;
        if (!appletMode) f = new JFrame("Game");
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(size, size));
        buttonFeld = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttonFeld[i][j] = createButton(i, j);
                jp.add(buttonFeld[i][j]);
            }
        }
        JButton naechste = new JButton(">");
        naechste.setToolTipText("Erzeuge nächste Generation");
        naechste.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent ae) { nextGen();}
                                   } // Ende innere Klasse
        );
        JButton auto = new JButton(">>>");
        auto.setToolTipText("Starte Film");
        auto.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent ae) {
                                       sleeptime /=2; // Verdoppeln der Geschwindigkeit
                                       if (!autoMode) {
                                           autoMode=true;
                                           Thread t1 = new Thread(SpielDesLebens.myself);
                                           t1.start();
                                       }
                                   }
                               } // Ende innere Klasse
        );
        JButton stop = new JButton("Stop");
        stop.setToolTipText("Stoppe Film");
        stop.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent ae) {
                                       autoMode=false;
                                       sleeptime=4000;
                                   }
                               } // Ende innere Klasse
        );
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(naechste);
        buttonPanel.add(auto);
        buttonPanel.add(stop);
        Container co;

        if (!appletMode) co =f;
        else co=this;

        co.setLayout(new BorderLayout());
        co.add(jp,BorderLayout.CENTER);
        co.add(buttonPanel,BorderLayout.SOUTH);
        co.setPreferredSize(new Dimension(size * (xRaster+3),size * (yRaster+3)));

        if (!appletMode) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }
    }
    /**
     * Starten der Anwendung als eigenständiges Programm
     * @param args werden nicht benutzt
     */
    public static void main(String[] args) {
        appletMode = false;
        SpielDesLebens k = new SpielDesLebens();
    }
    /**
     * Erzeugen eines JButtons für jede Zelle des Feldes
     * @param xx x Koordinate im Feld
     * @param yy y Koordinate im Feld
     * @return einen Buttton mit ActionListener
     */
    private JButton createButton(int xx, int yy) {
        JButton myButton = new Zelle(freiIcon,xx,yy);
        myButton.setToolTipText(("("+xx+","+yy+")"));
        myButton.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent ae) {
                                           if(!autoMode) {
                                               Zelle f = (Zelle) ae.getSource();
                                               //System.out.println("Action auf" +f.x + " " + f.y);
                                               boolean[][] g = gen.status();
                                               if (g[f.x][f.y]) {
                                                   f.setIcon(freiIcon);
                                                   g[f.x][f.y]=false;
                                               }
                                               else {
                                                   f.setIcon(belegtIcon);
                                                   g[f.x][f.y]=true;
                                               }
                                               f.updateUI();
                                           }
                                       }
                                   } // Ende innere Klasse
        );
        return myButton;
    }
    /**
     * Erzeuge die beiden Ikonen für eine freies und ein belegtes Feld
     */
    private void erzeugeIcons() {
        BufferedImage belegt =
                new BufferedImage(xRaster, yRaster, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = belegt.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, xRaster-1, yRaster-1);
        g.setColor(Color.black);
        g.fillOval(1, 1, xRaster-2, yRaster-2);
        g.dispose();
        belegtIcon = new ImageIcon(belegt);
        BufferedImage frei =
                new BufferedImage(xRaster, yRaster, BufferedImage.TYPE_4BYTE_ABGR);
        g = frei.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, xRaster-1, yRaster-1);
        g.dispose();
        freiIcon = new ImageIcon(frei);
    }

    /**
     * Erzeugen einer neuen Generation und Abgleich der JButtons mit neuen
     * Ikonen
     */
    private void nextGen() {
        gen.neueGeneration();
        boolean[][] stat = gen.status();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (stat[i][j]) buttonFeld[i][j].setIcon(belegtIcon);
                else buttonFeld[i][j].setIcon(freiIcon);
    }

    /**
     * Lasse neue Generationen automatisiert in einem eigenen Thread
     * erzeugen
     */
    @Override
    public void run() {
        try {
            while (autoMode) {
                Thread.sleep(sleeptime);
                nextGen();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}