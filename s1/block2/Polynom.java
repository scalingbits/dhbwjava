package s1.block2;

public class Polynom {
    public static void main(String[] args) {
        double a, b, c, d, x, y;

        a =  1.2;
        b = -2.3;
        c =  4.5;
        d = -6.7;

        x = 8.9;

        y = a*x*x*x+b*x*x+c*x+d;
        System.out.print("Ergebnis = "+ y);
        System.out.println("\n oder...");

        y = a*Math.pow(x,3)+b*Math.pow(x,2)+c*x+d;
        System.out.print("Ergebnis = "+ y);
    }
}
