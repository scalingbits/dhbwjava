package s1.block5;

public class Punkt {
        private double x;
        private double y;

        public Punkt (double xKoord, double yKoord) {
            x = xKoord;
            y = yKoord;
        }

        public Punkt (Punkt p) { this(p.x,p.y);}

        public Punkt () { this(0,0); }

    public static void main(String[] args) {
        Punkt p1 = new Punkt();           // Initialisierung mit (0,0)
        Punkt p2 = new Punkt(1.1D, 2.2D); // Initialisierung mit (1.1,2.2)
        Punkt p3 = new Punkt(p2);         // Initialisierung mit (1.1,2.2) durch Punkt p2
    }
}
