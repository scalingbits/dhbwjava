package s1.array;
/**
 *
 * @author s@scalingbits.com
 */
public class Zufallszahlen {
    /**
     * Drucke dreiminensionale Felder
     * @param feld dieses Feld wird gedruckt
     */
    private static void feldDrucken(int[][][] feld) {
        for (int i=0; i<feld.length; i++) {
            System.out.println("*** Kubusebene["+i+"] ***");
            feldDrucken(feld[i]);
        }
    }
    /**
     * Drucke zweidinensionale Felder
     * @param feld dieses Feld wird gedruckt
     */
    private static void feldDrucken(int[][] feld) {
        for (int i=0; i<feld.length; i++) {
            System.out.print("["+i+"]: ");
            feldDrucken(feld[i]);
            System.out.println(); // Zeilenumbruch provozieren
        }
    }
    /**
     * Drucke eindinensionale Felder
     * @param feld dieses Feld wird gedruckt
     */
    private static void feldDrucken(int[] feld) {
        for (int i=0; i<feld.length; i++) {
            System.out.print(" "+feld[i]+" |"); // kein Zeilenumbruch
        }
    }
    /**
     * Suche die am häufigsten vorkommende Zahl
     * @param feld Feld mit Häufigkeiten
     * @return die haeufigste Zahl
     */
    private static int haeufigsteZahl(int[][][] feld) {
        int max = -1;
        int ergebnis = 0;
        for (int i=0; i<feld.length; i++)
            for (int j=0; j<feld[i].length; j++)
                for (int k=0; k<feld[i][j].length;k++)
                    if (feld[i][j][k] > max) {
                        max = feld[i][j][k];
                        ergebnis=i*100+j*10+k;
                    }
        System.out.println("Häufigste Vorkommen: " + max);
        return ergebnis;
    }
    /**
     * Suche die am seltensten vorkommende Zahl
     * @param feld Feld mit Häufigkeiten
     * @return das Eregebnis
     */
    private static int seltensteZahl(int[][][] feld) {
        int min = Integer.MAX_VALUE;
        int ergebnis = 0;
        for (int i=0; i<feld.length; i++)
            for (int j=0; j<feld[i].length; j++)
                for (int k=0; k<feld[i][j].length;k++)
                    if (feld[i][j][k] < min) {
                        min = feld[i][j][k];
                        ergebnis=i*100+j*10+k;
                    }
        System.out.println("Seltenstes Vorkommen: " + min);
        return ergebnis;
    }
    public static void main(String[] args) {
        int sampleSize = 1000000;
        int[] sample = new int[sampleSize];
        System.out.println("Feld mit " + sampleSize + " Zellen angelegt." );
        for (int i=0; i<1000000; i++)
            sample[i] = (int)(Math.random()* 1000D);
        System.out.println("Feld mit " + sampleSize + " Zufallszahlen belegt." );
        int[][][] verteilung = new int[10][10][10];
        for (int wert: sample) {
            verteilung[(wert/100)%10][(wert/10)%10][wert%10]++;
        }
        System.out.println("Verteilungsfeld belegt mit " + sampleSize + " Zufallszahlen." );
        feldDrucken(verteilung);
        System.out.println("Suche häufigst vorkommende Zahl");
        System.out.println("Häufigste Zahl " + haeufigsteZahl(verteilung));
        System.out.println("Suche seltenst vorkommende Zahl");
        System.out.println("Seltenste Zahl " + seltensteZahl(verteilung));
    }
}