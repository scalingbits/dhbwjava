package block3;
public class Plausibilitaetspruefung {
    public static void main(String[] args) {
       int monatTage[] = {0, 31, 28, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 13};
       int tag = 0;
       int monat = 0;
       int jahr = 0;

       if (args.length > 2 ) {
        try {
           tag   = Integer.parseInt(args[0]);
           monat = Integer.parseInt(args[1]);
           jahr = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Argument muss Ganzzahl sein");
            System.exit(1);
            }

        System.out.println("Eingabe ist: " + tag +
                                        "." + monat +
                                        "." + jahr);

        if ((monat>0) && (monat<13) && (tag>0))
            if (monatTage[monat] >= tag)
                System.out.println("Datum ist gültig");
            else if ((monat == 2)
                    && (tag == 29)
                    && (jahr%4 == 0)
                    && ((jahr%100 !=0) || (jahr%400==0))
                    )
                    System.out.println("Datum ist gültig (Schalttag)");
        else System.out.println("Datum ist ungültig");
    }
}
}
