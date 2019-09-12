package s1.block2;

/**
 *
 * @author s@scalingbits.com
 */
public class InterneRep {

    public static void main(String[] args) {
        byte b  = Byte.MIN_VALUE;
        short s = Short.MAX_VALUE;
        char c  = Character.MAX_VALUE;
        int in  = Integer.MAX_VALUE;
        in = 16;
        long l  = Long.MAX_VALUE;
        int[] result;
        
        result = decode(b);
        System.out.print("Byte: " + b + "=");
        for (int i = (result.length-1); i >= 0; i--)
            System.out.print(result[i]);
        System.out.println(";");
        
        result = decode(s);
        System.out.print("Short: " + s + "=");
        for (int i = (result.length-1); i >= 0; i--)
            System.out.print(result[i]);
        System.out.println(";");
        
        result = decode(c);
        System.out.print("Char: " + c + "=");
        for (int i = (result.length-1); i >= 0; i--)
            System.out.print(result[i]);
        System.out.println(";");
        
        result = decode(in);
        System.out.print("Integer: " + in + "=");
        for (int i = (result.length-1); i >= 0; i--)
            System.out.print(result[i]);
        System.out.println(";");
        System.out.println("Integer: " + in + "=" + Integer.toBinaryString(in));
        
        result = decode(l);
        System.out.print("Long: " + l + "=");
        for (int i = (result.length-1); i >= 0; i--)
            System.out.print(result[i]);
        System.out.println(";");
        
        
    }

    public static int[] decode(byte s) {
        int size = 8;
        int[] stellen = new int[size];
        int p = 1;
        for (int i = 0; i <size; i++) {
            stellen[i] = (p & s) >> i;
            p = p<<1;
        }
        return stellen;
    }
    public static int[] decode(short s) {
        int size = 16;
        int[] stellen = new int[size];
        int p = 1;
        for (int i = 0; i <size; i++) {
            stellen[i] = (p & s) >> i;
            p = p<<1;
        }
        return stellen;
    }
    
    public static int[] decode(char s) {
        return decode((short)s);
    }

    public static int[] decode(int s) {
        int size = 32;
        int[] stellen = new int[size];
        int p = 1;
        for (int i = 0; i <size; i++) {
            stellen[i] = (p & s) >> i;
            p = p<<1;
        }
        return stellen;
    }
    
    public static int[] decode(long s) {
        int size = 64;
        int[] stellen = new int[size];
        long p = 1;
        for (int i = 0; i <size; i++) {
            stellen[i] = (int)((p & s) >> i);
            p = p<<1;
        }
        return stellen;
    }
}
