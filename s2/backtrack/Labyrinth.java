package s2.backtrack;

import java.io.Serializable;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Labyrinth implements Serializable {
    /** Feld der Wände (wahr). Ansonsten frei */
    public Position[][] feld;
    /**   Start. Muss auf eine Position im Feld zeigen! */
    public Position start;
    /**   Ziel. Muss auf eine Position im Feld zeigen! */
    public Position ziel;
    
    /**
     * Anlegen des Feldes
     * @param x Anzahl Felder in X Dimension
     * @param y Anzahl Felder in Y Dimension
     * @param start Start des Labyrinths
     * @param ziel Ziel des Labyrinths
     */
    public Labyrinth(int x, int y, Position start, Position ziel) {
        feld = new Position[x][y];
        for (int i=0; i<x; i++)
            for (int j=0; j<y; j++)
                feld[i][j]= new Position(i,j,Position.Status.LEER);
        // Update von Start und Ziel
        this.start = feld[start.x][start.y];
        this.start.zustand = Position.Status.START;
        this.ziel = feld[ziel.x][ziel.y];
        this.ziel.zustand = Position.Status.ZIEL;
    }
    
    /**
     * Copy-Konstruktor
     * @param l die Vorlage
     */
    public Labyrinth(Labyrinth l) {
        this(l.feld.length,l.feld[0].length,l.start,l.ziel);
        update(l);
    }
    
    /**
     * Erneuere Alle Werte des Objekts mit den Werten des Angegebenen
     * @param l Die Vorlage für die Erneuerung der Werte
     */
    public final void update(Labyrinth l) {
        for (int y=0; y<feld[0].length; y++)
            for (int x=0; x<feld.length; x++)
                feld[x][y].update(l.feld[x][y]);
        this.start = getPos(l.start.x,l.start.y);
        this.start.zustand = Position.Status.START;
        this.ziel = getPos(l.ziel.x,l.ziel.y);
        this.ziel.zustand = Position.Status.ZIEL;
    } // End Methode
    
    public Position getPos(int x, int y) {
        if ((x>=0) && (x<feld.length) && (y>=0) && (y<feld[0].length))
            return feld[x][y];
        else
            return null;
    }
}
