package s1.block7;

/*
 * @author scalingbits.com
 */
public class GenerationLoesung {
    /**
     * Groesse des quadratischen Feldes
     */
    private int size = 50;
    private boolean[][] alt;
    private boolean[][] aktuell;

    /**
     * Anlegen aller benoetigten Felder mit Initialwerten
     * Alle Feldelemente sollen mit dem Zustand "false" = leer versehen sein
     */
    public GenerationLoesung() {
        aktuell = new boolean[size][size];
        alt = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                aktuell[i][j] = false;
                alt[i][j] = false;
            }
    }

    /**
     * @return Kantenlaenge des quadratischen Felds
     */
    public int groesse() {
        return size;
    }

    /**
     * Berechnen einer neuen Generation.
     * Legen Sie ein neues Feld an. Berechnen Sie den neuen Zustand
     * aller Feldelement aus dem alten Feld
     */
    void neueGeneration() {
        alt = aktuell;
        aktuell = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                aktuell[i][j] = false;
                // Zaehle Nachbarn
                int nachbar = 0;
                if ((i > 0) && alt[i - 1][j]) nachbar++; //links
                if ((i + 1 < size) && alt[i + 1][j]) nachbar++; //rechts
                if ((j > 0) && alt[i][j - 1]) nachbar++; //oben
                if ((j + 1 < size) && alt[i][j + 1]) nachbar++; //unten
                if ((i > 0) && (j > 0) && alt[i - 1][j - 1]) nachbar++; //links,oben
                if ((i > 0) && (j + 1 < size) && alt[i - 1][j + 1]) nachbar++; //links, unten
                if ((i + 1 < size) && (j > 0) && alt[i + 1][j - 1]) nachbar++; //rechts, oben
                if ((i + 1 < size) && (j + 1 < size) && alt[i + 1][j + 1]) nachbar++; //rechts, unten


// Übernehmen des alten Status als Default
                aktuell[i][j] = alt[i][j];
                // Geburt einer neuen Zelle
                if ((!alt[i][j]) && (nachbar == 3)) aktuell[i][j] = true;
                // Tod einer alten Zelle wegen Einsamkeit
                if ((alt[i][j]) && (nachbar < 2)) aktuell[i][j] = false;
                // Tod einer alten Zelle wegen Überbevölerung
                if ((alt[i][j]) && (nachbar > 3)) aktuell[i][j] = false;
            }
    }

    /**
     * Das Feld mit den aktuellen Werten
     *
     * @return
     */
    public boolean[][] status() {
        return aktuell;
    }
}
