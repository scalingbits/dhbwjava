package s2.backtrack;

import java.io.Serializable;

/**
 * Eine Klasse zum Verwalten von Koordinaten
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Position implements Serializable{
    public int x;
    public int y;
    public enum Status {LEER,WAND,KRUEMEL,START,ZIEL,LOESUNG};
    public Status zustand;
    
    public Position (int x, int y, Status s) {
        this.x = x;
        this.y = y;
        this.zustand=s;
    }
    /**
     * Copy-Konstruktor
     * @param p 
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
     * Update a Position with the values of another Position
     * @param p The Position will will be read for the update
     * @return
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
    
    @Override
    public String toString() {
        return (x + ", " +y + ", " + zustand);
    }
    
    @Override
    public boolean equals(Object o) {
        Position p = (Position) o;
        return ((x==p.x) && (y==p.y));
    }
}
