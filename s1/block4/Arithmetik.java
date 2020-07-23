package s1.block4;

public class Arithmetik {

    /**
     * Liest von der Kommazeile zwei Ganzzahlen ein und multipliziert sie
     *
     * @param args Konsolenparameter
     **/
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        int c = 0;

        if (args.length > 1) {
            try {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
            }
        }
        // Kontrolle der Eingaben
        System.out.println("Eingabe a: " + a + "; b: " + b);

        c = mult(a, b);


        // Ergebnisprüfung
        System.out.print("Ergebnis c: " + c);
        if (c == a * b) {
            System.out.println(" (korrekt)");
        } else {
            System.out.println(" (falsch. Richtig ist " + (a * b) + ")");
        }
        
        System.out.println("Fibonacciberechnung");
        for (int i=0; i<1000; i++)
            System.out.println("f["+i+"]= " + fibo(i));          

    }

    private static int mult(int a, int b) {
        System.out.println("Berechne:[" + a + "," + b + "]");
        int z;

        if (a == 0) {
            z = 0;
        } else {
            z = b + mult((a - 1), b);
        }
        System.out.println("z= " + z + " [" + a + "," + b + "]");
        return z;
    }

    private static int fibo(int f) {
        int ergebnis;

        if (f == 0) {
            ergebnis = 0;
        } else if (f == 1) {
            ergebnis = 1;
        } else {
            ergebnis = fibo(f - 1) + fibo(f - 2);
        }

        return ergebnis;
    }
}
