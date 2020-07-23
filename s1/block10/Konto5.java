package s1.block10;
public class Konto5 {
    int betrag;
    private final int ueberweisungsLimit;
    private static final int MINLIMIT =1;
    public Konto5(int startBetrag, int ll) {
        betrag = startBetrag;
        if (ll>0) ueberweisungsLimit=ll;
        else ueberweisungsLimit = MINLIMIT;
    }
    private void einzahlen(int b) {
        assert (b>=0);
        betrag += b;
    }
    private void auszahlen(int b) {
        assert (b>=0);
        betrag -= b;
    }
    public void ueberweisenAuf (Konto5 b, int wert) {
        assert(wert>=0);
        auszahlen(wert);
        b.einzahlen(wert);
    }
    @Override
    public String toString() {return betrag + " Euro";}
    /**
     * Die main Methode sei eine Methode die von einem Team gepflegt wird
     * welches nichts von der internen Implementierung der Klasse weis.
     * Die Methode wurde nur aus Gründen der Kompaktheit in dieser Klasse
     * implementiert
     * @param args Kommandozeilenparameter (nicht benötigt)
     */
    public static void main(String[] args) {
        Konto5 a1 = new Konto5(500, 50);
        Konto5 a2 = new Konto5(100, 80);
        boolean korrekt;
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, 100);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}