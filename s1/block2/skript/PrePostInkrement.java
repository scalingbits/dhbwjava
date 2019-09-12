package s1.block2.skript;

/**
 *
 * @author s@scalingbits.com
 */
public class PrePostInkrement {
    public static void main(String[] args) {
        int i = 4;
        int j;

        j=i-- -i;
        System.out.println("i: " +i+", j= "+j);
    }
} 
