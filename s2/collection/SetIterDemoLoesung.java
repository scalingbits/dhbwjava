package s2.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetIterDemoLoesung {

    public static void main(String[] args) {
        Set<Student> mengeUnsortiert = new HashSet<Student>();
        Set<Student> mengeSortiert = new TreeSet<Student>();
        Student s;
        s = new Student("Curie", "Marie", 19, 1);
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Merian", "Maria-Sybilla", 17, 3);
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Noether", "Emmi", 16, 1);
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        s = new Student("Herschel", "Caroline1", 15, 2);
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        // Dieses Objekt ist schon Teil der Menge!
        s = new Student("Herschel", "Caroline2", 15, 2);
        mengeUnsortiert.add(s);
        mengeSortiert.add(s);
        ausgaben(mengeUnsortiert);
        ausgaben(mengeSortiert);
    }

    public static void ausgaben(Set<Student> menge) {
        Student s;
        Iterator<Student> iter = menge.iterator();
        System.out.println("Inhalt der Menge ("
                + menge.getClass() + "):");
        while (iter.hasNext()) {
            s = iter.next();
            System.out.println("Student: " + s);
        }
        for (Student s1: menge) {
            System.out.println("Student: " + s1);
        }
    }

}
