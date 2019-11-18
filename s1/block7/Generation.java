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

    // Variable für Groesse des Feldes anlegen. Empfohlen 50 ==> GUI benötigt dann etwa 500 Pixel
    /**
     * Anlegen aller benoetigten Felder mit Initialwerten
     * Alle Feldelemente sollen mit dem Zustand "false" = leer versehen sein
     */
    public Generation() {
        // Initialisieren sie die beiden Felder
        // alle Felder sollen den Zustand "false" haben. Dies ist ein leeres Feld

    }

    /**
     *
     * @return Kantenlaenge des quadratischen Felds
     */
    public int groesse() {return 0;} //Richtigen Wert zurueckgeben!!

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

    }

    /**
     * Das Feld mit den aktuellen Werten
     * @return
     */
    public boolean[][] status() {return null;} // Hier das aktuelle Feld zurückgeben

}
