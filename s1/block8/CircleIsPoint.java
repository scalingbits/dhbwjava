package s1.block8;

public class CircleIsPoint extends Point{
    private double radius;
    public CircleIsPoint(double xx, double yy, double r) {
        super(xx,yy);
        radius=r;
    }
    public double getRadius() {return radius;}
    public void setRadius(double r) {radius=r;}
    public String toString() {return (super.toString() + " , r: " + radius);}
}
