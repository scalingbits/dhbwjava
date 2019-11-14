package s1.block6.loesung;

import s1.block6.Ware;

/** * Die Klasse Lager verwaltet eine bestimmte Anzahl von Waren
 * @author s@scalingbits.com
 * @version 1.1
 */
public class Lager {
    /*
     * Aufgaben
     * 1. Verwalten von n Waren in einem Feld
     * 1.1 Deklarieren eines privaten Feldes
     */
    private int lagerGroesse = 1000;
    private s1.block6.Ware[] warenLager;

    // 1.2 Zugriffsmethoden zum Setzen und Auslesen des Feldes
    public s1.block6.Ware holen(int i) {
        if ((i<0) || (i>=lagerGroesse)) return null;
        else return warenLager[i];
    }

    public int einlagern(s1.block6.Ware w) {
        int i=0;
        while ((i<lagerGroesse) && (warenLager[i] != null)) i++;
        if (i<lagerGroesse) {
            warenLager[i] = w;
            return i;
        }
        else return -1;
    }
    // 3. Methode zum Ausräumen des Lagers
    public void ausraeumen() {
        for (int i=0; i<lagerGroesse; i++) warenLager[i]=null;
    }
    /*
     * 2. Implementieren eines Konstruktors der das Lager
     *           für n Waren initialisiert
     */
    private Lager() {
        // Es wird ein Feld von Referenzen auf Waren angelegt
        // Es werden keine Waren angelegt!
        warenLager = new s1.block6.Ware[lagerGroesse];
    }
    /*
     * 4. Erzeugung eines Singletons zum Erzeugen genau eines Lagers
     */
    private static Lager meinLager;  // Eine Objektvariable die auf das Lager zeigt
    static public Lager dasLager() {
        if (meinLager== null) meinLager= new Lager();
        return meinLager;
    }
    /*
     * 5. Anlegen einer neuen Klasse MainLager
     * 5.1 Umkopieren der main() Methode aus der Klasse Lager in die Klasse
     *      MainLager.main()
     */
    // 6. Testen der Factory
         /*Lager lager1 = Lager.dasLager();
        int position;
        for (int i=0; i<500; i++)
            position = lager1.einlagern(new Ware("Buch " +i, 2*i, false));
        for (int i=0; i<500; i++) {
            Ware w = lager1.holen(i);
            System.out.println("Position " + i);
            w.drucken();
        }
         */
    /*
     * 8. Testen des Copy Constructors
     * 8.1 Belegen Sie die ersten 500 Lagerpositionen mit Waren
     * 8.2 Klonen Sie die ersten 500 Lagerpositionen und belegen Sie die
     *     folgenden 500 Lagerpositionen mit Ihnen
     * 8.3 Löschen Sie Ihr Lager indem Sie alle Postionen mit null belegen
     * 8.4 Implementieren Sie eine Schleife die einige Minuten läuft
     *      und testen Sie den Speicherverbrauch mit jconsole oder
     */
    public static void main(String[] args) {
        s1.block6.Ware ware1 = new s1.block6.Ware("Zeitung",12.12,true);
        System.out.println("Ware1 ohne Empfehlung:");
        ware1.drucken();
        double p = ware1.nettoPreis();
        s1.block6.Ware ware2 = new s1.block6.Ware("Potter Bd1",31.12,false);
        s1.block6.Ware ersterBand = ware2;
        ware1.empfehlung= ware2;
        System.out.println("Ware1 mit Empfehlung:");
        ware1.drucken();
        // Erzeugen einer Ware mit 10 verketteten Empfehlungen
        s1.block6.Ware ware3;
        s1.block6.Ware hp1=ware2;
        for (int i=2; i<= 7; i++) {
            ware3 = new Ware("Potter Bd" + i,31.25+i,false);
            ware2.empfehlung = ware3;
            ware2 = ware3;
        }
        System.out.println("Alle Harry Potter Baende drucken");
        hp1.drucken();
        // ersterBand.drucken();
    }
}
