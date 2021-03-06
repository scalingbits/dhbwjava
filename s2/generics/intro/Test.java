package s2.generics.intro;
/**
 * Klasse zum Testen
 * @author s@scalingbits.com
 */
public class Test {
    public static void main(String[] args) {
        Person hans = new Person();
        System.out.println("Hans: " + hans);
        
        Zimmer<Person> bude = new Zimmer<>();
        bude.rein(hans);
        // Viel Zeit vergeht....
        // Die Wohnung wird verkauft
        Zimmer<Person> neueWohnung = bude;

        // Wer wohnt denn bei mir?
        Person xyz = neueWohnung.einwohner();
        
        System.out.println("Mein Einwohner: " + xyz);
        
        Zimmer<Student> bruchbude = new Zimmer<>();
        Student willi = new Student();
        bruchbude.rein(willi);
        // Zeit vergeht...
        // Die Wohnung wird verkauft
        Zimmer<Student> neueBruchbude = bruchbude;

        // Hier findet der Polymorphismus der Vererbung Anwendwung
        // Ja, Studenten sind auch Personen!
        Person y = neueBruchbude.einwohner();
        System.out.println("Einwohner Bruchbude: " + y);

        // Hier muss ja ein Student wohnen!
        Student yy = neueBruchbude.einwohner();
        //Student zz = (Student)      bude.einwohner();
        
        Katze mietze = new Katze();
        Zimmer<Katze> katzenkorb = new Zimmer<>();
        
        katzenkorb.rein(mietze);
        // Zeit vergeht. Katze muss fressen
        
        Katze k =  katzenkorb.einwohner();
        //Student s = katzenkorb.einwohner();
        //Person p1  = katzenkorb.einwohner();
        
        Zimmer<Person> huette = bude;
        //huette = bruchbude;
        //huette = katzenkorb;
        
        // Nicht generische Verwendung der Klasse Zimmer
        Zimmer wohnung = new Zimmer();

        // Das macht jetzt inhaltlich keinen Sinn
        // Ist aber für Java OK
        wohnung.rein("Guten Morgen");
        // ... Viel Code dazwischen
        String x =  (String) wohnung.einwohner();
        System.out.println(x);
        
        /*
        Zimmer<Person>  w1  = new Zimmer<Person>();
        Zimmer<Student> w2 = new Zimmer<Student>();
        Zimmer<Katze>   w3 = new Zimmer<Katze>();
        
        w1 = w2;
        w1 = w3;
        */
        
    }
    
}
