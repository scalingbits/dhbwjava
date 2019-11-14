package s1.block6;
/** * Die Klasse Lager verwaltet eine bestimmte Anzahl von Waren
 * @author s@scalingbits.com
 */
public class Lager {
    /*     * Aufgaben
     * 1. Verwalten von n Waren in einem Feld
     * 1.1 Deklarieren eines privaten Feldes
     * 1.2 Zugriffsmethoden zum Setzen und Auslesen des Feldes
     * 2. Implementieren eines Konstruktors der das Lager
     *           für n Waren initialisiert
     * 3. Methode zum Ausräumen des Lagers
     * 4. Erzeugung eines Singletons zum Erzeugen genau eines Lagers
     * 5. Anlegen einer neuen Klasse MainLager
     * 5.1 Umkopieren der main() Methode aus der Klasse Lager in die Klasse
     *      MainLager.main()
     * 8. Testen des Copy Constructors
     * 8.1 Belegen Sie die ersten 500 Lagerpositionen mit Waren
     * 8.2 Klonen Sie die ersten 500 Lagerpositionen und belegen Sie die
     *     folgenden 500 Lagerpositionen mit Ihnen
     * 8.3 Löschen Sie Ihr Lager indem Sie alle Postionen mit null belegen
     * 8.4 Implementieren Sie eine Schleife die einige Minuten läuft
     *      und testen Sie den Speicherverbrauch mit jconsole oder
     */
    public static void main(String[] args) {
        Ware ware1 = new Ware("Zeitung",12.12,true);
        System.out.println("Ware1 ohne Empfehlung:");
        ware1.drucken();
        double p = ware1.nettoPreis();
        Ware ware2 = new Ware("Potter Bd1",31.12,false);
        Ware ersterBand = ware2;
        ware1.empfehlung= ware2;
        System.out.println("Ware1 mit Empfehlung:");
        ware1.drucken();
        // Erzeugen einer Ware mit 7 verketteten Empfehlungen
        Ware ware3;
        Ware hp1=ware2;
        for (int i=2; i<= 7; i++) {
            ware3 = new Ware("Potter Bd" + i,31.25+i,false);
            ware2.empfehlung = ware3;
            ware2 = ware3;
        }
        System.out.println("Alle Harry Potter Baende drucken");
        hp1.drucken();
    }
}