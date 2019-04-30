package s2.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapIterDemoLoesung {

    public static void main(String[] args) {
        Map<Integer,Student> matrikelMap = new TreeMap<Integer,Student>();
        Map<String, Student> nachnameMap = new HashMap<String,Student>();
        Student s;
        s = new Student("Curie", "Marie", 19, 1);
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name,s);
        s = new Student("Merian", "Maria-Sybilla", 17, 3);
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name,s);
        s = new Student("Noether", "Emmi", 16, 1);
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name,s);
        s = new Student("Meitner", "Lise", 15, 2);
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name,s);
        s = new Student("Herschel", "Caroline", 20, 2);
        matrikelMap.put(s.matrikelnr,s);
        nachnameMap.put(s.name,s);
        matrikelMap.put(21,s);
        nachnameMap.put("Frau "+ s.name,s);

        ausgabenMatrikelnr(matrikelMap);
        ausgabenNamen(nachnameMap);
    }

    public static void ausgabenMatrikelnr(Map<Integer,Student> mp) {
        int s;
        Student st;
        Set<Integer> matrikelSet = mp.keySet();
        Iterator<Integer> iterMatrikel = matrikelSet.iterator();
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterMatrikel.hasNext()) {
            s = iterMatrikel.next();
            System.out.println("Matrikelnummer: " + s);
        }
        int mnr = 15;
        Student stu = mp.get(mnr);
        System.out.println("Student mit Matrikelnummer " + mnr +
                " ist:" +stu);
        mnr = 16;
        stu = mp.get(mnr);
        System.out.println("Student mit Matrikelnummer " + mnr +
                " ist:" +stu);
        System.out.println("Alle Werte der MatrikelMap:");
        Collection<Student> l = mp.values();
        Iterator<Student> iterStudi = l.iterator();
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterStudi.hasNext()) {
            st = iterStudi.next();
            System.out.println("Student: " + st);
            }
    }

    public static void ausgabenNamen(Map<String,Student> mp) {
        String str;
        Student st;
        Set<String> nameSet = mp.keySet();
        Iterator<String> iterName = nameSet.iterator();
        System.out.println("Namen ("
                + mp.getClass() + "):");
        while (iterName.hasNext()) {
            str = iterName.next();
            System.out.println("Matrikelnummer: " + str);
        }
        String nme = "Merian";
        System.out.println("Student mit Name " + nme +
                " ist:" +mp.get(nme));
        nme = "Herschel";
        System.out.println("Student mit Name " + nme +
                " ist:" +mp.get(nme));
        System.out.println("Alle Werte der NamenMap:");
        Collection<Student> l = mp.values();
        Iterator<Student> iterStudi = l.iterator();
        System.out.println("Name ("
                + mp.getClass() + "):");
        while (iterStudi.hasNext()) {
            st = iterStudi.next();
            System.out.println("Student: " + st);
            }
    }
}
