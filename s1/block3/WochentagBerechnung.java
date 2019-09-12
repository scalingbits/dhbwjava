package block3;
import java.util.Calendar; // Nur für optionalen Teil benötigt!
import java.util.GregorianCalendar;

public class WochentagBerechnung {
    public static void main(String[] args) {
       int monatOffSet[] = new int[13];
       int tag = 0;
       int monat = 0;
       int jahr=0;
       int wochentag0101startJahr= 6;
       int jahresOffSet; // Bedeutung siehe Feld tagText
       String[] tagText = {"Sonntag", "Montag", "Dienstag", "Mittwoch",
                            "Donnerstag", "Freitag", "Samstag"};
       int wochentag;
       int startJahr = 2010;
       int anzSchaltJahre;

       if (args.length > 2 ) {
        try {
           tag   = Integer.parseInt(args[0]);
           monat = Integer.parseInt(args[1]);
           jahr = Integer.parseInt(args[2]);
           wochentag0101startJahr = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("Argument muss Ganzzahl sein");
            System.exit(1);
            }
        monatOffSet[1]  = 0;
        monatOffSet[2]  = (monatOffSet[1]+31)%7;
        monatOffSet[3]  = (monatOffSet[2]+28)%7;
        monatOffSet[4]  = (monatOffSet[3]+31)%7;
        monatOffSet[5]  = (monatOffSet[4]+30)%7;
        monatOffSet[6]  = (monatOffSet[5]+31)%7;
        monatOffSet[7]  = (monatOffSet[6]+30)%7;
        monatOffSet[8]  = (monatOffSet[7]+31)%7;
        monatOffSet[9]  = (monatOffSet[8]+31)%7;
        monatOffSet[10] = (monatOffSet[9]+30)%7;
        monatOffSet[11] = (monatOffSet[10]+31)%7;
        monatOffSet[12] = (monatOffSet[11]+30)%7;
        jahresOffSet = (monatOffSet[12]+31)%7;

        if (monat>2)
            anzSchaltJahre=jahr/4-startJahr/4;
        else
            anzSchaltJahre=(jahr-1)/4-startJahr/4;

        wochentag = (monatOffSet[monat]
                     + tag - 1
                     + wochentag0101startJahr
                     + (jahr-startJahr)*jahresOffSet
                     + anzSchaltJahre
                     )%7;

        System.out.println ("Der 1.1."+ startJahr+" war ein "
                + tagText[wochentag0101startJahr]);
        System.out.println ("Der "+ tag + "."+monat+"."+jahr+ " ist ein "
                + tagText[wochentag]);

        // Optional: Datumsbestimmung mit Hilfe der Java Infrastruktur
        Calendar myCal = new GregorianCalendar(jahr,monat+1,tag);
        System.out.println ("Gregorianischer Java Kalender:");
        System.out.println ("Der "
                + tag + "."
                + monat + "."
                + jahr+ " ist ein "
                + tagText[myCal.get(Calendar.DAY_OF_WEEK)]);
    }
}
}
