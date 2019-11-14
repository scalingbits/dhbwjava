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
     * @param vorlage
     */
    public Person(Person vorlage) {
        name = vorlage.name;
        if (vorlage.mutter != null)
            mutter = new Person(vorlage.mutter);
        if (vorlage.vater != null)
            vater = new Person(vorlage.vater);

    }

    public static void main(String[] args) {
        Person p;
        Person sonstwie;
        for(int i=0; i<=100; i++) {
            System.out.println("Schleifendurchlauf: " + i);
            p = new Person(5);
            p.name = "ich";
            sonstwie = new Person(p);

            System.out.println("z: " + zaehler + " p: " + p + " " +
                    p.name + " mutter: " + p.mutter);

        }
    }
}