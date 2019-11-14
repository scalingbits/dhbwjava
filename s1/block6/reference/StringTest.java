package s1.block6.reference;

/**
 *
 * @author s@scalingbits.com
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "John";
        String b = a;
        String c = "John";
        String d = "Jo" + "hn"; // Der konstante Ausdruck wird schon bei der Übersetzung aufgelöst!
        String e = "John";

        if (a == b) {
            System.out.println(" a und b zeigen auf das gleiche Objekt");
        } else {
            System.out.println(" a und b zeigen nicht auf das gleiche Objekt");
        }
        if (a == c) {
            System.out.println(" a und c zeigen auf das gleiche Objekt");
        } else {
            System.out.println(" a und c zeigen nicht auf das gleiche Objekt");
        }
        if (a == d) {
            System.out.println(" a und d zeigen auf das gleiche Objekt");
        } else {
            System.out.println(" a und d zeigen nicht auf das gleiche Objekt");
        }
        if (a == e) {
            System.out.println(" a und e zeigen auf das gleiche Objekt");
        } else {
            System.out.println(" a und e zeigen nicht auf das gleiche Objekt");
        }
        if (a.equals(b)) {
            System.out.println(" a und b sind gleiche Zeichenketten");
        } else {
            System.out.println(" a und b sind nicht gleiche Zeichenketten");
        }
        if (a.equals(c)) {
            System.out.println(" a und c sind gleiche Zeichenketten");
        } else {
            System.out.println(" a und c sind nicht gleiche Zeichenketten");
        }
        if (a.equals(d)) {
            System.out.println(" a und d sind gleiche Zeichenketten");
        } else {
            System.out.println(" a und d sind nicht gleiche Zeichenketten");
        }
        if (a.equals(e)) {
            System.out.println(" a und e sind gleiche Zeichenketten");
        } else {
            System.out.println(" a und e sind nicht gleiche Zeichenketten");
        }
    }
}