package s2.sort;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author sschneid
 * @version 2.1
 */
public abstract class Sortierer {
   /**
   * Das zu sortierende Feld
   */
   protected int[] feld;
   private int maxWert = Integer.MAX_VALUE;
   // Zähler für serielle Sortieralgorithmen
   private long          tauschZaehlerSeriell;
   private long          vergleichszaehlerSeriell;
   // Zähler für paralelle Sortieralgorithmen
   private AtomicInteger tauschZaehlerParallel;
   private AtomicInteger vergleichszaehlerParallel;
   /**
   * Der Algorithmus arbeitet parallel
   */
   private final boolean parallel;
   /**
    * erweiterte Ausgaben beim Sortieren
    */
   public static boolean geschwaetzig = false;
   /**
     * Initialisieren eines Sortierers mit einem
     * unsortierten Eingabefeld s
     * @param s ein unsortiertes Feld
     * @param p der Algorithmus is parallel implementiert
    */
   public Sortierer(int[] s, boolean p) {
      feld = s;
      parallel = p;
      if (parallel) {
         tauschZaehlerParallel     = new AtomicInteger();
         vergleichszaehlerParallel = new AtomicInteger();
      }
      else {
         tauschZaehlerSeriell = 0;
         vergleichszaehlerSeriell = 0;
        }
   }
   /**
   * die Groesse des zu sortierenden Feldes
   */
   public int feldgroesse() {
      return feld.length;
   }
   /**
   * Gibt ein Feldelement auf gegebenem Index aus
   * @param index
   * @return
   */
   public int getElement(int index) {
      return feld[index];
   }
   /**
   * sortiert das Eingabefeld
   * @param s ein unsortiertes Feld
   */
   abstract public void sortieren(int startIndex, int endeIndex);
   /**
   * Eine Referenz auf das Feld
   * @return
   */
   public int[] dasFeld() {
      return feld;
   }
   /**
   * kontrolliert ob ein Feld sortiert wurde
   * @return
   */
   public boolean validierung() {
        boolean korrekt;
        int i = 0;
        while (((i + 1) < feld.length) &&
                (feld[i]<=feld[i + 1])) {i++;}
        korrekt = ((i + 1) == feld.length);
        return korrekt;
    }
    /**
     * Liefert den Namen des implementierten Sortieralgorithmus
     * @return
     */
    abstract public String algorithmus();
    /**
     * Drucken des Feldes auf System.out
     */
    public void druckenKonsole() {
        for (int i = 0; i < feld.length; i++) {
            System.out.println("feld[" + i + "]=" + feld[i]);
        }
    }
    /**
     * Anzahl der Vertauschungen die zum Sortieren benoetigt wurden
     * @return Anzahl der Vertauschungen
     */
    public long anzahlVertauschungen() {
        if (parallel) return tauschZaehlerParallel.get();
        else          return tauschZaehlerSeriell;
    }
    /**
     * Anzahl der Vergleiche die zum Sortieren benoetigt wurden
     * @return Anzahl der Vergleiche
     */
    public long anzahlVergleiche() {
        if (parallel) return vergleichszaehlerParallel.get();
        else          return vergleichszaehlerSeriell;
    }
    /**
     * vergleicht  zwei Zahlen a und b auf Größe
     * @param a
     * @param b
     * @return wahr wenn a kleiner b ist
     */
    public  boolean istKleiner(int a, int b) {
        vglZaehler();
        if (geschwaetzig) {
            System.out.println("Vergleich:feld["+a+"]<feld["+b+"] bzw. " +
                        feld[a] +"<"+ feld[b]);}
        return (feld[a]<(feld[b]));
    }
    /**
     * vergleicht zwei Zahlen a und b auf Größe
     * @param a
     * @param b
     * @return wahr wenn a kleiner oder gleich b ist
     */
    public  boolean istKleinerGleich(int a, int b) {
        vglZaehler();
        if (geschwaetzig) {
            System.out.println("Vergleich:feld["+a+"]<=feld["+b+"] bzw. " +
                        feld[a] +">"+ feld[b]);}
        return (feld[a]<=(feld[b]));
    }
    /**
     * diese Methode zaehlt alle Vergleiche. Sie ist mt-sicher
     * für alle Algorithmen die das parallel Flag gesetzt haben
     */
     public void vglZaehler() {
         if (parallel) vergleichszaehlerParallel.getAndIncrement();
         else          vergleichszaehlerSeriell++;
    }
    /**
     * Tausche den Inhalt der Position a mit dem Inhalt der Position b
     * @param a
     * @param b
     */
    public  void tausche(int a, int b) {
        tZaehler();
        if (geschwaetzig)
                System.out.println("Getauscht:feld["+a+"<->"+b+"];f["+a
                            + "]="+feld[b]+";feld["+b+"]="+feld[a]);
        int s = feld[a];
        feld[a] = feld[b];
        feld[b] = s;
    }
    /**
     * diese Methode zaehlt alle Vertauschungen. Sie ist mt-sicher
     * für alle Algorithmen die das parallel Flag gesetzt haben
     */
    public void tZaehler() {
        if (parallel) tauschZaehlerParallel.getAndIncrement();
        else          tauschZaehlerSeriell++;
    }
    /**
     * Belege das Feld mit Zufallswerten. Alte Belegungen werden gelöscht!
     */
    public void generiereZufallsbelegung() {
        // Generiere neue Belegung
        maxWert = 2 * feld.length;
        for (int i = 0; i < feld.length; i++) {
            feld[i]=(int)(Math.random() * (double) maxWert);
        }
    }
    /**
    * Setzt Zaehler für Vertauschungen und Vergleiche zurueck auf Null
    */
    public void zaehlerRuecksetzen() {
        if (parallel) {
            tauschZaehlerParallel.set(0);
            vergleichszaehlerParallel.set(0);
        }
        else {
            tauschZaehlerSeriell = 0;
            vergleichszaehlerSeriell = 0;
        }
    }
}