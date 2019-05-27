package s2.backtrack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Backtrack {
    int xgroesse = 15;
    int ygroesse = 10;
    Zelle[][] zellen;
    Labyrinth laby;
    JTextField statusfeld;
    final private JFrame rahmen ;
    
    /**
     * Konstruktor der Klasse. Hier werden die meißten graphischen Objekte
     * angelegt. Diese Technik hilft in spaeteren Phasen beim spezialisieren
     * deiser Klasse
     */
    public Backtrack() {
        // Anlegen eines Feldes der Buttons und der Hintergrundstrukturen
        Zelle.start = new Position(0,0,Position.Status.START);
        Zelle.ziel = new Position(xgroesse-1,ygroesse-1,Position.Status.ZIEL);
        laby = new Labyrinth(xgroesse,ygroesse,  Zelle.start, Zelle.ziel);
        // Anlegen eines Feldes der Buttons
        zellen = new Zelle[xgroesse][ygroesse];
        
        for (int x=0; x <zellen.length; x++) {
            for (int y=0; y <zellen[0].length; y++) {
                zellen[x][y]=new Zelle(laby.feld[x][y]);
            }
        }
        zellen[0][0].setIcon(Zelle.startIcon);
        zellen[xgroesse-1][ygroesse-1].setIcon(Zelle.zielIcon);
        
        // Rahmen anlegen
        rahmen = new JFrame(Backtrack.class.getName());
        rahmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myPane = rahmen.getContentPane();
        myPane.setLayout(new BorderLayout());
        
        JPanel buttonfeld = new JPanel();
        buttonfeld.setLayout(new GridLayout(ygroesse,xgroesse));
        for (int y=0; y <ygroesse; y++) {
            for (int x=0; x <xgroesse; x++) {
                buttonfeld.add(zellen[x][y]);
            }
        }
        myPane.add(buttonfeld, BorderLayout.CENTER);
        
        JPanel guistatus = new JPanel();
        BoxLayout horizontal = new BoxLayout(guistatus, BoxLayout.X_AXIS);
        guistatus.setLayout(horizontal);
        guistatus.add(new JLabel("Status: "));
        statusfeld = new JTextField(20);
        statusfeld.setEditable(false);
        guistatus.add(statusfeld);
        myPane.add(guistatus,BorderLayout.SOUTH);
    }
    
    /** 
     * Anlegen einer Menueleister. Diese Methode ist nützlich, da sie von
     * spezialisierten Klassen wieder verwendet werden kann.
     */
    public void menueleisteAnlegen() {
        JMenu ablage = new JMenu("Ablage");
   
        JCheckBoxMenuItem editieren = new JCheckBoxMenuItem("Editieren");
        JMenuItem wegfinden = new JMenuItem("Weg finden");
        JMenuItem loeschen = new JMenuItem("Loeschen");
        JMenuItem oeffnen   = new JMenuItem("Oeffnen");
        JMenuItem speichern = new JMenuItem("Speichern");
        JMenuItem beenden   = new JMenuItem("Beenden");

        ablage.add(editieren);
        ablage.add(wegfinden);
        ablage.add(loeschen);
        ablage.add(oeffnen);
        ablage.add(speichern);
        ablage.add(beenden);
        
        JMenuBar jmb = new JMenuBar();
        rahmen.setJMenuBar(jmb);
        jmb.add(ablage);
        
        editierenLabyrinth(editieren);
        speichernLabyrinth(speichern);
        ladenLabyrinth(oeffnen);
        loesungFinden(wegfinden);
        loeschenLabyrinth(loeschen);
        beendenAnwendung(beenden);
    }
    
    /**
     * Hängt die Operation zum Editieren des Labyrinths an das JMenuItem
     * @param editieren JMenuItem welches das Labyrinth editieren lassen soll
     */
    public final void editierenLabyrinth(JMenuItem editieren) {
    // Editiermodus für alle Zellen einschalten
        editieren.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Zelle.editierbar = editieren.isSelected();
                    if (editieren.isSelected())
                       statusfeld.setText("Editiermodus");
                    else
                        statusfeld.setText("");
                }
            }
        );
    }
    
    /**
     * Hängt die Operation zum Speichern des Labyrinths an das JMenuItem
     * @param speichern JMenuItem welches das Labyrinth speichern soll
     */
    public void speichernLabyrinth(JMenuItem speichern) {
         // Speichern des Labyrinths
        speichern.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                       statusfeld.setText("TBD: Speichern des Labyrinths");
                }
            }
        );
    }
    
    /**
     * Hängt die Operation zum Laden des Labyrinths an das JMenuItem
     * @param oeffnen JMenuItem welches das Labyrinth laden soll
     */
    public void ladenLabyrinth(JMenuItem oeffnen){
  
        // Laden des Labyrinths
        oeffnen.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                       statusfeld.setText("TBD: Laden eines Labyrinths");
                }
            }
        );
    }
    
    /**
     * Hängt die Operation zum Loesen  des Labyrinths an das JMenuItem
     * @param wegfinden JMenuItem welchs die Loesung triggern soll
     */
    public void loesungFinden(JMenuItem wegfinden) {
        // Weg finden 
        wegfinden.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    statusfeld.setText("TBD: Finden des Weges");
                    }
                }
        );
    }

    /**
     * Hängt die Operation zum Loeschen  des Labyrinths an das JMenuItem
     * @param loeschen JMenuItem welches das Labyrinth loeschen soll
     */
    public final void loeschenLabyrinth(JMenuItem loeschen) {
        // Loeschen: Zurücksetzen in Initialzustand
        loeschen.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    statusfeld.setText("Ruecksetzen des Feldes");
                    if (Zelle.editierbar) {
                        for (int i=0; i< zellen.length; i++)
                            for (int j=0; j< zellen[0].length; j++) {
                                zellen[i][j].p.zustand = Position.Status.LEER;
                                zellen[i][j].update();
                            }
                        Zelle.start=new Position(0,0,Position.Status.START);
                        zellen[0][0].setIcon(Zelle.startIcon);
                        Zelle.ziel =new Position(xgroesse-1,ygroesse-1,Position.Status.ZIEL);
                        zellen[xgroesse-1][ygroesse-1].setIcon(Zelle.zielIcon);

                    } // Ende if editierbar
                } // Ende Methode actionPerformed
                } // Ende innere Klasse
        );
    }

    /**
     * Implementierung eines Actionlisteners zum Beenden der Anwendungh
     * @param beenden Das JMenuItem wleches die Anwendung beenden soll
     */
    public void beendenAnwendung(JMenuItem beenden){
        // Programm beenden
        beenden.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            }
        );
    }
    
    /**
     * Anzeigen des JFrames. Diese Methode ist in Spezialisierungen der Klasse
     * nuetzlich, da man sie wiederverwenden kann.
     */
    public void anzeigen() {        
        // JFrame packen (Layout berechnen)
        rahmen.pack();
        // ..und Showtime ! (Anzeigen)
        rahmen.setVisible(true);
    }
    
    /**
     * Hauptmethode der Anwendung
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Backtrack meinFenster = new Backtrack();
        meinFenster.menueleisteAnlegen();
        meinFenster.anzeigen();
    }
    
}

