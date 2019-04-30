package s2.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author s@scalingbits.com
 */
public class LinkedListIterDemo {

    public static void main(String[] args) {
        List<Student> ll = new LinkedList<>();
        Student s;
        s = new Student("Curie","Marie", 19,1);
        ll.add(s);
        s = new Student("Merian","Maria-Sybilla", 17,3);
        ll.add(s);
        s = new Student("Noether","Emmi", 16,1);
        ll.add(s);
        s = new Student("Herschel","Caroline", 15,2);
        ll.add(s);
        
        System.out.println("Element auf Index 1:" + ll.get(1));
        
        Iterator<Student> iter = ll.iterator();
        System.out.println("Inhalt der Liste:");
        while (iter.hasNext()){
            s = iter.next();
            System.out.println("Student: " +s);
        }

        System.out.println("Inhalt der Liste:");
        for (Student st : ll)
            System.out.println("Student: " +st);
    }
}
