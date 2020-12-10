package s1.block10;
public class Konto6 {
    int betrag;
    private final int ueberweisungsLimit;
    private static final int MINLIMIT =1;
    public static final int OK = 0;
    public static final int NEGATIVERWERT = 1;
    public static final int LIMITUEBERSCHRITTEN = 2;
    public Konto6(int startBetrag, int ll) {
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
    public int ueberweisenAuf (Konto6 k, int wert) {
        if (wert < 0) return NEGATIVERWERT;
        else
        if ((wert > ueberweisungsLimit )|| (wert > k.ueberweisungsLimit ))
            return LIMITUEBERSCHRITTEN;
        else {
            auszahlen(wert);
            k.einzahlen(wert);
            return OK;
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
        Konto6 a1 = new Konto6(500, 50);
        Konto6 a2 = new Konto6(100, 80);
        int status;
        status = a2.ueberweisenAuf(a1, 50);
        if (status != OK)
            System.out.println("Fehler: " + status);
        else
            System.out.println("a1: "+ a1 + "; a2= " +a2);
        status = a2.ueberweisenAuf(a1, -500);
        if (status != OK)
            System.out.println("Fehler: " + status);
        else
            System.out.println("a1: "+ a1 + "; a2= " +a2);
        status = a2.ueberweisenAuf(a1, 100);
        if (status != OK)
            System.out.println("Fehler: " + status);
        else
            System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}