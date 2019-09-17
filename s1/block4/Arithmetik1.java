package s1.block4;


public class Arithmetik1 {
    
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
        
        for (int i=0; i<b; i++) {
            c += a;
        }
            
        
        System.out.print("Ergebnis c: " + c); 
        if (c == a*b)
            System.out.println(" (korrekt)");
        else
            System.out.println(" (falsch. Richtig ist " + (a*b)+")");
        
    }
    
}
