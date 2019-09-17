package s1.block4;

public class Fibonacci {

    private static int tiefe = 0;

    private static long fib(int f) {
        tiefe++;
        System.out.println("tiefe: " + tiefe + " Berechne fib(" + f + ")");
        long ergebnis;
        switch (f) {

            case 0: {
                ergebnis = 0;
                break;
            }
            case 1: {
                ergebnis = 1;
                break;
            }
            default: { // Die Rekursion
                ergebnis = fib(f - 1) + fib(f - 2);
                break;
            }

        }
        tiefe--;
        return ergebnis;
    }

    public static void main(String[] args) {
        int a = 20;
        System.out.println("Fibonacciberechnung von fib(0) bis fib(" + a + ")");
        for (int i = 0; i <= a; i++) {
            System.out.println("fib(" + i + ")= " + fib(i));
        }
    }

}
