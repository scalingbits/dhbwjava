package s2.backtrack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;

/**
 *
 * @author stsch
 */
public class BacktrackSucheParallel extends BacktrackSuche {

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
            
                        Ariadne4Parallel a = new Ariadne4Parallel(myBacktrack);
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
    
} // Ende Klasse
