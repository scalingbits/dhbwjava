package s1.block10;
public class Konto7 {
    int betrag;
    private int ueberweisungsLimit;
    private static final int MINLIMIT =1;
    public static final int OK = 0;
    public static final int NEGATIVERWERT = 1;
    public static final int LIMITUEBERSCHRITTEN = 2;
    public Konto7(int startBetrag, int ll) {
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
    public void ueberweisenAuf (Konto7 b, int wert) {
        if (wert < 0) throw new IllegalArgumentException("Negativer Wert " + wert);
        else
        if (wert > ueberweisungsLimit )
            throw new IllegalArgumentException("Limit ueberschritten " + wert
                    + "; Limit: " + ueberweisungsLimit);
        else
        if (wert > b.ueberweisungsLimit )
            throw new IllegalArgumentException("Limit ueberschritten " + wert
                    + "; Limit: " + b.ueberweisungsLimit);
        else {
            auszahlen(wert);
            b.einzahlen(wert);
        }
    }
    @Override
    public String toString() {return betrag + " Euro";}
    /**
     * Die main Methode sei eine Methode die von einem Team gepflegt wird
     * welches nichts von der internen Implementierung der Klasse weis.
     * Die Methode wurde nur aus Gründen der Kompaktheit in dieser Klasse
     * implementiert
     * @param args
     */
    public static void main(String[] args) {
        Konto7 a1 = new Konto7(500, 50);
        Konto7 a2 = new Konto7(100, 80);
        int status;
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, 100);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}