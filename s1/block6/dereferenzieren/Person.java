package s1.block6.dereferenzieren;

public class Person {

    public Person vater;
    public Person mutter;

    public static void main (String[] args ) {
        Person p1 = new Person();
        Person p2 = new Person();
        // Zeitpunkt 1
        p1.vater = p2;
        p2 = null;
        // Zeitpunkt 2
        aufruf(p1);
        //Zeitpunkt 5
    }

    public static void aufruf(Person p) {
        Person[] persFeld = new Person[2];
        // Zeitpunkt 3
        persFeld[1] = p;
        persFeld[0] = new Person();
        persFeld[0].vater = new Person();
        persFeld[0].mutter = new Person();
        // Zeitpunkt 4
    }
}