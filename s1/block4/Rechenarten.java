package s1.block4;

public class Rechenarten {

    private static double add(double a, double b) {
        return (a + b);
    }

    private static double sub(double a, double b) {
        return (a - b);
    }

    private static double mul(double a, double b) {
        return (a * b);
    }

    private static double div(double a, double b) {
        return (a / b);
    }

    private static int add(int a, int b) {
        return (a + b);
    }

    private static int sub(int a, int b) {
        return (a - b);
    }

    private static int mul(int a, int b) {
        return (a * b);
    }

    private static int div(int a, int b) {
        return (a / b);

    }

    public static void main(String[] args) {
        double ergebnis1;
        int ergebnis2;

        ergebnis1 = add(5.0, 4.0);
        System.out.println(" 5.0 + 4.0 = " + ergebnis1);
        ergebnis1 = div(9.0, 4.0);
        System.out.println(" 9.0 / 4.0 = " + ergebnis1);
        ergebnis1 = sub(9.0, 4.0);
        System.out.println(" 9.0 - 4.0 = " + ergebnis1);
        ergebnis1 = add(div(9.0, 4.0), 3.0);
        System.out.println(" 9.0 / 4.0 + 3.0 = " + ergebnis1);

        ergebnis2 = add(5, 4);
        System.out.println(" 5 + 4 = " + add(5, 4));
        ergebnis2 = div(9, 4);
        System.out.println(" 9 / 4 = " + div(9, 4));
        ergebnis2 = sub(9, 4);
        System.out.println(" 9 - 4 = " + sub(9, 4));
        ergebnis2 = add(div(9, 4), 3);
        System.out.println(" 9 / 4 + 3 = " + add(div(9, 4), 3));
    }
}
