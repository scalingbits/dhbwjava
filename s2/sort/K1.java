package s2.sort;

public class K1 {

    private static int groesse = 1000;

    public static void main(String[] args) {
        algorithmusBsp(groesse);
        algorithmus1(groesse);
        algorithmus2(groesse);
        algorithmus3(groesse);
        algorithmus4(groesse);
    }

    public static void algorithmusBsp(int n) {
        for (int i = 1; i < n; i++) {
            int k = i * 2;
            }
        for (int j = 1; j < n; j++) {
            int k = j * 3;
        }
    }

    public static void algorithmus1(int n) {
        for (int i = 1; i < n; i++) {
            int k = i * 2;
        }
        for (int i = 1; i < 1000; i++) {
            int k = i +2;
        }
    }


    public static void algorithmus2(int n) {
        for (int i = 1; i < n; i++) {
            int p = n;
            for (int j = 1; i < p; i++) {
                int k = j - i;
            }
        }
    }

    public static void algorithmus3(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < n; i++) {
                for (int k = 1; i < n; i++) {
                    int q = k - j - i;
                }
                int p=0;
                while (p<n) {
                    p++;
                    int r = n*p;
                }
            }
        }
    }

    public static void algorithmus4(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < 1000; i++) {
                algorithmus2(n);
            }
        }
    }

    public static void algorithmus6(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = j - i;
            }
        }
    }

    public static void algorithmus7(int n) {
        for (int i = 1; i < 2000; i++) {
            int j = 0;
            while (j < 1000) {
                j++;
                int k = 2 * j;
            }
        }
    }

    public static void algorithmus8(int n) {
        for (int i = 1; i < n; i++) {
            algorithmus1(n);
        }
    }

}  // Ende der Klasse
