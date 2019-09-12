package block3;

public class Quersumme {

    public static void main(String[] args) {
        int firstArg = 0;
        int querSumme = 0;
        int a;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
            }
            System.out.println("Die Zahl " + firstArg + " wurde eingelesen");
            a = firstArg;
            while (a != 0) {
                querSumme += a % 10;
                a /= 10;
            }
            System.out.println("Die Zahl " + firstArg + " hat die Quersumme " + querSumme + "!");
        }
    }
}
