package s1.block5;

public class Kraftwagen {

    private double verkaufsPreis;
    private double einkaufsPreis;
    private String kennzeichen;

    public Kraftwagen(double ek, double vk, String nummernSchild) {

        // Initialisierung der Variablen mit einfachen Konsistenzprüfungen
        verkaufsPreis = (ek < vk) ? vk : ek;
        einkaufsPreis = (ek < vk) ? ek : vk;
        kennzeichen = nummernSchild;
    }

    public double get_Epreis() {
        return einkaufsPreis;
    }

    public void set_Epreis(double pr) {
        einkaufsPreis = pr;
    }

    public double get_Vpreis() {
        return verkaufsPreis;
    }

    public void set_Vpreis(double pr) {

        verkaufsPreis = pr;
    }

    public String get_kennzeichen() {
        return kennzeichen;
    }

    public void set_kennzeichen(String s) {
        kennzeichen = s;
    }


    public void drucken() {
        System.out.println("Einkaufspreis: " + einkaufsPreis);
        System.out.println("Verkaufspreis: " + verkaufsPreis);
        System.out.println("Kennzeichen: " + kennzeichen);
    }

    public static void Main (String args) {

    }

}