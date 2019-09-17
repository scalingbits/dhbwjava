
package s1.block4;

public class Arithmetik4 {
    
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
     * Diese Methode multipliziert zwei Zahlen rekursiiv.
     * Sie funktioniert nur für x Werte die nicht negativ sind!
     * @param x darf nicht negativ sein
     * @param y zweiter Faktor
     * @return Ergebnis einer Multiplikation
     */
    
    private static int mult(int x, int y) {
        int ergebnis;
        if (x==0) 
            ergebnis=0;
        else 
            ergebnis=add(mult(y,(x-1)),y);
        
        return ergebnis;
    }
    
    /**
     * Diese Methode addiert zwei Zahlen rekursiv.
     * Sie funktioniert nur für x Werte die nicht negativ sind!
     * @param x darf nicht negativ sein
     * @param y zweiter Summand
     * @return Ergebnis einer Multiplikation
     */
    
    private static int add(int x, int y) {
        int ergebnis;
        if (y==0) 
            ergebnis=x;
        else {
            ergebnis=add(x,(y-1));
            ergebnis++;
        }
        
        return ergebnis;
    }
    
}
