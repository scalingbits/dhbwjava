package block3;

public class Dreiecksvergleich {

    public static void main(String[] args) {
        float x[] = new float[3];
        int j;
        if (args.length > 2) {
            try {
                float a;
                for (int i = 0; i < 3; i++) {
                    x[i] = Float.parseFloat(args[i]);
                    j = i; // Sortiere Eingabe in steigender Reihenfolge
                    while (j > 0) {
                        if (x[j] < x[j - 1]) {
                            a = x[j - 1];
                            x[j - 1] = x[j];
                            x[j] = a;
                            j--;
                        } else {
                            j = 0;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Fließkommazahl sein");
                System.exit(1);
            }
            System.out.println("Eingebene Werte: " + x[0] + "; "
                    + x[1] + "; "
                    + x[2]);
            // Die folgenden Vergleiche verlassen sich darauf, dass das Feld
            // aufsteigend sortiert ist.
            if (x[0] + x[1] <= x[2]) {
                System.out.println("Dreieck ist ungültig");
            } else if (x[0] == x[2]) {
                System.out.println("Dreieck ist gleichseitig (und gleichschenkelig)");
            } else {
                if ((x[0] == x[1]) || (x[1] == x[2])) {
                    System.out.println("Dreieck ist gleichschenkelig (nicht gleichseitig)");
                }
                if (x[0] * x[0] + x[1] * x[1] == x[2] * x[2]) {
                    System.out.println("Dreieck ist rechtwinklig");
                }
            }

        }
    }
}
