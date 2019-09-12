package s1.block2.skript;

public class PrePostFixTest {
    public static void main(String[] args) {
        int x = 10;
        int y = 100;
        System.out.println();
        System.out.println("x = " + x + "; y = " + y);
        x++;
        System.out.println("x++ results in " + x);
        ++x;
        System.out.println("x++ results in " + x);
        System.out.println("Set x to 0 ");
        x=0;
        System.out.println("x = " + x + "; y = " + y);
        y=x++;
        System.out.println("y=x++ (Postfix)");
        System.out.println("x = " + x + "; y = " + y);
        y=++x;
        System.out.println("y=++x (Prefix)");
        System.out.println("x = " + x + "; y = " + y);
    }

}
