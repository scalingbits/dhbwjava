package s1.block6.reference;
/**
 *
 * @author s@scalingbits.com
 */
public class StringIntern {
    public static void main(String[] s) {

        String a = "Test";
        String b = a.intern();
        String c = "Test";
        String d = c.intern();
        String e = "Test";
        if (a == c) System.out.println
                ("a,c sind die gleichen Objekte");
        if (b == d) System.out.println
                ("b,d sind die gleichen Objekte"+
                        " im Stringpool");
        if (d == e) System.out.println
                ("d,e sind die gleichen Objekte"+
                        " im Stringpool");
    }
}

