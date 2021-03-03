package s2.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class PersonenMenge{
    /** In dieser Methode Code eintragen ! */
    public static void main(String[] args) {
        String p1 = new String("Schmidt");
        String p2 = new String("Mueller");
        String p3 = new String("Maier");

        Set<String> s = new TreeSet<String>();         // 1.
        s.add(p1);
        s.add(p2);
        s.add(p3);

        // 2. Erweiterte for Schleife und Ausgabezeile implementieren
        for (String p : s) {
            System.out.println("Person:" + p);
        }

        Iterator<String> i = s.iterator();
        String ppp; // Hilfsvariable zum Iterieren

        // 3. While Schleife mit Iteratorbenutzung und Ausgabezeileimplementieren
        while (i.hasNext()) {
            ppp = i.next();
            System.out.println("Person:" + ppp);
        }

    } // Ende main Methode
} // Ende der Klasse