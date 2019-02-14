package s2.backtrack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class BacktrackSuche extends BacktrackIO {

    /**
     * Hängt die Operation zum Loesen des Labyrinths an das JMenuItem
     *
     * @param wegfinden JMenuItem welche die Loesung soll
     */
    public void loesungFinden(JMenuItem wegfinden) {
        // Weg finden 
        BacktrackSuche myBacktrack = this; // Diese Kruecke wird
                // wegen der inneren Klasse benötigt
        wegfinden.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Ohne einen eigenen Thread wird es keine Graphik
                // updates geben
                Thread t = new Thread() {
                    public void run() {
                        statusfeld.setText("Streue Krümel");
                        Ariadne a = new Ariadne(myBacktrack);
                        List<Position> l = a.suche();
                        if (l == null) {
                            statusfeld.setText("Keine Loesung gefunden");
                        } else {
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
    } // Ende Methode loesungFinden
         
     /**
     * Hauptmethode der Anwendung
     * @param args wird nicht verwendet
     */
       public static void main(String[] args) {
        BacktrackSuche meinFenster = new BacktrackSuche();
        meinFenster.menueleisteAnlegen();
        meinFenster.anzeigen();
    }
} // Ende Klasse
