package s1.block4;
public class MultRekursivIterativ {
    private static int multiplikation_i(int a, int b) {
        int r = 0;
        while ( a-- > 0) r = r + b;
        return r;
    }
    private static int multiplikation_r(int a, int b) {
        if ( a == 0) return 0;
        else return (b + multiplikation_r(a-1,b));
    }

    public static void main(String[] args) {
        System.out.println("Iteration: 4 * 3 = " + multiplikation_i(4,3));
        System.out.println("Rekursion: 4 * 3 = " + multiplikation_r(4,3));
    }

}
