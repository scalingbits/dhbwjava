package s2.generics;
/**
 *
 * @author s@scalingbits.com
 * @param <T> ein Getraenk
 */
public class KoordinateTest<T extends Number> {

    public T x;
    public T y;

    public KoordinateTest(T xp, T yp) {
        x = xp;
        y = yp;
    }

    public static void main(String[] args) {
        KoordinateTest<Double> k11, k12;
        KoordinateTest<Integer> k21, k22;
        //Koordinate<String>  k31;
        KoordinateTest<Number> k41, k42;
        KoordinateTest<Float> k81, k82;

        k81 = new KoordinateTest<Float>(2.2f, 3.3f);
        k12 = new KoordinateTest<Double>(2.2d, 3.3d);
        k21 = new KoordinateTest<Integer>(2, 3);
        //k31 = new Koordinate<String>("11","22");
        k41 = new KoordinateTest<Number>(2l, 3l);

        k41 = new KoordinateTest<Number>(4.4d, 5.5f);
        k11 = new KoordinateTest<Double>(3.3d,9.9d);

        KoordinateTest<? super Double> k99;
        k99 = k11;
        k99 = k41;
        //k99 = k31;

        k11 = k12;
        //k12 = k21;
        KoordinateTest k55 = new KoordinateTest<Number>(7.7f, 8.8f);
        KoordinateTest k66 = new KoordinateTest(7.7d, 3.d);

    }
}
