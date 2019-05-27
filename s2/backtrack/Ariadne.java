package s2.backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Ariadne {
    public static final int WARTEN=500; //ms Schlafen vor dem nächsten Schritt
    public Labyrinth laby;
    /**
     * Rueckwaertszeigeer zu Backtrack. Haesslich. Wid aber gebraucht
     * zum dynamischen Updaten des Labyrinths
     */
    protected BacktrackSuche bt;
    
    /**
     * Erzeuge eine Loesung
     * @param bt Rueckzeiger auf Backtrack. Wird für dynamische Updates benötigt
     */
    public Ariadne(BacktrackSuche bt) {
        this.bt = bt;
        this.laby  = new Labyrinth(bt.laby);
    }
    
    /**
     * suche in einem Labyrinth nach einem Pfad zum Ziel
     * @return laenge des Pfades
     */
    public List<Position> suche() {
        return suche(laby.start, laby.ziel);
    }
    
    /**
     * Suche ab einer gegebenen Situation
     * @param von
     * @param nach
     * @return eine Liste des Pfades wenn Kösung gefunden wurde
     */
    public List<Position> suche(Position von, Position nach) {
        List<Position> besterFaden = null;
        List<Position> einFaden;
        int x = von.x;
        int y = von.y;
        bt.laby.update(laby);
        bt.updateButtons();
        if (von.equals(nach)) {
            bt.statusfeld.setText("Heureka!");
                besterFaden = new LinkedList<>();
                besterFaden.add(nach);
            }
        else { // Wir suchen weiter
            // Bin nicht am Ziel
            // Markiere aber Feld, damit ich nicht nochmal drüber laufe
            // Lasse Kruemmel fallen
            von.zustand = Position.Status.KRUEMEL;
            //System.out.println("Kruemel auf Position["+von.x + "][" + von.y + "]");
            // Ermittle alle Optionen
            Set<Position> optionen = findeOptionen(von);
            if (optionen.isEmpty())
                bt.statusfeld.setText("Ende auf Position (" + von.x + "," +
                        von.y +"). Muss zurück...");
            for (Position p: optionen) {
                    try {
                        Thread.sleep(WARTEN);
                    } catch (InterruptedException ex) {
                        System.out.println("Probleme mit Thread aufwachen");
                    }
                    einFaden = suche(p, laby.ziel);
                    if (besterFaden == null) besterFaden = einFaden;
                        else 
                            if ((einFaden != null) && 
                                    (einFaden.size() < besterFaden.size()))
                                besterFaden=einFaden;
            }  // Ende for Schleife
            if (besterFaden!=null) besterFaden.add(von);
        } // Ende else
        return besterFaden;
    } // Ende Methode suche()
    
    /**
     *  Finde mögliche freie Stellen die Nachbar von der Position sind
     * @param von Die Position von der freie Stellen gesucht werden sollen
     * @return Menge der freien Positionen
     */
    public Set<Position> findeOptionen(Position von) {
        int x = von.x;
        int y = von.y;
        Set<Position> optionen = new HashSet<>();
            // Checke Oben
            if ((y>0)
                  && (laby.feld[x][y-1].zustand != Position.Status.WAND)
                  && (laby.feld[x][y-1].zustand != Position.Status.KRUEMEL))
                optionen.add(laby.feld[x][y-1]);
            // Checke Links
            if ((x>0)
                 && (laby.feld[x-1][y].zustand != Position.Status.WAND)
                 && (laby.feld[x-1][y].zustand != Position.Status.KRUEMEL))
                optionen.add(laby.feld[x-1][y]);
            // Checke Rechts
            if ((x<laby.feld.length-1)
                 && (laby.feld[x+1][y].zustand != Position.Status.WAND)
                 && (laby.feld[x+1][y].zustand != Position.Status.KRUEMEL))
                optionen.add(laby.feld[x+1][y]);
            // Checke Unten
            if ((y<laby.feld[0].length-1)
                 && (laby.feld[x][y+1].zustand != Position.Status.WAND)
                 && (laby.feld[x][y+1].zustand != Position.Status.KRUEMEL))
                optionen.add(laby.feld[x][y+1]);
         return optionen;
    } // Ende findeOptionen()
}
