package s1.block8;

public class CircleHasPoint {
    private double radius;
    private final Point p;
    public CircleHasPoint(double xx, double yy, double r) {
        p = new Point(xx,yy);
        radius=r;
    }
    public double getRadius() {return radius;}
    public void setRadius(double r) {radius=r;}
    public void setXY(double xx, double yy) { p.setXY(xx,yy);}
    public double getX() { return p.getX();}
    public double getY() { return p.getY();}
    public void print() {System.out.println(toString());}
    public String toString() {return ("x: " + p.getX() + " y: " +
            p.getY() + " r: "+ radius);}
}
