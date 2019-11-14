package s1.block5;

public class Main {
    public static void main(String[] args) {
        Complex a = new Complex (1.0,2.0);
        Complex b = new Complex (3.0,4.0);
        Complex c,d,e,f;

        c = a.add(b);
        d = a.sub(b);
        e = a.mul(b);
        f = a.div(b);

        System.out.println (" a = " + a.toString());
        System.out.println (" b = " + b.toString());
        System.out.println (" c = " + c.toString());
        System.out.println (" d = " + d.toString());
        System.out.println (" e = " + e.toString());
        System.out.println (" f = " + f.toString());
    }
}