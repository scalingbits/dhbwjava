package s1.block10;
public class Konto3 {
    int betrag;
    public Konto3(int startBetrag) {
        betrag = startBetrag;
    }
    private void einzahlen(int b) {
        assert (b>=0): "Versuch " + b + " zu einzuzahlen";
        betrag += b;
    }
    private void auszahlen(int b) {
        assert (b>=0): "Versuch " + b + " zu auszuzahlen";
        betrag -= b;
    }
    public void ueberweisenAuf (Konto3 b, int wert) {
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
        Konto3 a1 = new Konto3(500);
        Konto3 a2 = new Konto3(100);
        boolean korrekt;
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}