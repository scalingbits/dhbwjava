package s1.block10;

public class Frage8 {

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
        try {
            d = 2 * divide(a, b);
        }
        catch (RuntimeException e) {
            System.out.println("doubleDiv: Division durch Null");
            d=-2;
        }
        System.out.println("doubleDiv:after");
        return d;
    }

    static int divide(int a, int b) {
        int d;
        System.out.println("divide:before");
        try {
            d = a / b;
        }
        catch (IllegalArgumentException e) {
            System.out.println("divide: Division durch Null");
            d = -1;
        }
        System.out.println("divide:after");
        return d;
    } // Ende main()
} // Ende der Klasse