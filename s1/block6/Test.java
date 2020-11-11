package s1.block6;

public class Test {
    /**
     * Zu erzeugende Generationen
     */
    public static int generationen = 3; // Initial testen
    //public static int generationen = 19; // mit -Xlog:gc
    //public static int generationen = 22; // mit -Xmx500m -Xlog:gc
    //public static int generationen = 23; // mit -Xms500m -Xmx1024m -Xlog:gc
    public static void main(String[] args) {
        Person p;
        systemStatus();
        for (int i=0; i<= generationen; i++) {
            System.out.println("*** Erzeuge " + i + " Generationen ***");
            // Der alte Personenbaum wird implizit dereferenziert
            p = new Person(i);
            // Verlängern der Laufzeit. Dies erlaubt eine bessere Beobachtung mit jonsole
            // Der alte Vorfahrenbaum wird durch die Zuweisung dereferenziert
            //p = new Person(i);
            //p = new Person(i);
            systemStatus();
            System.out.println("*** Ende. Erzeuge " + i + " Generationen ***");
        }
    }
    public static void systemStatus(){
        Runtime r = Runtime.getRuntime();
        System.out.println("*** Systemstatus ***");
        System.out.println("* Prozessoren :       " + r.availableProcessors());
        System.out.println("* Freier Speicher:    " + r.freeMemory());
        System.out.println("* Maximaler Speicher: " + r.maxMemory());
        System.out.println("* Gesamter Speicher:  " + r.totalMemory());
        System.out.println("***  Ende Systemstatus ***");
    }
}