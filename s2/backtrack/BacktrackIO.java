package s2.backtrack;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class BacktrackIO extends Backtrack {

    /**
     * Hängt die Operation zum Speichern des Labyrinths an das JMenuItem
     *
     * @param speichern JMenuItem welches das Labyrinth speichern soll
     */
    public final void speichernLabyrinth(JMenuItem speichern) {
        // Speichern des Labyrinths
        speichern.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                statusfeld.setText("Speichern des Labyrinths");
                File selectedFile;
                JFileChooser jfc
                        = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
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
                        o.writeObject(Zelle.start);
                        o.writeObject(Zelle.ziel);
                        o.close();
                        f.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("Datei nicht gefunden");
                    } catch (IOException ex) {
                        System.out.println("Fehler beim Initialisieren des Streams");
                    }
                } // Ende if
            }
        }
        );
    }

    /**
     * Hängt die Operation zum Laden des Labyrinths an das JMenuItem
     * @param oeffnen JMenuItem welches das Labyrinth laden soll
     */
    public final void ladenLabyrinth(JMenuItem oeffnen) {

        // Laden des Labyrinths
        oeffnen.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                statusfeld.setText("Laden eines Labyrinths");
                Labyrinth la;
                File selectedFile;
                JFileChooser jfc
                        = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
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
                        Zelle.editierbar = true;
                        laby.update(la);
                        Zelle.start = (Position) oi.readObject();
                        Zelle.ziel = (Position) oi.readObject();
                        zellen[Zelle.start.x][Zelle.start.y].setIcon(Zelle.startIcon);
                        zellen[Zelle.ziel.x][Zelle.ziel.y].setIcon(Zelle.zielIcon);
                        // Alle Buttons brauchen jetzt ein Update
                        updateButtons();
                        //Schliesen der Resourcen
                        oi.close();
                        fi.close();
                        Zelle.editierbar = false;
                    } catch (FileNotFoundException e) {
                        System.out.println("Datei nicht gefunden");
                    } catch (IOException e) {
                        System.out.println("Fehler beim Initialisieren des Streams");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Die Klassen der Datei stammen "
                                + " wahrscheinlich aus einem anderen Paket");
                        e.printStackTrace();
                    } // Ende try-catch              
                }
            }
        }
        );
    }

    /**
     * Erneuert Tooltips und Ikonen für alle Buttons
     */
    public void updateButtons() {
        for (int y = 0; y < zellen[0].length; y++) {
            for (int x = 0; x < zellen.length; x++) {
                zellen[x][y].update();
            }
        }
    }
    
    /**
     * Hauptmethode der Anwendung
     * @param args wird nicht verwendet
     */
       public static void main(String[] args) {
        BacktrackIO meinFenster = new BacktrackIO();
        meinFenster.menueleisteAnlegen();
        meinFenster.anzeigen();
    }
} // Ende Klasse

