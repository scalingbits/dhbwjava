package s2.generics;
/**
 *
 * @author s@scalingbits.com
 */
public class Koordinate2D {
    private Double x;
    private Double y;

    public Double getX() {return x;}
    public void setX(Double x) {this.x = x;}
    public Double getY() {return y;}
    public void setY(Double y) { this.y = y;}

    public Koordinate2D(Double xp, Double yp ) {
        x = xp;
        y = yp;
    }

    @Override
    public String toString() {return "x: " + x + "; y: " + y;}

    public static void main (String[] args) {
        Koordinate2D k1 = new Koordinate2D(2.2d, 3.3d);
        System.out.println(k1);
    }
}