package s1.block5;

public class Complex {

    private double re; // Realteil der Zahl
    private double im; // Imaginaerteil der Zahl (i)

    public Complex(double r, double i) {
        re = r;
        im = i;
    }

    public Complex add(Complex z) {
        Complex k = new Complex(re+z.re,im+z.im);
        return k;
    }

    public Complex sub(Complex z) {
        Complex k = new Complex(re-z.re,im-z.im);
        return k;
    }

    public Complex mul(Complex z) {
        Complex k = new Complex(re*z.re-im*z.im,re*z.im+im*z.re);
        return k;
    }

    public Complex div(Complex z) {
        Complex k = new Complex((re*z.re+im*z.im)/(z.im*z.im+z.im*z.im),
                (im*z.re-im*z.im)/(z.im*z.im+z.im*z.im));
        return k;
    }

    public String toText() {
        String s = "(" + re + " + i" + im + ")";
        return s;
    }
}
