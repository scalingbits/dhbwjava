package s1.block2;

/**
 *
 * @author s@scalingbits.com
 */
@SuppressWarnings("ConstantConditions")
public class AllowedAssigments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long a = 3;
        int b = 4;
        short c = 5;
        byte d = 6;

        a = b + 3 * (d + 1);
        b = c * c;
        c = (byte)(b / 3);
        d = (byte)(((byte)a + b));
        d = (byte) ( a + b);
    }

}
