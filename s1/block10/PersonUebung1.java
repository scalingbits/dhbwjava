package s1.block10;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class PersonUebung1 implements Comparable  {
    private String nachname;
    private String vorname;
    private static int maxLaenge = 10; // Maximale Laenge von Zufallszeichenketten
    private static Locale myLocale = Locale.GERMANY; // Zu verwendende Sortierordnung
    /**
     * Konstruktor der Klasse PersonUebung1
     * @param nn Nachname
     * @param vn Vorname
     */
    public PersonUebung1(String nn, String vn) {
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
        PersonUebung1 p;
        if (s.getClass() == this.getClass()) {
            p = (PersonUebung1) s;
            // Konfiguriere die Sortierordnung
            if (p.vorname.equals("")) {
                throw new UnsupportedOperationException("Vorname fehlt");
            }
            if (nachname.equals("")) {
                throw new UnsupportedOperationException("Nachname fehlt");
            }
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
        PersonUebung1[] psn = {
                new PersonUebung1("Schneider", "Hans"),
                new PersonUebung1("Schmidt", "Hans"),
                new PersonUebung1("Schneider", "Gretel"),
                new PersonUebung1("Schmitt", "Hans"),
                new PersonUebung1("Meier", "aschenputtel"),
                new PersonUebung1("", "Aschenputtel")
        };
        Arrays.sort(psn);
        System.out.println("Sortiert:");
        for ( PersonUebung1 p : psn) {
            System.out.println(p);
        }
    }
}
