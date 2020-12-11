package s1.block10;

public class Frage4 {

    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int c = 0;
        System.out.println("main:before");
        c = doubleDiv(a, b);
        System.out.println("main:after");
    }

    static int doubleDiv(int a, int b) {
        int d;
        System.out.println("doubleDiv:before");
        d = 2 * divide(a, b);
        System.out.println("doubleDiv:after");
        return d;
    }

    static int divide(int a, int b) {
        int d;
        System.out.println("divide:before");
        d = a / b;
        System.out.println("divide:after");
        return b;
    }
} // Ende der Klasse