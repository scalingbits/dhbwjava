package s2.sort;
import java.text.Collator;
import java.util.Locale;
/**
 *
 * @author s@scalingbits.com
 */
public class Lexikographisch {
    public static void main(String[] args) {
        String s1 = "Test1";
        String s2 = "Test2";
        Locale myLocale = Locale.GERMANY;
        int strength = Collator.TERTIARY;
        if (args.length < 2) {
            System.out.println("Erforderliche Mindestparameter: String1 String2");
            System.out.println("Syntax: java Kurs2.Sort.Lexikographisch "
                    + "String1 String2 "
                    + "[[German|French|UK|US] [PRIMARY|SECONDARY|TERTIARY]]");
        } else {
            s1 = args[0];
            s2 = args[1];
        }
        if (args.length >= 3) {
            String loc = args[2];
            if (loc.equalsIgnoreCase("German")
                    || loc.equalsIgnoreCase("Germany")) {
                myLocale = Locale.GERMAN;
            }
            if (loc.equalsIgnoreCase("France")
                    || loc.equalsIgnoreCase("French")) {
                myLocale = Locale.FRENCH;
            }
            if (loc.equalsIgnoreCase("US")) {
                myLocale = Locale.US;
            }
            if (loc.equalsIgnoreCase("UK")
                    || loc.equalsIgnoreCase("English")) {
                myLocale = Locale.UK;
            }
            // Add more locales here...
        }
        if (args.length >= 4) {
            String s = args[3];
            if (s.equalsIgnoreCase("PRIMARY")) {
                strength = Collator.PRIMARY;
            }
            if (s.equalsIgnoreCase("SECONDARY")) {
                strength = Collator.SECONDARY;
            }
            if (s.equalsIgnoreCase("TERTIARY")) {
                strength = Collator.TERTIARY;
            }
        }
        vergleich(s1, s2, myLocale, strength);
    }

    private static void vergleich(String s1, String s2, Locale myLocale, int strength) {
        Collator myCollator = Collator.getInstance(myLocale);
        // Beim Vergleich auch Gross- und Kleinschreibung unterscheiden
        // Konfiguriere die Sortierordnung
        myCollator.setStrength(strength);
        if (myCollator.compare(s1, s2) == 0) {
            System.out.println(s1 + " ist gleich " + s2);
        }
        if (myCollator.compare(s1, s2) < 0) {
            System.out.println(s1 + " vor " + s2);
        }
        if (myCollator.compare(s1, s2) > 0) {
            System.out.println(s2 + " vor " + s1);
        }
    }
}