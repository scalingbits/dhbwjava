package s1.block8;

/**
 * Die Klasse Lager verwaltet eine bestimmte Anzahl von Waren
 * @author sschneid
 * @version 1.0
 */
public class Lager {
    private static Lager instanz = null;
    /**
     * privates Feld zum Verwalten der Waren
     */
    private Ware[] bestand;
    /**
     * * Groesse des Bestands
     */
    private int initBestand = 20;
    /**
     * Standardkonstruktor der das Lager initialisiert
     */
    private Lager() {
        bestand = new Ware[initBestand];
    }
    /**
     *
     * @return Groesse des Lagers
     */
    public int lagerGroesse() {return bestand.length;}
    public static Lager getLager() {
        if (instanz == null) {
            instanz = new Lager();
        }
        return instanz;
    }
    /**
     * Einlagern von Waren. Existierende Waren werden verdraengt.
     * Lager wird dynamisch vergrößert
     * @param ware1
     * @param pos
     */
    public void einlagern(Ware ware1,int pos) {
        if (pos>=bestand.length) {
            // Erzeuge neues Lager welches 2x größer als das geforderte
            // Element ist und kopiere alles die das neue Feld
            Ware[] tempBestand = new Ware[pos*2];
            System.arraycopy(bestand,0,tempBestand,0,bestand.length);
            bestand = tempBestand;
        }
        bestand[pos] = ware1;
    }
    /**
     * Einlagern von Waren. Es wird die erste freie Position gesucht.
     * Lager wird dynamisch vergrößert
     * @param ware1
     * @return eingelagerte Position
     */
    public int einlagern(Ware ware1) {
        int freiePosition=0;
        while ((freiePosition<bestand.length) && (bestand[freiePosition]!=null))
            freiePosition++;
        einlagern(ware1,freiePosition);
        return freiePosition;
    }
    /**
     *
     * @param pos die Position der Ware im Lager
     * @return eine Referenz auf die Ware. Der Zeiger kann ein null Zeiger sein.
     */
    public Ware holen(int pos) {
        return bestand[pos];
    }

    /***
     * drucken des Lagerbestands. Es werden nur die Namen der Produkte
     * ausgegeben
     */
    public void drucken() {
        System.out.println("*** Lagerbestand ***");
        for (int i=0; i < bestand.length; i++) {
            if (bestand[i]== null)
                System.out.println("bestand[" +i + "]: leer");
            else
                System.out.println("bestand[" +i + "]: " +
                        bestand[i].getName());
        }
        System.out.println("*** Lagerbestand (Ende)***");
    }
}
