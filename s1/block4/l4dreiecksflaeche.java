package s1.block4;

public class l4dreiecksflaeche {
    public static double flaeche(double a, double b, double c) {
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    private static double flaeche(double gleicherSchenkel, double basis) {
    return flaeche(gleicherSchenkel,gleicherSchenkel,basis);
    }
    private static double flaeche(double gleicheSeite) {
    return flaeche(gleicheSeite,gleicheSeite);
    }
    
    
    public static void main(String[] args) {
        System.out.println(" 3,4,5 = " + flaeche(3.0,4.0,5.0));
        System.out.println(" 2*4,5 = " + flaeche(4.0,5.0));
        System.out.println(" 3*3 = " + flaeche(3.0));
    }
    }
