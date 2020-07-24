package s1.block10;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
public class Person implements Comparable  {
    private final String nachname;
    private final String vorname;
    private static final int maxLaenge = 10; // Maximale Laenge von Zufallszeichenketten
    private static final Locale myLocale = Locale.GERMANY; // Zu verwendende Sortierordnung
    /**
     * Konstruktor der Klasse Person
     * @param nn Nachname
     * @param vn Vorname
     */
    public Person(String nn, String vn) {
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
        Person p;
        if (s.getClass() == this.getClass()) {
            p = (Person) s;
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
     * @return Der Name
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
        Person[] psn = {
                new Person("Schneider", "Hans"),
                new Person("Schmidt", "Hans"),
                new Person("Schneider", "Gretel"),
                new Person("Schmitt", "Hans"),
                new Person("Meier", "aschenputtel"),
                new Person("", "Aschenputtel")
        };
        Arrays.sort(psn);
        System.out.println("Sortiert:");
        for ( Person p : psn) {
            System.out.println(p);
        }
    }
}
