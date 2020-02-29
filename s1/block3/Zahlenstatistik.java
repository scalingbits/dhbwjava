package s1.block3;
public class Zahlenstatistik {
    public static void main(String[] args) {
        int[] feld;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        float average = 0;
        if (args.length > 0) {
            feld = new int[args.length];
            try {
                for (int i=0;i<args.length;i++) {
                    feld[i] = Integer.parseInt(args[i]);
                    if (feld[i] < min) {min=feld[i];}
                    if (feld[i] > max) {max=feld[i];}
                    average += feld[i];
                    }
            } catch (NumberFormatException e) {
                System.err.println("Argument muss Ganzzahl sein");
                System.exit(1);
                }
            average= average/(float)args.length;
            System.out.println("Anzahl eingelesene Werte: " + args.length);
            System.out.println("Kleinster Wert: " + min);
            System.out.println("Größter Wert: " + max);
            System.out.println("Durchschnitt: " + average);
    }
}
}
