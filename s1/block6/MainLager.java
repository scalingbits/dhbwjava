package s1.block6;

/**
 * * Eine Hilfsklasse zur Implementierung eines Hauptprogramms
 *
 * @author s@scalingbits.com
 * @version 1.2
 */
public class MainLager {
    /*
     * 5. Anlegen einer neuen Klasse MainLager
     * 5.1 Umkopieren der main() Methode
     * aus der Klasse Lager in die Klasse MainLager.main()
     */
    /*
     * 8. Testen des Copy Constructors
     * 8.1 Belegen Sie die ersten 500
     * Lagerpositionen mit Waren
     * 8.2 Klonen Sie die ersten 500 Lagerpositionen und belegen Sie die
     *      folgenden 500 Lagerpositionen mit Ihnen
     * 8.3 Löschen Sie Ihr Lager indem Sie alle Postionen mit null belegen
     * 8.4 Implementieren Sie eine Schleife die einige Minuten läuft und testen Sie
     *      den Speicherverbrauch mit jconsole und jps
     */
    public static void main(String[] args) {
        Lager lager1 /* = Lager.dasLager()*/;
        int position;
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < 500; i++) {
                //position = lager1.einlagern(new Ware("Buch der Zahl " + i, 2 * i, false));
                //System.out.println("Ware auf Position" + position + " eingelagert");
            }
            for (int i = 0; i < 500; i++) {
                //position = lager1.einlagern(new Ware(lager1.holen(i)));
                //System.out.println("Ware auf Position" + position + " eingelagert");
            }
            //lager1.ausraeumen();

            System.out.println("Schleife " + j + " von 100000");
        }
    }
}
