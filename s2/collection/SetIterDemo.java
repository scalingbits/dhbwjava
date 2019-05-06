package s2.collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetIterDemo {

public static void main(String[] args) {
        Set<Student> mengeUnsortiert = null; // Hier HashSetobjekt einfügen
        Set<Student> mengeSortiert = null; // Hier TreeSetobjekt einfügen
        Student s;
        s = new Student("Curie", "Marie", 19, 1);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        s = new Student("Merian", "Maria-Sybilla", 17, 3);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        s = new Student("Noether", "Emmi", 16, 1);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        s = new Student("Liese", "Meitner", 15, 2);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        s = new Student("Herschel", "Caroline", 15, 2);
        System.out.println("Hier Student " + s + "in beide Mengen einfügen");
        ausgaben(mengeUnsortiert);
        ausgaben(mengeSortiert);
    }

public static void ausgaben(Set<Student> menge) {
        Student s;
        System.out.println("Hier Iterator deklarieren");
        System.out.println("Inhalt der Menge ("
                + menge.getClass() + "):"); // Nicht ersetzen
        while (true) { // Abbruchbedingung ersetzen. Die Schleife terminiert so nicht!
            System.out.println("Hier Studentinnen aus Iterator in Schleife auslesen");
            s = null;
            System.out.println("Student: " + s); // Nicht ersetzen
        }
    }

}