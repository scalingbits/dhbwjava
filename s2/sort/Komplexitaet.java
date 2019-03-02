package s2.sort;

public class Komplexitaet {

    private static int groesse = 1000;

    public static void main(String[] args) {
        algorithmus1(groesse);
        algorithmus2(groesse);
        algorithmus3(groesse);
        algorithmus4(groesse);
        algorithmus5(groesse);
        algorithmus6(groesse);
        algorithmus7(groesse);
        algorithmus8(groesse);
    }

    public static void algorithmus1(int n) {
        for (int i = 1; i < n; i++) {
            int k = i * 2;
        }
    }

    public static void algorithmus2(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < 1000; i++) {
                int k = j - i;
            }
        }
    }

    public static void algorithmus3(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < n; i++) {
                int k = j - i;
            }
        }
    }

    public static void algorithmus4(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < n; i++) {
                for (int k = 1; i < n; i++) {
                    int q = k - j - i;
                }
            }
        }
    }

    public static void algorithmus5(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; i < 1000; i++) {
                int k = j - i;
            }
            for (int j = 1; i < 1000; i++) {
                int k = j - i;
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
