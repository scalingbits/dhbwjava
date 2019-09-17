package s1.block4;

public class FibonacciCached {

    private static long[] cache;
    private static int cacheSize = 93;

    private static long fib(int f) {
        long ergebnis = 0;
        if (cache[f] == -1) {
            switch (f) {
                case 0: {
                    cache[0] = 0;
                    break;
                }
                case 1: {
                    cache[1] = 1;
                    break;
                }
                default: { // Die Rekursion
                    cache[f] = fib(f - 1) + fib(f - 2);
                    break;
                }
            }
        }
        return cache[f];
    }

    private static void initialisiereCache() {
        cache = new long[cacheSize];
        for (int i = 0; i < cache.length; i++) {
            // Die Belegung mit -1 bedeutet, 
            // dass der Fibonacciwert nicht berechnet ist
            cache[i] = -1;
        }
    }

    public static void main(String[] args) {
        int a = cacheSize;
        System.out.println("Fibonacciberechnung von fib(0) bis fib(" + a + ")");
        initialisiereCache();
        for (int i = 0; i < a; i++) {
            System.out.println("fib(" + i + ")= " + fib(i));
        }
    }
}
