package block3;

public class Sortieren {


public static void main(String[] args) {
       int a = 0;
       int b = 0;
       int c = 0;

       if (args.length > 2 ) {
        try {
           a = Integer.parseInt(args[0]);
           b = Integer.parseInt(args[1]);
           c = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Argument muss Ganzzahl sein");
            System.exit(1);
            }
        }
       System.out.println("Eingelesene Werte: " + a + ", " + b + ", " + c);
       // alle Moeglichkeiten testen
       if ((a <= b) && (b<=c))
           System.out.println("Sortierte Werte: " + a + ", " + b + ", " + c);
       else if ( (a <= c) && (c <= b) )
           System.out.println("Sortierte Werte: " + a + ", " + c + ", " + b);
       else if ( (b <= a) && (a <= c) )
           System.out.println("Sortierte Werte: " + b + ", " + a + ", " + c);
        else if ( (b <= c) && (c <= a) )
           System.out.println("Sortierte Werte: " + b + ", " + c + ", " + a);
       else if ( (c <= a) && (a <= b) )
           System.out.println("Sortierte Werte: " + c + ", " + a + ", " + b);
       else if ( (c <= b) && (b <= a) )
           System.out.println("Sortierte Werte: " + c + ", " + b + ", " + a);
}
}