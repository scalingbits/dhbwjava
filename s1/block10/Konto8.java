package s1.block10;
public class Konto8 {
    int betrag;
    private final int ueberweisungsLimit;
    private static final int MINLIMIT =1;
    public static final int OK = 0;
    public static final int NEGATIVERWERT = 1;
    public static final int LIMITUEBERSCHRITTEN = 2;
    public Konto8(int startBetrag, int ll) {
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
    public void ueberweisenAuf (Konto8 k, int wert) {
        if (wert < 0) throw new UeberweisungsAusnahme("Negativer Wert" + wert);
        else
        if (wert > ueberweisungsLimit )
            throw new UeberweisungsAusnahme("Limit ueberschritten " + wert
                    + "; Limit: " + ueberweisungsLimit);
        else
        if (wert > k.ueberweisungsLimit )
            throw new UeberweisungsAusnahme("Limit ueberschritten " + wert
                    + "; Limit: " + k.ueberweisungsLimit);
        else {
            auszahlen(wert);
            k.einzahlen(wert);
        }
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
        Konto8 a1 = new Konto8(500, 50);
        Konto8 a2 = new Konto8(100, 80);
        int status;
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, 100);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}