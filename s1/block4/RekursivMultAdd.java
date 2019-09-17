package s1.block4;
public class RekursivMultAdd {
    private static int mult(int a, int b) {
        if ( a == 0) return 0;
        else return add(b,mult(a-1,b));
    }
    
    private static int add(int a, int b) {
        if ( a == 0) return b;
        else return (1+add(a-1,b));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" 2 + 1 = " + add(2,1));
    }

}
