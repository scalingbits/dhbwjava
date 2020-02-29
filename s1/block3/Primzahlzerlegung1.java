package s1.block3;

public class Primzahlzerlegung1 {

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

        int teiler = 2;

        System.out.println("Eingelesene Zahl: " + p);
        while (teiler <= p) {
            // Suche Teiler bis Teilen ohne Rest m. ist
            if ((p % teiler) == 0) {
                // Erfolg...
                System.out.println("kann durch "
                        + teiler
                        + " geteilt werden");
                p=p/teiler;
                teiler = 2;
            }
            else teiler++;
        }
        System.out.println(p + "ist ein Teiler");


        // Die Eingabe der Kommandozeile liegt als Variable p vor.
        // Implementierung ...
        time = System.nanoTime() - time;
        System.out.println("Zeit in Nanosekunden: " + time);
    }
}
