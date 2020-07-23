package s2.listen;

/**
 *
 * @author s@scalingbits.com
 */
public class Ganzzahl implements EinfacherListenknoten {
 
    public int wert;
    private EinfacherListenknoten naechsterKnoten;
 
    public Ganzzahl(int i) {
        wert = i;
        naechsterKnoten = null;
    }
    /**
     * Einfuegen eines Nachfolgers
     * @param n einzufuegender Listenknoten
     */
    @Override
    public void setNachFolger(EinfacherListenknoten n) {
        naechsterKnoten = n;
    }
    /**
    * Auslesen des Nachfolgers
    * @return der Nachfolger
    */
    @Override
    public EinfacherListenknoten getNachfolger() {
        return naechsterKnoten;
    }
 
    /**
     * Hauptprogramm zum Testen
     * @param args Kommandozeilenparameter (nicht benötigt)
     */
    public static void main(String[] args) {
        Ganzzahl z1 = new Ganzzahl(11);
        Ganzzahl z2 = new Ganzzahl(22);
        Ganzzahl z3 = new Ganzzahl(33);
        z1.setNachFolger(z2);
        z2.setNachFolger(z3);
    }
}
