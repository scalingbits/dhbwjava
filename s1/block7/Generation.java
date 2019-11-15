package s1.block7;
/*
 * @author scalingbits.com
 */
public class Generation {
    // Hier ein Feld für alten Zustand deklarieren
    // Hier ein Feld für neuen Zustand deklarieren
    // die Felder muessen zweidimensional, vom Typ boolean sein, quadratisch sein
    /**
     * Groesse des quadratischen Feldes
     */
    int meineGroesse = 50;
    boolean[][] meinFeld;
    boolean[][] alteGeneration;
    // Variable für Groesse des Feldes anlegen. Empfohlen 50 ==> GUI benötigt dann etwa 500 Pixel
    /**
     * Anlegen aller benoetigten Felder mit Initialwerten
     * Alle Feldelemente sollen mit dem Zustand "false" = leer versehen sein
     */
    public Generation() {
        // Initialisieren sie die beiden Felder
        // alle Felder sollen den Zustand "false" haben. Dies ist ein leeres Feld


        meinFeld = new boolean[meineGroesse][meineGroesse];
        alteGeneration = new boolean[meineGroesse][meineGroesse];

        for (int x=0; x<meinFeld.length; x++) {
            for (int y=0; y<meinFeld.length; y++) {
                meinFeld[x][y]= false;
            }
        }

    }

    /**
     *
     * @return Kantenlaenge des quadratischen Felds
     */
    public int groesse() {return meineGroesse;} //Richtigen Wert zurueckgeben!!

    /**
     * Berechnen einer neuen Generation.
     * Legen Sie ein neues Feld an. Berechnen Sie den neuen Zustand
     * aller Feldelement aus dem alten Feld
     */
    void neueGeneration() {
        // Tipps:
        // Weisen Sie die aktuelle Generation auf die alte zu
        // Erzeugen oder wiederverwenden Sie ein Feld für eine neue Generation
        // Nutzen Sie eine doppelt geschachtelte Schleife zum Ueberstrichen des aktuellen Felds
        // Zaehlen Sie die Nachbarn der aktuellen Position in der alten Generation
        // Achten Sie auf die Feldgrenzen!!
        // Setzen Sie den Wert des aktuellen Felds auf "true" falls ein Objekt erhalten oder erzeugt werden soll
        // Setzen Sie dem Wert des aktuellen Felds auf "false" falls kein Objekt in der neuen Generation existieren soll
        alteGeneration=meinFeld; // Das neue Feld wird das alte Feld
        meinFeld= new boolean[meineGroesse][meineGroesse];
        for (int x=0; x<meinFeld.length; x++) {
            for (int y=0; y<meinFeld.length; y++) {
                //if ((x<meinFeld.length-1) && (y<meinFeld.length-1))
                //    meinFeld[x][y]= alteGeneration[x+1][y+1];
                int nachbarn = 0;
                if ((x>0)             &&(y>0)&&(alteGeneration[x-1][y-1])) nachbarn++;
                if (                    (y>0)&&(alteGeneration[x  ][y-1])) nachbarn++;
                if ((x<meineGroesse-2)&&(y>0)&&(alteGeneration[x+1][y-1])) nachbarn++;
                if ((x>0)                    &&(alteGeneration[x-1][y  ])) nachbarn++;
                if ((x<meineGroesse-2)       &&(alteGeneration[x+1][y  ])) nachbarn++;
                if ((x>0)&&(y<meineGroesse-2)&&(alteGeneration[x-1][y+1])) nachbarn++;
                if (       (y<meineGroesse-2)&&(alteGeneration[x  ][y+1])) nachbarn++;
                if ((x<meineGroesse-2)&&(y<meineGroesse-2)&&(alteGeneration[x+1][y+1])) nachbarn++;

// Anzahl Nachbarn bekannt
                meinFeld[x][y]=alteGeneration[x][y];
                // Geburt einer Zelle
                if (!alteGeneration[x][y] && (nachbarn==3))  {
                    meinFeld[x][y]= true;
                }
                // Tod wegen Einsamkeit
                if (alteGeneration[x][y] && (nachbarn<2))  {
                    meinFeld[x][y]= false;
                }
                // Tod wegen Überbevölerung
                if (alteGeneration[x][y] && (nachbarn>3))  {
                    meinFeld[x][y]= false;
                }
            } // Ende innere for
        } // Ende äussere for
    }

    /**
     * Das Feld mit den aktuellen Werten
     * @return
     */
    public boolean[][] status() {return meinFeld;} // Hier das aktuelle Feld zurückgeben

}
