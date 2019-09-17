package s1.block4;
public class BasisOps {

    public static double add (double a, double b) {
        return (a+b);
        }
    public static double sub (double a, double b) {
        return (a-b);
        }
    public static double mul (double a, double b) {
        return (a*b);
        }
    public static double div (double a, double b) {
        return (a/b);
        }
    public static int add (int a, int b) {
        return (a+b);
        }
    public static int sub (int a, int b) {
        return (a-b);
        }
    public static int mul (int a, int b) {
        return (a*b);
        }
    public static int div (int a, int b) {
        return (a/b);
        }
    public static void main(String[] args) {
        System.out.println(" 5.0 + 4.0 = " + add(5.0,4.0));
        System.out.println(" 9.0 / 4.0 = " + div(9.0,4.0));
        System.out.println(" 9.0 / 4.0 + 3.0 = " + add(div(9.0,4.0),3.0));

        System.out.println(" 5 + 4 = " + add(5,4));
        System.out.println(" 9 / 4 = " + div(9,4));
        System.out.println(" 9 / 4 + 3 = " + add(div(9,4),3));
    }

}
