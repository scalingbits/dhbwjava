package s1.block5;

public class Vektor {

    private double x;
    private double y;

    Vektor(double xx, double yy) {
        x = xx;
        y = yy;
        normalisierung();
    }

    public void normalisierung() {
        double laenge = Math.sqrt(x*x+y*y);
        x = x/laenge;
        y = y/laenge;
    }

    public void addition(Vektor v) {
        x = v.x + x;
        y = v.y + y;
        normalisierung();
    }
    public void multi(double skalar) {
        x = x * skalar;
        y = y * skalar;
        // normalisierung();
    }
    public void skalarprodukt(Vektor v) {
        x = x * v.x;
        y = y * v.y;
        normalisierung();
    }
    public void drucken() {
        System.out.println("(" + x + "," + y + ")");
    }

    public static void main(String[] args) {
        Vektor a = new Vektor(1.0, 2.0);
        Vektor b = new Vektor(2.0, 1.0);
        Vektor c = new Vektor(3.0, 3.0);

        a.drucken();
        b.drucken();
        c.drucken();

        a.addition(b);
        a.drucken();
        a.multi(10);
        a.drucken();
        b.skalarprodukt(c);
        b.drucken();
    }
}
