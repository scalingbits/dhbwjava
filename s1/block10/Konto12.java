package s1.block10;
public class Konto12 {
    int betrag;
    private final int ueberweisungsLimit;
    private static final int MINLIMIT =1;
    public static final int OK = 0;
    public static final int NEGATIVERWERT = 1;
    public static final int LIMITUEBERSCHRITTEN = 2;
    public Konto12(int startBetrag, int ll) {
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
    public void ueberweisenAuf(Konto12 b, int wert) throws Ueberweisungsausnahme12  {
        if (wert < 0) throw new Ueberweisungsausnahme12("Negativer Wert" + wert);
        else {
            int maxlimit = Math.min(ueberweisungsLimit, b.ueberweisungsLimit);
            if (wert > maxlimit )
                throw new LimitAusnahme("Limit ueberschritten " + wert,
                        maxlimit);
            else {
                auszahlen(wert);
                b.einzahlen(wert);
            }
        }
    }
    @Override
    public String toString() {return betrag + " Euro";}
    /**
     * Die main Methode sei eine Methode die von einem Team gepflegt wird
     * welches nichts von der internen Implementierung der Klasse kennt.
     * Die Methode wurde nur aus Gründen der Kompaktheit in dieser Klasse
     * implementiert
     * @param args
     */
    public static void main(String[] args) {
        Konto12 a1 = new Konto12(500, 50);
        Konto12 a2 = new Konto12(100, 80);
        int status;
        try {
            a2.ueberweisenAuf(a1, 50);
            System.out.println("a1: "+ a1 + "; a2= " +a2);
            a2.ueberweisenAuf(a1, -500);
            System.out.println("a1: "+ a1 + "; a2= " +a2);
            int betrag = 100;
            try {
                a2.ueberweisenAuf(a1, betrag);
            }
            catch (LimitAusnahme ue) {
                // Splitte Überweisung in mehrere unter des Limits
                int dasLimit = ue.limit;
                while (betrag > dasLimit) {
                    betrag = betrag - dasLimit;
                    a2.ueberweisenAuf(a1, dasLimit);
                    System.out.println("a1: "+ a1 + "; a2= " +a2);
                }
                a2.ueberweisenAuf(a1, betrag);
            }
            System.out.println("a1: "+ a1 + "; a2= " +a2);
        }
        catch (Ueberweisungsausnahme12 ue) {
            System.out.println("Fehler aufgetreten " + ue.getMessage());
            System.out.println ("Eine Überweisung wurde nicht ausgeführt");
        }
    }
}