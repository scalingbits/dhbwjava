package s1.block10;
public class Grundrechenarten2 {

    public static int division2(int a, int b) {
        DivisionException ex;
        if (b==0) {
            ex = new DivisionException(a,b);
            throw ex;
        }
        return a/b;
    }

    public static void main(String[] args) {
        int c = division2(3,0);
    }

}
