package s1.block8;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point (2.2, 3.3);
        Point p2 = new Point (2.22, 3.33);
        CircleIsPoint cip1 = new CircleIsPoint(4.4,5.5,6.6);

        p1.print();
        cip1.print();

        CircleHasPoint chp1 = new CircleHasPoint(44.4,55.5,66.6);
        chp1.print();
    }
}