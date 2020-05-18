package s2.backtrack;

import java.io.Serializable;

/**
 * Eine Klasse zum Verwalten von Koordinaten
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Position implements Serializable{
    /**
     * X Koordinate
     */
    public int x;
    /**
     * Y Koordinate
     */
    public int y;
    public enum Status {LEER,WAND,KRUEMEL,START,ZIEL,LOESUNG}

    /**
     * grafischer Status der Zelle
     */
    public Status zustand;

    /**
     *
     * @param x X Koordinate
     * @param y Y Koordinate
     * @param s der Zustand der Position
     */
    public Position (int x, int y, Status s) {
        this.x = x;
        this.y = y;
        this.zustand=s;
    }
    /**
     * Copy-Konstruktor
     * @param p Ein Zeiger auf eine Position, die als Vorlage dient
     */
    public Position (Position p) {
        if (p!=null) {
            this.x = p.x;
            this.y = p.y;
            this. zustand=p.zustand;
        }
        else {
            this.x = 0;
            this.y = 0;
            this. zustand=Status.LEER;
        }
    }
    
    /**
     * Erneuere eine Position mit den Werten einer anderen Position
     * @param p Die Position die als Vorlage dient
     * @return nothing
     */
    public void update (Position p) {
        if (p != null) {
            this.x = p.x;
            this.y = p.y;
            this.zustand = p.zustand;
        } else {
            this.x = 0;
            this.y = 0;
            this.zustand = Status.LEER;
        }
    }
    /**
     * Ist der Weg frei auf dieser Position?
     */
    public boolean neuerWeg() {
        return ((zustand != Status.WAND) && (zustand != Status.KRUEMEL));
    }

    /**
     *  uebrschriebene toString Methode
     * @return der Zustand als Text
     */
    @Override
    public String  toString() {
        return (x + ", " +y + ", " + zustand);
    }

    /**
     *  Ueberschriebene equals Methode
     * @param o Das Objekt mit dem verglichen wird
     * @return gleich oder ungleich
     */
    @Override
    public boolean equals(Object o) {
        Position p = (Position) o;
        return ((x==p.x) && (y==p.y));
    }
}
