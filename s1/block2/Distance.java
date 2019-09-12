package s1.block2;
public class Distance {
    public static void main(String[] args) {
       double x1,x2, y1, y2, x, y, d;

       x1 = 1; y1 = 1;
       x2 = 4; y2 = 5;

       x = x1-x2;
       y = y1-y2;
       d = Math.sqrt(x*x+y*y);
       System.out.println("distance = " + d);
    }

}
