package s2.baum;

/**
 *
 * @author @author s@scalingbits.com
 */
public class Binaerbaum {
    private Baumknoten wurzelKnoten;

public Baumknoten getWurzelknoten() {return wurzelKnoten;}
     /**
     * Füge einen neuen Baumknoten in einen Baum ein
     * @param s
     */
    public void einfuegen(Baumknoten s) {
        if (wurzelKnoten == null) {
            // Der Baum ist leer. Füge Wurzelknoten ein.
            wurzelKnoten = s;
        }
        else // Der Baum ist nicht leer. Normales Vorgehen
           einfuegen(wurzelKnoten,s);
    }
     /**
     * Füge einen gegebenen Knoten s in einen Teilbaum ein.
     * Diese Methode ist eine rekursive private Methode
     * Da der neue Knoten die Wurzel des neuen Teilbaums bilden kann,
     * wird eventuell ein Zeiger auf einen neuen Teilbaum zurückgeliefert
     * Randbedingung:
     * * Es wird kein Knoten mit einem Wert eingefügt der schon existiert
     * @param teilbaum
     * @param s
     */
    private void einfuegen(Baumknoten teilbaum, Baumknoten s) {
        System.out.println("Implementieren Sie die Methode Binaerbaum:einfuegen()");
    }
     /**
     * Öffentliche Methoden zum Entfernen eines Baumknotens
     * @param s
     */
    public void entfernen(Baumknoten s) {
        wurzelKnoten = entfernen(wurzelKnoten,s);}
    /**
     * Private, rekursive Methode zum Entfernen eines Knotens aus einem
     * Teilbaum. Es kann ein neuer Teilbaum enstehen wennn der Wurzelknoten
     * selbst entfernt werden muss. Der neue Teilbaum wird daher wieder mit
     * ausgegeben
     * @param teilbaum Teilbaum aus dem ein Knoten entfernt werden soll
     * @param s der zu entfernende Knoten
     * @return Der verbleibende Restbaum. Es kann auch Null für einen leeren Baum ausgegeben werden
     */
    private Baumknoten entfernen(Baumknoten teilbaum, Baumknoten s) {
        System.out.println("Implementieren Sie die Methode Binaerbaum:entfernen()");
        return teilbaum;
        }
     /**
     * Berechnung der Hoehe des Baums
     * @return Hoehe des Baums
     */
    public int hoehe() {
        if (wurzelKnoten == null) return 0;
        else                      return wurzelKnoten.hoehe();
    }
    /**
     * Rückgabe des Namens
     * @return
     */
    public String algorithmus() {return "Binaerbaum";}

public void druckenBaum() {
        System.out.println("Tiefe:" + hoehe());
        if (wurzelKnoten != null) wurzelKnoten.druckeUnterbaum(0);
        System.out.println("A-----------A");
    }

}
