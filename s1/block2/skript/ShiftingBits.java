package s1.block2.skript;
public class ShiftingBits {
    public static void main(String[] args) {
        int x = 4;
        int result;
        int shift = 1;

        result = x << shift;
        System.out.println("x = " + x + "; shift = " + shift + " result = " + result);

        result = x >> shift;
        System.out.println("x = " + x + "; shift = " + shift + " result = " + result);
        result = result >> shift;
        System.out.println("x = " + x + "; shift = " + shift + " result = " + result);
        result = result >> shift;
        System.out.println("x = " + x + "; shift = " + shift + " result = " + result);
        result = result >> shift;
        System.out.println("x = " + x + "; shift = " + shift + " result = " + result);
    }

}
