package s1.block10;
import java.lang.IllegalArgumentException;

public class Grundrechenarten1 {
    public static int division(int a, int b) {
        IllegalArgumentException ex;
        if (b==0) {
            ex = new IllegalArgumentException("Division durch 0!");
            throw ex;
        }
        return a/b;
    }

    public static void main(String[] args) {
        int c = division(3,0);
    }

}
