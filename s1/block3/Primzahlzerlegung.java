package block3;

// Gute Kandidaten
// 2^30-1 = 1073741823
// 2^31-1 = 2147483647
public class Primzahlzerlegung {

    public static void main(String[] args) {
        
        long p = 1;
        long time;
        time = System.nanoTime();
        if (args.length > 0) {
            try {
                p = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
            }
        }
        long i = 2;
        System.out.println("Eingelesene Zahl: " + p);
        while ((p > 1) && (i <= p)) {
            if (p % i == 0) {
                System.out.println("Primfaktor: " + i);
                p = p / i;
                i = 2;
            } else {
                if (i > Math.sqrt(p)) {
                    // Beende Suche wenn Wurzel von P erreicht
                    i = p;
                } else {
                    i++;
                }
            }
            time = System.nanoTime() - time;
            System.out.println("Zeit in m: " + time);
        }
    }
}
