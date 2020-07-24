package s1.block8;
/**
 * Eine Hilfsklasse zur Implementierung eines Hauptprogramms
 * @author s@scalingbits.com
 * @version 1.3
 */
public class MainCD {
    /**
     * Die Methode wareTesten testet die Implementierung der
     * von Waren mit tiefem Kopieren, tiefem Vergleichen.
     * Sie nutzt nicht die Vererbung aus.
     */
    public static void warenTesten() {
        Ware ware1, ware2;
        Lager dasLager;
        // Testen der Klasse Ware
        ware1 = new Ware("Zeitung", 12.12, true);
        ware1.drucken();
        double p = ware1.getNettoPreis();
        // Generieren von Empfehlungen
        ware2 = new Ware("Potter Band 1", 31.12, false);
        ware2.generiereEmpfehlungen(7);
        // Abfrage des Lagers
        dasLager = Lager.getLager();
        dasLager.einlagern(ware1, 0);
        dasLager.einlagern(ware2, 1);
        // Prüfen der Lagerbestände mit tiefem Vergleichen
        Ware testWare = dasLager.holen(0);
        if (testWare == ware2)
            System.out.println("testware und ware2 sind identisch (gut)");
        if (testWare.equals(ware2))
            System.out.println("testware und ware2 sind inhaltsgleich (gut)");
        // vollständiges Befüllen des Lager
        for (int i = 0; i < 1000; i++) {
            ware2 = new Ware("Band" + i + "B", 12.12, true);
            ware2.generiereEmpfehlungen(7);
            dasLager.einlagern(ware2);
        }
        System.out.println("Lager vollständig gefüllt mit "
                + dasLager.lagerGroesse() + " Waren.");
        for (int i = 0; i < 1000; i++) {
            ware2 = new Ware("Volume" + i + "B", 12.12, true);
            ware2.generiereEmpfehlungen(7);
            dasLager.einlagern(ware2,i);
        }
        System.out.println("Lager erneut vollständig gefüllt mit "
                + dasLager.lagerGroesse() + " Waren.");
    }
    /**
     * Diese Methode dient zum Testen der Klasse Buch.
     * Sie nutzt die Veererbung in Java aus.
     */
    public static void buecherTesten() {
        /*
         * 2. Testen: Anlegen einer Testmethode für Bücher
         *   Erzeugen von Büchern
         *   Anlegen einer Referenz auf eine alte Auflage
         *   Drucken zweier Bücher
         * 3. Frage: Wie kann man Bücher in das Lager einfügen?
         * 5. Einfügen der Bücher in das Lager
         * 8. Anpassen der Hauptroutine
         * 8.1 Alle Instanzen vom Typ Ware sollen MusikCDs werden da die Klasse
         *    Ware jetzt abstrakt ist.
         */
        Lager dasLager;
        dasLager = Lager.getLager();
        Buch buch1 = new Buch("Das Grauen",22.22,"9876543");
        Buch buch2 = new Buch("Das Kapital",33.33,"9876543");
        buch1.setAlteAuflage(buch2);
        buch1.drucken();
        dasLager.einlagern(buch1);
        dasLager.einlagern(buch2);
        dasLager.drucken();
    }
    /**
     * Diese Methode dient zum Testen der Klasse Buch.
     * Sie nutzt die Veererbung in Java aus.
     */
    public static void CDsTesten() {
        /*
         * 2. Testen: Anlegen einer Testmethode für Bücher
         *   Erzeugen von Büchern
         *   Anlegen einer Referenz auf eine alte Auflage
         *   Drucken zweier Bücher
         * 3. Frage: Wie kann man Bücher in das Lager einfügen?
         * 5. Einfügen der Bücher in das Lager
         * 8. Anpassen der Hauptroutine
         * 8.1 Alle Instanzen vom Typ Ware sollen MusikCDs werden da die Klasse
         *    Ware jetzt abstrakt ist.
         */
        Lager dasLager;
        dasLager = Lager.getLager();
        MusikCD cd1 = new MusikCD("Thriller",8.88);
        MusikCD cd2 = new MusikCD("Peter und der Wolf",9.99);
        cd1.setEmpfehlung(cd2);
        cd1.drucken();
        dasLager.einlagern(cd1);
        dasLager.einlagern(cd2);
        dasLager.drucken();
    }
    /**
     * Das Hauptprogramm
     *
     * @param args  Kommandozeilenargumente (nicht benoetigt)
     */
    public static void main(String[] args) {
        //warenTesten();
        buecherTesten();
        CDsTesten();
    }
}
