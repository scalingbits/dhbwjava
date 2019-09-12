package block3;

public class Uebung2 {

    public static void main(String[] args) {
        int firstArg = 0;
        int p = 0;
        long time;
        time = System.nanoTime();
        if (args.length > 0) {
            try {
                p = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
            }
            System.out.println("Eingelesene Zahl: " + p);
        }

    }
}
