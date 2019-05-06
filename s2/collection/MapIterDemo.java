package s2.collection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapIterDemo {

public static void main(String[] args) {
        Map<Integer,Student> matrikelMap = new TreeMap<Integer,Student>(); // Ersetzen Sie xxx?
        Map<String, Student> nachnameMap = new HashMap<String,Student>();// Ersetzen Sie xxx?
        Student s;
        s = new Student("Curie", "Marie", 19, 1);
        System.out.println("Einsetzen: Studenten "+ s + " in die beiden Maps eintragen. Schlüssel beachten!");
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name, s);
        s = new Student("Merian", "Maria-Sybilla", 17, 3);
        System.out.println("Einsetzen: Studenten "+ s + " in die beiden Maps eintragen. Schlüssel beachten!");
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name, s);
        s = new Student("Noether", "Emmi", 16, 1);
        System.out.println("Einsetzen: Studenten "+ s + " in die beiden Maps eintragen. Schlüssel beachten!");
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name, s);
        s = new Student("Meitner", "Lise", 15, 2);
        System.out.println("Einsetzen: Studenten "+ s + " in die beiden Maps eintragen. Schlüssel beachten!");
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name, s);
        s = new Student("Herschel", "Caroline", 20, 2);
        System.out.println("Einsetzen: Studenten "+ s + " in die beiden Maps eintragen. Schlüssel beachten!");
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name, s);
        ausgabenMatrikelnr(matrikelMap);
        ausgabenNamen(nachnameMap);
    }

public static void ausgabenMatrikelnr(Map<Integer,Student> mp) {
        int s;
        Student st;
        Set<Integer> matrikelNummern = mp.keySet();
        Iterator<Integer> iterMatrikel = matrikelNummern.iterator(); // Einsetzen: Zuweisen des Iterators
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterMatrikel.hasNext()) {  // Einsetzen: Iteratorbedingung einfügen
            s = iterMatrikel.next(); // Einsetzen: Auslesen des Iterators
            System.out.println("Matrikelnummer: " + s);
        }
        int mnr = 15;
        System.out.println("Student mit Matrikelnummer " + mnr +
                " ist:" + mp.get(mnr)); // Einsetzen: Studentin mit Matrikelnr mnr
        mnr = 16;
        System.out.println("Student mit Matrikelnummer " + mnr +
                " ist:" + mp.get(mnr) ); // Einsetzen: Studentin mit Matrikelnr mnr
        System.out.println("Alle Werte der MatrikelMap:");
        Collection<Student> l = mp.values(); // Einsetzen: Collection mit den Studenten
        Iterator<Student> iterStudi = l.iterator();
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterStudi.hasNext()) { // Einsetzen: Schleifenbedingung des Iterators
            st = iterStudi.next();
            System.out.println("Student: " + st);
            }
    }

public static void ausgabenNamen(Map<String,Student> mp) {
        String str;
        Student st;
        Set<String> nachnamenmenge =mp.keySet();
        Iterator<String> namen = nachnamenmenge.iterator();
        System.out.println("Einsetzen: Vorbereitungen zum Auslesen der Nachnamen");
        System.out.println("Namen ("
                + mp.getClass() + "):");
        while (namen.hasNext()) { // Einsetzen: Iteratorbedingung einfügen
            str = namen.next();// Einsetzen: Auslesen des Iterators
            System.out.println("Nachname: " + str);
        }
        String nme = "Merian";
        System.out.println("Student mit Name " + nme +
                " ist:" + mp.get(nme)); // Einsetzen der Operation zum Auslesen der Studentin mit Namen nme
        nme = "Herschel";
        System.out.println("Student mit Name " + nme +
                " ist:" + mp.get(nme)); // Einsetzen der Operation zum Auslesen der Studenin mit Namen nme
        System.out.println("Alle Werte der NamenMap:");
        Collection<Student> l = mp.values(); // Einsetzen: Auslesen der gesamten Collection
        Iterator<Student> iterStudi = l.iterator();
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterStudi.hasNext()) { // Einsetzen: Iteratorbedingung einfügen
            st = iterStudi.next();// Einsetzen: Auslesen des Iterators
            System.out.println("Student: " + st);
            }
    }
}