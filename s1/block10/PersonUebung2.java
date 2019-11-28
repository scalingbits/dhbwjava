package s1.block10;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class PersonUebung2 implements Comparable  {
    private String nachname;
    private String vorname;
    private static int maxLaenge = 10; // Maximale Laenge von Zufallszeichenketten
    private static Locale myLocale = Locale.GERMANY; // Zu verwendende Sortierordnung
    /**
     * Konstruktor der Klasse Person
     * @param nn Nachname
     * @param vn Vorname
     */
    public PersonUebung2(String nn, String vn) {
        nachname = nn;
        vorname = vn;
    }
    /**
     *
     * @param s  Objekt mit dem verglichen wird
     * @return  -1 wenn der Eingabewert kleiner ist
     *           0 wenn der Eingabewert gleich ist
     *          +1 wenn der Eingabewert größer ist
     */
    @Override
    public int compareTo(Object s) {
        int result = -1;
        PersonUebung2 p;
        if (s.getClass() == this.getClass()) {
            p = (PersonUebung2) s;
            if (p.vorname.equals("")) {
                throw new UnsupportedOperationException("Vorname fehlt");
            }
            if (nachname.equals("")) {
                throw new NachnameException(vorname);
            }
            // Konfiguriere die Sortierordnung
            Collator myCollator = Collator.getInstance(myLocale);
            myCollator.setStrength(Collator.TERTIARY);
            result = myCollator.compare(nachname, p.nachname);
            if (result ==0)
                result = myCollator.compare(vorname, p.vorname);
        }
        return result;
    }
    /**
     * Erlaubt den Vor- und Nachnamen  als Text auszudrucken
     * @return
     */
    @Override
    public String toString() {
        return nachname + ", " + vorname;
    }

    /**
     *
     * @param args wird nicht ausgewertet
     */
    public static void main(String[] args) {
        // Aufzählende Iniatialisierung eines Felds
        PersonUebung2[] psn = {
                new PersonUebung2("Schneider", "Hans"),
                new PersonUebung2("Schmidt", "Hans"),
                new PersonUebung2("Schneider", "Gretel"),
                new PersonUebung2("Schmitt", "Hans"),
                new PersonUebung2("Meier", "aschenputtel"),
                new PersonUebung2("", "Aschenputtel")
        };
        Arrays.sort(psn);
        System.out.println("Sortiert:");
        for ( PersonUebung2 p : psn) {
            System.out.println(p);
        }
    }
}
