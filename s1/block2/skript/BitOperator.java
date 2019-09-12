package s1.block2.skript;
public class BitOperator {
    public static void main(String[] args) {
        int a = 7;
        int b = 6;
        int result;

        result = a & b;
        System.out.println("a = " + a + "; b = " + b + " result = " + result);

        result = a | b;
        System.out.println("a = " + a + "; b = " + b + " result = " + result);

        result = a ^ b;
        System.out.println("a = " + a + "; b = " + b + " result = " + result);
    }
}
