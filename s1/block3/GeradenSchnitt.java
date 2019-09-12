package block3;

public class GeradenSchnitt {

    public static void main(String[] args) {
        double a1 = 0.0;
        double a2 = 0.0;
        double b  = 0.0;
        double c  = 0.0;
        double d1 = 0.0;
        double d2 = 0.0;
        double tmp;
        if (args.length > 5) {
            try {
                a1 = Double.parseDouble(args[0]);
                a2 = Double.parseDouble(args[1]);
                b  = Double.parseDouble(args[2]);
                c  = Double.parseDouble(args[3]);
                d1 = Double.parseDouble(args[4]);
                d2 = Double.parseDouble(args[5]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Fließkommazahl sein");
                System.exit(1);
            }
        }
        System.out.println("Linie 1: (" + a1 + "," + b + ") bis ("
                + a2 + "," + b + ")");
        System.out.println("Linie 2: (" + c + "," + d1 + ") bis ("
                + c + "," + d2 + ")");
        // Schnittpunkt ist (c,b)
        // Sortieren von a1, a2 .
        if (a1 > a2) {
            tmp = a1; a1 = a2; a2 = tmp;}
        // Sortieren von d1, d2 .
        if (d1 > d2) {
            tmp = d1;
            d1 = d2;
            d2 = tmp;
        }
        System.out.println("Nach sortieren...");
        System.out.println("Linie 1: (" + a1 + "," + b + ") bis ("
                + a2 + "," + b + ")");
        System.out.println("Linie 2: (" + c + "," + d1 + ") bis ("
                + c + "," + d2 + ")");
        if ((a1 <= c) && (c <= a2) && (d1 <= b) && (b <= a2)) 
            System.out.println("Die beiden Strecken schneiden sich");
        else
          System.out.println("Die beiden Strecken schneiden sich nicht");
    }
}
