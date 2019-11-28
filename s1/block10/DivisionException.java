package s1.block10;
public class DivisionException extends IllegalArgumentException {
    int dividend;
    int divisor;

    public DivisionException(int a, int b) {
        super ("Versuch von Division " + a + "/" + b);
        dividend =a;
        divisor = b;
    }
}
