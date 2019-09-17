
package s1.block4;

public class Arithmetik3 {
    
    public static void main(String[] args) {
        int a=5;
        int b=8;
        int c=0;
        
        if (args.length > 1) {
            try {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
            }
        }
        System.out.println("Eingabe a: " + a +"; b: " +b);
        
        c = mult(a,b);
            
        
        System.out.print("Ergebnis c: " + c); 
        if (c == a*b)
            System.out.println(" (korrekt)");
        else
            System.out.println(" (falsch. Richtig ist " + (a*b)+")");
        
    }
    
    /**
     * Diese Methode multipliziert zwei Zahlen rekusriv.
     * Sie funktioniert nur für x Werte die nicht negativ sind!
     * @param x darf nicht negativ sein
     * @param y der zweite Faktor
     * @return Ergebnis einer Multiplikation
     */

    private static int mult(int x, int y) {
        int ergebnis=0;
        if (x==0) 
            ergebnis=0;
        else 
            ergebnis=mult(y,(x-1))+y;
        
        return ergebnis;
    }
    
}
