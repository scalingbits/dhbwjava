package s2.backtrack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author stsch
 */
public class Backtrack4 {
    static int xgroesse = 15;
    static int ygroesse = 10;
    static Zelle[][] zellen;
    static Labyrinth laby;
    static JTextField statusfeld;
    
    public static void main(String[] args) {
        
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
        JFrame rahmen = new JFrame(Backtrack4.class.getName());
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
        
        // Speichern des Labyrinths
        speichern.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                       statusfeld.setText("Speichern des Labyrinths");
                       speichern();
                }
            }
        );
        
        // Laden des Labyrinths
        oeffnen.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                       statusfeld.setText("Laden eines Labyrinths");
                       laden();
                }
            }
        );
        
        // Weg finden für alle Zellen einschalten
        wegfinden.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    // Ohne einen eigenen Thread wird es keine Graphik
                    // updates geben
                    Thread t = new Thread() {
                        public void run() {
                            statusfeld.setText("Streue Krümel");
                            Ariadne4Parallel a = new Ariadne4Parallel(laby);
                            List<Position> l = a.suche();
                            if (l==null){
                                statusfeld.setText("Keine Loesung gefunden");
                            }
                            else {
                                for (Position p : l) {
                                    zellen[p.x][p.y].p.zustand = Position.Status.LOESUNG;
                                    zellen[p.x][p.y].update();
                                }
                                statusfeld.setText("Pfad hat Laenge " + l.size());
                                }
                        }
                        };
                    t.start();
                    }
                }
        );
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

        // Programm beenden
        beenden.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            }
        );
        
        // JFrame packen (Layout berechnen)
        rahmen.pack();
        // ..und Swowtime ! (Anzeigen)
        rahmen.setVisible(true);
        
    }
    
    /**
     * Speichert ein Labyrinth im Dateverwaltungssystem ab
     * Erzeugt einen neuen Dialog in dem die Datei angegeben werden kann
     */
    static void speichern() {
        //Labyrinth la = new Labyrinth(xgroesse,ygroesse,Zelle.start,Zelle.ziel);
        //la.update(laby);
        File selectedFile;
        JFileChooser jfc = 
            new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());	
            // Speichern der Datei
            FileOutputStream f;
            ObjectOutputStream o;
            try {
                f = new FileOutputStream(selectedFile);
                o = new ObjectOutputStream(f);
            
                // Schreibe das Objekt in eine Datei
                o.writeObject(laby);
                //o.writeObject(Zelle.start);
                //o.writeObject(Zelle.ziel);
                o.close();
                f.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Datei nicht gefunden");
            } catch (IOException ex) {
                System.out.println("Fehler beim Initialisieren des Streams");
            }
        } // Ende if
    }  // Ende Methode speichern()
    
    /**
     * Laedt ein Labyrinth im Dateverwaltungssystem ab
     * Erzeugt einen neuen Dialog in dem die Datei angegeben werden kann
     */
    static void laden() {
        Labyrinth la;
        File selectedFile;
        JFileChooser jfc = 
            new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
	if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());	
            // Laden der Datei
            try {
                FileInputStream fi = new FileInputStream(selectedFile);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                la = (Labyrinth) oi.readObject();
                        
                // Umkopieren der Informationen
                Zelle.editierbar=true;
                Zelle.start = la.start;
                Zelle.ziel = la.ziel;
                laby.update(la);
                zellen[Zelle.start.x][Zelle.start.y].setIcon(Zelle.startIcon);
                zellen[Zelle.ziel.x][Zelle.ziel.y].setIcon(Zelle.zielIcon);
                // Alle Buttons brauchen jetzt ein Update
                updateButtons();
                //Schliesen der Resourcen
                oi.close();
                fi.close();
                Zelle.editierbar=false;
            } catch (FileNotFoundException e) {
		System.out.println("Datei nicht gefunden");
            } catch (IOException e) {
		System.out.println("Fehler beim Initialisieren des Streams");
            } catch (ClassNotFoundException e) {
                System.out.println("Die Klassen der Datei stammen " +
                        " wahrscheinlich aus einem anderen Paket");
		e.printStackTrace();
            } // Ende try-catch              
        }
    } // Ende Methode laden
    
    /**
     * Erneuert Tooltips und Ikonen für alle Buttons
     */
    public static void updateButtons() {
         for (int y=0; y <zellen[0].length; y++)
                for (int x=0; x <zellen.length; x++)
                      zellen[x][y].update();
    }
} // Ende Klasse
