package s1.block3;
public class Ueberlauf {
  public static void main(String[] args) {
       int a = 0;
       int b = 0;
       int result;
       if (args.length > 1 ) {
        try {
           a = Integer.parseInt(args[0]);
           b = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Argument muss Ganzzahl sein");
            System.exit(1);
            }
        }
       System.out.println("Eingelesene Werte: " + a + ", " + b);
       result = a + b;
       if ((result<a) || (result<b))
           System.out.println("Überlauf!");
       else
           System.out.println(a + " + " + b + " = " + result);
    }

}
