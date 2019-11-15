package s1.block8;

public class Point {
    private double x;
    private double y;
    public Point(double xx, double yy) {
        x = xx;
        y = yy;
    }
    public void setXY(double xx, double yy) {
        x = xx;
        y = yy;
    }
    public double getX() { return x;}
    public double getY() { return y;}
    public void print() {System.out.println(toString());}
    public String toString() {return ("x: " + x + " y: " + y);}
}
