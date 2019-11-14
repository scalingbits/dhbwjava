package s1.block5;

public class Verkaeufer {

    private String name;
    private double gewinn;
    private double gebundeneMittel;
    private Kraftwagen[] meineWagen;

    public Verkaeufer(String nam) {
        meineWagen = new Kraftwagen[2];
        name = nam;
        gewinn = 0.0;
    }

    public String get_name(){return name;}

    public void neuerWagen(int pos, Kraftwagen w) {
        if ((pos >= 0) && (pos < 2)) {
            meineWagen[pos] = w;
        }

    }

    public Kraftwagen imBestand(int pos) {
        if ((pos >= 0) && (pos < 2)) {
            return meineWagen[pos];
        } else {
            return null;
        }
    }

    public Kraftwagen verkaufeFahrzeug(int pos, double erloes) {
        Kraftwagen result;
        if (erloes < meineWagen[pos].get_Vpreis()) {
            System.out.println("Wagen mit Kennzeichen " +
                    meineWagen[pos].get_kennzeichen() +
                    " sollte unter Einkaufspreis verkauft werden.");
            result = null;
        } else {
            gewinn += erloes-meineWagen[pos].get_Epreis();
            result = meineWagen[pos];
            meineWagen[pos] = null; // Wagen gehört nicht mehr zum Bestand
        }
        return result;
    }

    public int fahrzeugeInFlotte() {
        int result = 0;
        int i = 0;
        while (i < meineWagen.length) {
            if (meineWagen[i] != null) {
                result++;
            }
            i++;
        }
        return result;
    }

    public double gebundeneMittel() {
        double result = 0.0;
        for (int i = 0; i < meineWagen.length; i++) {
            if (meineWagen[i] != null) {
                result += meineWagen[i].get_Epreis();
            }
        }
        return result;
    }

    public double geplanterUmsatz() {
        double result = 0.0;
        for (int i = 0; i < meineWagen.length; i++) {
            if (meineWagen[i] != null) {
                result += meineWagen[i].get_Vpreis();
            }
        }
        return result;
    }

    public double get_gewinn() {return gewinn;}

    public void drucken() {
        Kraftwagen w1 = imBestand(0);
        Kraftwagen w2 = imBestand(1);

        System.out.println("<*** Verkäufername : " + name + " ***>");
        System.out.println("Erlös bisher: " + gewinn);
        System.out.println("Gebundene Mittel: " + gebundeneMittel());
        System.out.println("Geplanter Umsatz: " + geplanterUmsatz());
        System.out.println("Fahrzeuge in Flotte: " + fahrzeugeInFlotte());
        if (w1 != null) w1.drucken();
        if (w2 != null) w2.drucken();
        System.out.println("<*********************************>");
    }

    public static void main(String[] args) {
        Kraftwagen w1 = new Kraftwagen(20000.00, 30000.00, "M-S 1234");
        Kraftwagen w2 = new Kraftwagen(10000.00, 15000.00, "B-A 5678");
        Kraftwagen w3 = new Kraftwagen(5000.00, 10000.00, "D-T 8901");

        Verkaeufer v1 = new Verkaeufer("Hans");
        v1.neuerWagen(0, w1);
        v1.neuerWagen(1, w2);
        v1.drucken();

        Kraftwagen verkWagen = v1.verkaufeFahrzeug(0, 50000);
        System.out.println("Verkaufter Wagen: " + verkWagen.get_kennzeichen());
        v1.drucken();
    }
}

