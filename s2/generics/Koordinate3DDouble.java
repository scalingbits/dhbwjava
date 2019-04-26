package s2.generics;
/**
 *
 * @author s@scalingbits.com
 */
public class Koordinate3DDouble extends Koordinate<Double> {
    private Double z;

    public Double getZ() {return z;}
    public void setZ(Double z) {this.z = z;}

    public String toString() {return super.toString()+", z: "+ z;}

    public Koordinate3DDouble (Double x, Double y, Double z) {
        super (x,y);
        this.z = z;
    }

    public static void main (String[] args) {
        Koordinate3DDouble k1 = new Koordinate3DDouble(1.1d, 2.2d, 3.3d);
        double d1 = k1.getX(); //Generezität nicht mehr sichtbar
        System.out.println(k1);
    }
}
