package s2.generics;
/**
 *
 * @author s@scalingbits.com
 * @param <T> Die Dimensionen der Koordinate
 */
public class Koordinate2DGewicht<T> extends Koordinate<Double> {
    private T gewicht;

    public T getGewicht() {return gewicht;}
    public void setGewicht(T g) {gewicht = g;}

    public Koordinate2DGewicht (Double x, Double y, T g) {
        super (x,y);
        gewicht = g;
    }

    @Override
    public String toString() {return super.toString()+", Gewicht: "+ gewicht;}

    public static void main (String[] args) {
        Koordinate2DGewicht<Double> k1 = new Koordinate2DGewicht<Double>(1.1d, 2.2d, 9.9d);
        double dx = k1.getX();
        System.out.println(k1);

        Koordinate2DGewicht<Integer> k2 = new Koordinate2DGewicht<Integer>(1.1d,2.2d,9);
        System.out.println(k2);
    }
}
