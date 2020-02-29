package s1.block5;
/**
 *
 * @author s@scalingbits.com
 */
public class Haendler {
    private Verkaeufer[] team;
    private String name;

    public Haendler(String n ) {
        name = n;
        team = new Verkaeufer[3];
    }

    public void einstellenTeam(String name1, String name2, String name3) {
        team[0] = new Verkaeufer(name1);
        team[1] = new Verkaeufer(name1);
        team[2] = new Verkaeufer(name1);
    }


    public void geschaeftsEroeffnung(Kraftwagen[] k) {
        team[0].neuerWagen(0, k[0]);
        team[1].neuerWagen(0, k[1]);
        team[2].neuerWagen(0, k[2]);
        team[0].neuerWagen(1, k[3]);
        team[1].neuerWagen(1, k[4]);
        team[2].neuerWagen(1, k[5]);
    }

    public double gesamtGewinn() {
        double g =0;
        for (int i=0; i<team.length; i++) {
            g += team[i].get_gewinn();
        }
        return g;
    }

    public double gesamtWertFuhrpark() {
        double g =0;
        for (int i=0; i<team.length; i++) {
            g += team[i].gebundeneMittel();
        }
        return g;
    }

    public double geplanterUmsatz() {
        double g =0;
        for (int i=0; i<team.length; i++) {
            g += team[i].geplanterUmsatz();
        }
        return g;
    }

    public Verkaeufer getVerkaeufer(int pos) {
        return team[pos];
    }

    public Kraftwagen verkaufeFahrzeug(int indexVerk, int indexWagen, double preis) {
        Verkaeufer v = team[indexVerk];
        return v.verkaufeFahrzeug(indexWagen, preis);
    }

    public void einstellenFahrzeug(int indexVerk, int indexWagen, Kraftwagen k) {
        Verkaeufer v = team[indexVerk];
        v.neuerWagen(indexWagen, k);
    }

    public void drucken() {
        System.out.println("*** Name Händler: " + name + " ***");
        System.out.println("Gesamter Wert der Flotte: " + gesamtWertFuhrpark());
        System.out.println("Gesamter Gewinn: " + gesamtGewinn());
        for (int i=0; i< team.length; i++) team[i].drucken();
    }

    public Verkaeufer besterVerkaeufer() {
        Verkaeufer bestSeller = team[0];
        for (int i=1; i<team.length; i++)
            if (team[i].get_gewinn() > bestSeller.get_gewinn())
                bestSeller = team[i];
        return bestSeller;
    }

    public static void main(String[] args){
        Kraftwagen[] flotte= new Kraftwagen[8];
        flotte[0] = new Kraftwagen(11111.11,22222.22,"A-A-11");
        flotte[1] = new Kraftwagen(22222.22,22222.22,"B-A-22");
        flotte[2] = new Kraftwagen(33333.33,44444.22,"C-A-33");
        flotte[3] = new Kraftwagen(44444.44,50000.22,"D-A-44");
        flotte[4] = new Kraftwagen(55555.55,60000.22,"E-A-55");
        flotte[5] = new Kraftwagen(66666.66,88888.22,"F-A-66");
        flotte[6] = new Kraftwagen(77777.77,80000.00,"G-A-77");
        flotte[7] = new Kraftwagen(88888.88,90000.00,"G-A-88");

        Haendler h = new Haendler("Gebrauchtwagen-Schmidt");
        h.einstellenTeam("Achim", "Bolle", "Caesar");
        h.geschaeftsEroeffnung(flotte);
        h.drucken();
        h.verkaufeFahrzeug(0, 0, 40404.04);
        h.einstellenFahrzeug(0, 0, flotte[7]);
        Verkaeufer v = h.besterVerkaeufer();
        System.out.println("Größter Gewinn von " + v.get_name());
        h.drucken();

    }

}