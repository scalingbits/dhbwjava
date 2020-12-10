package s1.block10;
public class Konto4 {
    int betrag;
    public Konto4(int startBetrag) {
        betrag = startBetrag;
    }
    private void einzahlen(int b) {
        assert (b>=0);
        betrag += b;
    }
    private void auszahlen(int b) {
        assert (b>=0);
        betrag -= b;
    }
    public void ueberweisenAuf (Konto4 k, int wert) {
        assert(wert>=0): "Versuch einer negativen Überweisung von " + wert ;
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
        Konto4 a1 = new Konto4(500);
        Konto4 a2 = new Konto4(100);
        boolean korrekt;
        a2.ueberweisenAuf(a1, 50);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
        a2.ueberweisenAuf(a1, -500);
        System.out.println("a1: "+ a1 + "; a2= " +a2);
    }
}