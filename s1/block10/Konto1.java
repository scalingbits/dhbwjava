package s1.block10;
public class Konto1 {
    int betrag;
    public Konto1(int startBetrag) {
        betrag = startBetrag;
    }
    private void einzahlen(int b) {
        betrag += b;
    }
    private void auszahlen(int b) {
        betrag -= b;
    }
    public void ueberweisenAuf (Konto1 b, int wert) {
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
        Konto1 a1 = new Konto1(500);
        Konto1 a2 = new Konto1(100);
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}
