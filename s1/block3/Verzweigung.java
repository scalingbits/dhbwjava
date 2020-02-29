package s1.block3;
public class Verzweigung {
public static void main(String[] args) {
    int[] x = new int[3];
    if (args.length > 2 ) {
        try {
           for (int i=0; i<3; i++)
               x[i]= Integer.parseInt(args[i]);
           }
        catch (NumberFormatException e) {
            System.err.println("Argument muss Ganzzahl sein");
            System.exit(1);
            }
    }
    System.out.println("Eingabe: " + x[0] +", " + x[1] + ", "+ x[2]);
    if ((x[0]==x[1]) && (x[1]==x[2]))
        System.out.println("Alle Werte sind gleich.");
    if ((x[0]==x[1]) || (x[1]==x[2]) || (x[0]==x[2]))
        System.out.println("Mindestens zwei Werte sind gleich.");
    if ((x[0]!=x[1]) && (x[1]!=x[2]) && (x[0]!=x[2]))
        System.out.println("Alle Werte sind verschieden.");

}
}
