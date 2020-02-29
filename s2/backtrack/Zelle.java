package s2.backtrack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Zelle extends JButton{
    /**
     * Die Zelle ist im Editiermodus und erlaubt Änderungen zwischen 
     * Wand und Leer.
     * Alle Objekte teilen sich diese Eigenschaft
     */
    public static boolean editierbar = false;
    public static Position start;
    public static Position ziel;
    /**
     * Die x,y Position
     */
    final public Position p;
    
    public static Icon leerIcon;
    public static Icon wandIcon;
    public static Icon kruemelIcon;
    public static Icon startIcon;
    public static Icon zielIcon;
    public static Icon loesungIcon;    
    public static int  xRaster=20;
    public static int  yRaster=20;
    
    /**
     * 
     * @param pp eine Position im Feld
     */
    public Zelle (Position pp) {
        p = pp;
        if (leerIcon == null)  leerIcon = erzeugeIcon(Color.WHITE);
        if (wandIcon == null)  wandIcon = erzeugeIcon(Color.BLACK);
        if (kruemelIcon == null) kruemelIcon = erzeugeIcon(Color.GRAY);
        if (startIcon == null) startIcon= erzeugeIcon(Color.RED);
        if (zielIcon == null)  zielIcon = erzeugeIcon(Color.GREEN);
        if (loesungIcon == null)  loesungIcon = erzeugeIcon(Color.BLUE);
        update();
        addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Zelle meineZelle = (Zelle) ae.getSource();
                    if (editierbar) {
                        if (p.zustand == Position.Status.LEER) {
                            p.zustand = Position.Status.WAND;                    
                        }
                        else p.zustand = Position.Status.LEER;
                        meineZelle.update();
                    }
                }
            }
        );
        }
    
    /**
     * Update des graphischen Objekts falls sich die Position verändert hat
     * Es wird die Farbe und der Tooltip neu gesetzt
     */
    public void update() {
        switch (p.zustand) {
            case LEER    : setIcon(leerIcon); break;
            case WAND    : setIcon(wandIcon); break;
            case KRUEMEL : setIcon(kruemelIcon); break;
            case START   : setIcon(startIcon); break;
            case ZIEL    : setIcon(zielIcon); break;
            case LOESUNG : setIcon(loesungIcon); break;       
        }        
        setToolTipText(("("+p.x+","+p.y+","+ p.zustand +")"));
    }
    
    /**
     * Erzeugt eine Ikone in der richtigen Größe und Farbe
     * @param farbe Farbe der Ikone
     * @return die erzeugte Ikone
     */
    public static ImageIcon erzeugeIcon(Color farbe) {
        BufferedImage img =
                new BufferedImage(xRaster, yRaster, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = img.createGraphics();
        g.setColor(farbe);
        g.fillRect(0, 0, xRaster-1, yRaster-1);
        g.dispose();
        return new ImageIcon(img);
    }
       
    /**
     * Erzeugt ein Fenster mit einem einzelnen Button zum Testen der Funktionen
     * dieser Klasse
     * @param args Eingabeparameter werden nicht gelesen
     */
    public static void main(String[] args) {
        JFrame myFrame = new JFrame(Zelle.class.getName());
        xRaster= 200;
        yRaster= 200;
        Position p = new Position(0,0,Position.Status.LEER);
        final Zelle testButton = new Zelle(p);
        myFrame.add(testButton);
        JMenuBar jmb = new JMenuBar();
        myFrame.setJMenuBar(jmb);
        JMenu jm = new JMenu("Ablage");
        jmb.add(jm);
        JMenuItem startItem   = new JMenuItem("Start");
        JMenuItem zielItem    = new JMenuItem("Ziel");
        JMenuItem loesung = new JMenuItem("Loesung");
        final JCheckBoxMenuItem editieren = new JCheckBoxMenuItem("Editieren");
        JMenuItem beenden = new JMenuItem("Test beenden");
        startItem.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    testButton.setIcon(startIcon);
                    testButton.setToolTipText(("("+testButton.p.x+","
                             +testButton.p.y+","
                             + testButton.p.zustand +")"));
                }
            }
        );
        zielItem.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                     testButton.setIcon(zielIcon);
                     testButton.setToolTipText(("("+testButton.p.x+","
                             +testButton.p.y+","
                             + testButton.p.zustand +")"));
                }
            }
        );
        loesung.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                     testButton.setIcon(loesungIcon);
                     testButton.setToolTipText(("("+testButton.p.x+","
                             +testButton.p.y+","
                             + testButton.p.zustand +")"));

                }
            }
        );
        editieren.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Zelle.editierbar = editieren.isSelected();
                }
            }
        );

        beenden.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            }
        );
        jm.add(startItem);
        jm.add(zielItem);
        jm.add(loesung);
        jm.add(editieren);
        jm.add(beenden);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);  
    }   // Ende Methode main
 } // Ende Klasse Zelle
