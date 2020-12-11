package s1.block10;

public class Frage3 {
    public static void main(String[] args) {
        int a = 5; int b = 0;
        int c = 0;
        System.out.println("main:Anfang");
        c = divAussen(a, b);
        System.out.println("main:Ende");
    } // Ende von main

    static int divAussen(int a, int b) {
        int d;
        System.out.println("divAussen:Anfang");
        try {
            d = 2 * divInnen(a, b);
        } catch (ArithmeticException e) {
            System.out.println("divAussen: Division durch Null");
            d = -2;
        }
        System.out.println("divAussen:Ende");
        return d;
    } // Ende von divAussen

    static int divInnen(int a, int b) {
        int d;
        System.out.println("divInnen:Anfang");
        try {
            d = a / b; // Hier tritt eine Ausnahme auf
        } catch (IllegalArgumentException e) {
            System.out.println("divInnen: Division durch Null");
            d = -1;
        } catch (RuntimeException e) {
            System.out.println("divInnen: Division durch Null;" + " RuntimeException");
            d = -2;
        }
        System.out.println("divInnen:Ende");
        return d;
    } // Ende von divInnen
} // Ende der Klasse.
