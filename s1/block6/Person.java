package s1.block6;

/**
 *
 * @author s@scalingbits.com
 */
public class Person {
    static int zaehler=0;
    String name;
    Person mutter;
    Person vater;

    public Person(int generation) {
        zaehler++;
        if (generation !=0) {
            mutter = new Person(generation-1);
            vater  = new Person(generation-1);
        }
    }

    /**
     * Das ist ein Copy Konstruktor
     * @param vorlage eine Porson
     */
    public Person(Person vorlage) {
        name = vorlage.name;
        if (vorlage.mutter != null)
            mutter = new Person(vorlage.mutter);
        if (vorlage.vater != null)
            vater = new Person(vorlage.vater);

    }

    public boolean equals(Object obj) {
        Person target;
        // Type checking is optional for this level of skills
        if (this.getClass() == obj.getClass() ) {
            target = (Person) obj;
            boolean isEqual = false;
            isEqual = (((name ==null) && (target.name == null))
                       || ((name != null) && (name.equals(target.name))
                       ));
            isEqual = (isEqual &&
                    (((mutter== null) && (target.mutter == null)) ||
                            ((mutter!= null) &&
                             (target.mutter!= null) &&
                             mutter.equals(target.mutter))
                    ));
            isEqual = ( isEqual &&
                    (((vater== null) && (target.vater == null)) ||
                            ((vater!= null) &&
                             (target.vater!= null) &&
                                    vater.equals(target.vater))
                    ));
            return isEqual;
        }
        else return false;
    }

    public static void main(String[] args) {
        Person p;
        Person pp;
        for(int i=0; i<=100; i++) {
            System.out.println("Schleifendurchlauf: " + i);
            p = new Person(5);
            p.name = "ich";
            pp = new Person(p);

            System.out.println("z: " + zaehler + " p: " + p + " " +
                    p.name + " mutter: " + p.mutter);

            Person p1 = new Person(3);
                p1.name = "Willie";
            Person p2 = new Person(p1);

            System.out.println ( p1.name + " und " + p2.name + " sind " +
                    (p1.equals(p2)?"gleich":"ungleich") );

            p2.mutter.mutter = null; // Oma ist gestorben :-(
            System.out.println ( p1.name + " und " + p2.name + " sind " +
                    (p1.equals(p2)?"gleich":"ungleich") );

            p2 = new Person(p1);
            p2.mutter.vater = null; // Opa ist gestorben :-(
            System.out.println ( p1.name + " und " + p2.name + " sind " +
                    (p1.equals(p2)?"gleich":"ungleich") );
        }
    }
}