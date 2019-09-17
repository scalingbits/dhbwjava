package s1.block4;

/**
 *
 * @author s@scalingbits.com
 */
public class Hanoi {

    private static void bewegeScheiben(int scheiben,
                                       String von,
                                       String nach,
                                       String hilfsstab){
        if (scheiben > 0) {
            bewegeScheiben(scheiben-1, von, hilfsstab,nach);
            System.out.println(scheiben + ".te Scheibe von " + von + " nach " + nach );
            bewegeScheiben(scheiben-1, hilfsstab, nach, von);
            }
        }

    public static void main(String[] args) {
     bewegeScheiben(6, "links", "mitte", "rechts");
    }

}
