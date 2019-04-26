package s2.generics;
/**
 *
 * @author s@scalingbits.com
 */
public class Koordinate2DGewichtGen<T> extends Koordinate2D {
    private T gewicht;

    public T getGewicht() {return gewicht;}
    public void setGewicht(T g) {gewicht = g;}

    public Koordinate2DGewichtGen (Double x, Double y, T g) {
        super (x,y);
        gewicht = g;
    }

    @Override
    public String toString() {return super.toString()+", Gewicht: "+ gewicht;}

    public static void main (String[] args) {
        Koordinate2DGewichtGen<Double> k1 = new Koordinate2DGewichtGen<Double>(1.1d, 2.2d, 9.9d);
        double dx = k1.getX();
        System.out.println(k1);

        Koordinate2DGewichtGen<Integer> k2 = new Koordinate2DGewichtGen<Integer>(1.1d,2.2d,9);
        System.out.println(k2);
    }
}
