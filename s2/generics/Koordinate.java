package s2.generics;

/**
 *
 * @author s@scalingbits.com
 * @param <T> Generischer Typ der Klasse Koordinate
 */
public class Koordinate<T> {
    private T x;
    private T y;

public T getX() {return x;}
    public void setX(T x) {this.x = x;}
    public T getx() {return x;}
    public void setY(T y) { this.y = y;}
    public T getY() {return y;}

    public Koordinate(T xp, T yp ) {
        x = xp;
        y = yp;
    }

    @Override
    public String toString() {return "x: " + x + "; y: " + y;}

public static void main (String[] args) {
        Koordinate<Double> k1 = new Koordinate<Double>(2.2d, 3.3d);
        System.out.println(k1);
   
        Koordinate<Integer> k2 = new Koordinate<Integer>(2, 3);
        System.out.println(k2);
        
        Koordinate<Number> k3 = new Koordinate<Number>(4.4f, 5.5f);
        System.out.println(k3);
    }
}