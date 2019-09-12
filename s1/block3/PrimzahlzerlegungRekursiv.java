package block3;

// Gute Kandidaten
// 2^30-1 = 1073741823
// 2^31-1 = 2147483647
public class PrimzahlzerlegungRekursiv {

    public static void main(String[] args) {
        int firstArg = 0;
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
        System.out.println("Eingelesene Zahl: " + p);
        zerlege(p);
        time = System.nanoTime() - time;
            System.out.println("Zeit in m: " + time);
    }
    
    public static void zerlege(long p) {
        if (p<2) System.out.println("Ende der Rekursion");
        else {
           long i = 2; 
           while ((p % i != 0) && ((i*i)<=p)) i++;
           System.out.println("Primfaktor: " + i);
           zerlege(p/i);
        }

    }
}
