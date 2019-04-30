package s2.collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetIterDemo {

public static void main(String[] args) {
        Set<Student> mengeUnsortiert = new HashSet<Student>(); // Hier HashSetobjekt einfügen
        Set<Student> mengeSortiert =   new TreeSet<Student>(); // Hier TreeSetobjekt einfügen
        Student s;
        s = new Student("Curie", "Marie", 19, 1);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Merian", "Maria-Sybilla", 17, 3);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Noether", "Emmi", 16, 1);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Liese", "Meitner", 15, 2);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Herschel", "Caroline", 15, 2);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        ausgaben(mengeUnsortiert);
        ausgaben(mengeSortiert);
    }

public static void ausgaben(Set<Student> menge) {
        Student s;
        System.out.println("Hier Iterator deklarieren");
        Iterator<Student> iter = menge.iterator();
        System.out.println("Inhalt der Menge ("
                + menge.getClass() + "):"); // Nicht ersetzen
        while (iter.hasNext()) { // Abbruchbedingung ersetzen. Die Schleife terminiert so nicht!
            System.out.println("Hier Student aus Iterator in Schleife auslesen");
            s = iter.next();
            System.out.println("Student: " + s); // Nicht ersetzen
        }
    }

}