package s2.listen;

/**
 *
 * @author s@scalingbits.com
 */
   public class MainTestListe {
     /**
     * Testroutinen für einfache Listen
     * @param args
     */
    public static void main(String[] args) {
        EineListe testListe = new EineListe();
        einfuegeTest(testListe, 4, 6);
        System.out.println("Kontrolle: Drei Knoten von 4 bis 6");
        einfuegeTest(testListe, 1, 3);
        System.out.println("Kontrolle: Sechs Knoten von 1 bis 6");
        einfuegeTest(testListe, 21, 27);
        System.out.println("Kontrolle: 13 Knoten von 21 bis 27, 1 bis 6");
        loeschenEndeTest(testListe, 3);
        System.out.println("Kontrolle: 10 Knoten von 21 bis 27, 1 bis 3");
        loeschenKopfTest(testListe, 8);
        System.out.println("Kontrolle: 2 Knoten von 2 bis 3");
        loeschenKopfTest(testListe, 3);
        System.out.println("Kontrolle: 0 Knoten. Versuch löschen in leerer Liste");
        enthaeltTest(testListe, 10);
        System.out.println("Kontrolle: Einfügen in der Liste");
        testListe = new EineListe();
        einfuegeNachTest(testListe, 10);
    }
    /**
     * Einfügen einer Reihe von Zahlen in eine gegebene Liste
     * @param l Liste in die eingefügt wird
     * @param min kleinster Startknoten der eingefügt wird
     * @param max größter Knoten der eingefügt werden
     */
    public static void einfuegeTest(EineListe l, int min, int max) {
        System.out.println("Test: Einfügen am Kopf [" + min + " bis " + max + "]");
        for (int i = max; i >= min; i--) {
            l.einfuegeAnKopf(new Listenknoten(i));
            System.out.println("Länge der Liste: " + l.laenge());
        }
        l.drucken();
    }
    /**
     * Lösche eine bestimmte Anzahl von Knoten am Ende der Liste
     * @param l Liste aus der Knoten gelöscht werden
     * @param anzahl der zu loeschenden Knoten
     */
    public static void loeschenEndeTest(EineListe l, int anzahl) {
        System.out.println("Test: Löschen am Ende der Liste " + anzahl + "fach:");
        for (int i = 0; i < anzahl; i++) {
            l.loesche(l.ende);
            System.out.println("Länge der Liste: " + l.laenge());
        }
        l.drucken();
    }
    public static void loeschenKopfTest(EineListe l, int anzahl) {
        System.out.println("Test: Löschen am Kopf der Liste " + anzahl + "fach:");
        for (int i = 0; i < anzahl; i++) {
            l.loesche(l.getKopf());
            System.out.println("Länge der Liste: " + l.laenge());
        }
        l.drucken();
    }
    public static void enthaeltTest(EineListe l, int groesse) {
        System.out.println("Test: enhaelt()  " + groesse + " Elemente");
        Listenknoten[] feld = new Listenknoten[groesse];
        for (int i = 0; i < groesse; i++) {
            feld[i] = new Listenknoten(i * 10);
            l.einfuegeAnKopf(feld[i]);
        }
        l.drucken();
        for (int i = 0; i < groesse; i++) {
            if (l.enthaelt(feld[0])) {
                System.out.println("Element " + feld[i] + " gefunden");
            }
        }
        System.out.println("Erfolg wenn alle Elemente gefunden wurden");
        Listenknoten waise = new Listenknoten(4711);
        if (l.enthaelt(waise)) {
            System.out.println("Fehler: Element gefunden welches nicht zur Liste gehört!");
        } else {
            System.out.println("Erfolg: Element nicht gefunden welches nicht zur Liste gehört");
        }
    }
    public static void einfuegeNachTest(EineListe l, int max) {
        System.out.println("Test: einfügen nach " + max + "fach");
        Listenknoten[] feld = new Listenknoten[max];
        for (int i = 0; i < max; i++) {
            feld[i] = new Listenknoten(i*10);
            l.einfuegeAnKopf(feld[i]);
        }
        System.out.println("Länge der Liste: " + l.laenge());
        for (int i = 0; i < max; i++) {
            l.einfuegeNach(feld[i], new Listenknoten(feld[i].getWert()+1));
            System.out.println("Länge der Liste: " + l.laenge());
        }
        l.einfuegeNach(l.ende, new Listenknoten(111));
        l.drucken();
    }
}
