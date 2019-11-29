package s1.block10;
public class Konto2 {
    int betrag;
    public Konto2(int startBetrag) {
        betrag = startBetrag;
    }
    private boolean einzahlen(int b) {
        if (b>=0) {
            betrag += b;
            return true;
        }
        else return false;
    }
    private boolean auszahlen(int b) {
        if (b>=0) {
            betrag -= b;
            return true;
        }
        else return false;
    }
    public boolean ueberweisenAuf (Konto2 b, int wert) {
        boolean korrekt;
        korrekt = auszahlen(wert);
        if (korrekt)
            korrekt= b.einzahlen(wert);
        return korrekt;
    }
    @Override
    public String toString() {return betrag + " Euro";}
    /**
     * Die main Methode sei eine Methode die von einem Team gepflegt wird
     * welches nicht die interne Implementierung der Klasse.
     * Die Methode wurde nur aus Gründen der Kompaktheit in dieser Klasse
     * implementiert
     * @param args
     */
    public static void main(String[] args) {
        Konto2 a1 = new Konto2(500);
        Konto2 a2 = new Konto2(100);
        boolean korrekt;
        korrekt = a2.ueberweisenAuf(a1, 50);
        if (korrekt)
            System.out.println("a1: "+ a1 + "; a2= " +a2);
        else
            System.out.println("Fehler; a1: "+ a1 + "; a2= " +a2);
        korrekt = a2.ueberweisenAuf(a1, -500);
        if (korrekt)
            System.out.println("a1: "+ a1 + "; a2= " +a2);
        else
            System.out.println("Fehler; a1: "+ a1 + "; a2= " +a2);
    }
}