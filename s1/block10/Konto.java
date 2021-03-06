package s1.block10;
public class Konto {
    int betrag;
    public Konto(int startBetrag) {
        betrag = startBetrag;
    }
    private void einzahlen(int b) {
        betrag += b;
    }
    private void auszahlen(int b) {
        betrag -= b;
    }
    public void ueberweisenAuf (Konto k, int wert) {
        auszahlen(wert);
        k.einzahlen(wert);
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
        Konto a1 = new Konto(500);
        Konto a2 = new Konto(100);
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}