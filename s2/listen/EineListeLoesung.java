package s2.listen;

/**
 *
 * @author s@scalingbits.com
 */
public class EineListeLoesung {
    protected Listenknoten kopf;
    protected Listenknoten ende;
    public EineListeLoesung() {
        kopf = null;
        ende = null;
    }
    /**
     * Berechnet die Anzahl der Listenelemente
     * @return Anzahl der Listenelemente
     */
    public int laenge() {
        int laenge = 0;
        Listenknoten zeiger = kopf;
        while (zeiger != null) {
            laenge++;
            zeiger = zeiger.getNachfolger();
        }
        return laenge;
    }
    /**
     * Liefert den Kopf der Liste oder einen Null Zeiger
     * @return Zeiger auf Kopf der Liste
     */
    public Listenknoten getKopf() {
        return kopf;
    }
    /**
     * Liefert das Ende der Liste oder einen Null Zeiger
     * @return Zeiger auf das Ende der Lister
     */
    public Listenknoten getEnde() {
        return ende;
    }
    /**
     * Drucke eine Liste alle Objekte auf der Konsole
     */
    public void drucken() {
        System.out.println("Länge Liste: " + laenge());
        Listenknoten k = kopf;
        while (k != null) {
            System.out.println("Knoten: " + k);
            k = k.getNachfolger();
        }
    }
    /**
     * Füge hinter dem Listenknoten "nach" den Knoten "k"ein.
     * Füge nichts ein wenn der Listenknoten "nach" nicht in der Liste
     * vorhanden ist
     * @param nach einfuegen nach diesem Knoten
     * @param k einzufuegender Knoten
     */
    public void einfuegeNach(Listenknoten nach, Listenknoten k) {
        Listenknoten t;
        t = kopf; // Diese Variable wird über die Listenknoten laufen
        while ((t != null) && (t != nach)) {
            // Iteriere über die Liste solange Knoten existieren
            // und kein passender gefunden hier
            t = t.getNachfolger();
        }
        if (t == nach) { // Der Knoten wurde gefunden
            // Merken des Nachfolger hinter der Einfuegestelle
            Listenknoten derNaechste = nach.getNachfolger();
            if (derNaechste != null) {
                // Setzen des neuen Vorgängers falls es einen Nachfolger gab
                derNaechste.setVorgaenger(k);
            } else { // Wir haben am Ende eingefuegt. Ende-Zeiger korrigieren
                ende = k;
            }
            // Der neu eingefügte Knoten soll auf den Nachfolger zeigen
            k.setNachfolger(derNaechste);
            // Der gesuchte Knoten ist der Vorgaenger. Der neue Knoten
            // soll auf ihn zeigen
            k.setVorgaenger(t);
            // Der Vorgaenger soll auf den neu einfeügten Knoten zeigen
            t.setNachfolger(k);
        }
    }
    /**
     * Füge einen Knoten am Anfang der Liste ein
     * @param k am Kopf einzufuegender Knoten
     */
    public void einfuegeAnKopf(Listenknoten k) {
        k.setVorgaenger(null);
        if (kopf == null) { // Die Liste ist leer
            ende = k; // Das Ende ist auch der Kopf
            k.setNachfolger(null); // Sicherstellen das kein Nachfolger benutzt wird
        } else { // Liste ist nicht leer
            k.setNachfolger(kopf); // Neuer Nachfolger ist alter Kopf
            kopf.setVorgaenger(k); // Alter Kopf bekommt Vorgaenger
 
        }
        kopf = k; // Es gibt einen neuen Kopf. Heureka
    }
 
    public void loesche(Listenknoten k) {
        Listenknoten t = kopf; // Diese Variable wird über die Listenknoten laufen
        if (kopf == null) {
            System.out.println("Löschversuch auf leerer Liste");
        } else {
            //Pflege der Kopf- bzw Endezeiger
            if (kopf == k) {
                // Das Kopfelement wir geloescht
                kopf = k.getNachfolger(); //Kann auch Null sein...
            }
            if (ende == k) {
                // Das zu loeschende Objekt ist das Letzte
                ende = k.getVorgaenger(); // Kann auch Null sein...
            }
            while ((t != null) && (t != k)) {
                // Iteriere über Liste solange Nachfolger da sind
                // und nichts passendes gefunden wird
                t = t.getNachfolger();
            }
            if (t == k) { // Der Knoten wurde gefunden
                Listenknoten nachf = k.getNachfolger();
                Listenknoten vorg = k.getVorgaenger();
                if (nachf != null) {
                    // Es gibt einen Nachfolger. Pflege dessen Vorgaenger
                    nachf.setVorgaenger(vorg);
                }
                if (vorg != null) {
                    // Es gibt einen Vorgaenger. Pflege dessen Nachfolger
                    vorg.setNachfolger(nachf);
                }
                // Entfernen aller Referenzen des geloeschten Objekts
                t.setNachfolger(null);
                t.setVorgaenger(null);
            } // Ende der Knoten wurde gefunden
        } // Ende Loeschen aus einer nicht leeren Liste
    } // Ende Methode loesche
 
    /**
     * Ist wahr wenn ein Knoten mit dem gleichen Wert existiert
     * @param k zu testender Knoten
     * @return Ergebnis
     */
    public boolean enthaelt(Listenknoten k) {
        Listenknoten t = kopf;
        boolean result = false;
        while ((!result) && (t != null)) {
            result = (t == k);
            if (!result) {
                t = t.getNachfolger();
            }
        }
        return result;
    } // Ende Methode enhaelt()
} // Ende der Klasse EineListe