package s2.generics;

/**
 *
 * @author s@scalingbits.com
 * @param <T> Generischer Typ der Klasse Koordinate
 */
public class Koordinate3DGen<T> extends Koordinate<T> {
    private T z;

    public T getZ() {return z;}
    public void setZ(T z) {this.z = z;}

    public Koordinate3DGen (T x, T y, T z) {
        super (x,y);
        this.z = z;
    }

    @Override
    public String toString() {return super.toString()+", z: "+ z;}

    public static void main (String[] args) {
        Koordinate3DGen<Double> k1 = new Koordinate3DGen<Double>(1.1d, 2.2d, 3.3d);
        System.out.println(k1);

        Koordinate3DGen<Integer> k2 = new Koordinate3DGen<Integer>(1,2,3);
        System.out.println(k2);
    }
}
