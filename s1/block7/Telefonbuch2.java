package s1.block7;
/**
 *
 * @author s@scalingbits.com
 */
public class Telefonbuch2 {
    private Person[] leute;
    /**
     * Anlegen eines Telefonbuchs für 4 EInträge
     */
    public Telefonbuch2 () {
        // Telefonbuch mit initial 4 Einträgen
        leute = new Person[4];
    }
    /**
     * Einfügen einer neuen Telefonnummer mit automatischem
     * Vergrössern um 50% des Telefonbuchs
     * @param p Person
     */
    public void einfuegen(Person p) {
        //Leere Einträge haben keine Telefonummer!
        int pos=0; //Suchposition
        while ((pos<leute.length)
                && (leute[pos]!=null)
        ) pos++;
        if (pos>=leute.length) // kein freier Eintrag!
        { // Feld um 50% vergroessern und alles umkopieren
            Person[] tempFeld;
            tempFeld = new Person[leute.length*3/2];
            System.arraycopy(leute,0,tempFeld,0,leute.length);
            leute = tempFeld;
            // Jetzt ist Platz um etwas pos zu speichern!
        }
        leute[pos]= p;
    }
    /**
     * Loeschen eines Datensatzes wenn alle Parameter identisch sind
     * @param p zu löschende Person
     */
    public void loesche(Person p) {
        //Leere Einträge haben keine Telefonummer!
        int pos=0; //Suchposition
        while ((pos<leute.length) // Noch nicht am Ende des Feldes
                && (leute[pos]!=null) // Es gibt einen Eintrag
                && !(leute[pos].equals(p)) ) // Er passt nicht
            pos++;
        if (pos<leute.length) // Kandidat zum loeschen steht aus pos
        { // Suche hoechsten Eintrag
            int loesche = pos;
            while ((pos<leute.length)
                    && (leute[pos]!=null)
            ) pos++;
            pos--; // Einmal zurücksetzen
            // Höchsten Datensatz umkopieren und dann ausnullen
            // Der alte Datensatz wird dereferenziert
            leute[loesche] = leute[pos];
            leute[pos] = null;
        }
    }
    /**
     * Ausdrucken des Telefonbuchs
     */
    public void drucken() {
        System.out.println("Telefonbuch. Groesse: " + leute.length);
        for (int i=0; i< leute.length; i++)
            System.out.println("[" + i + "]: " +leute[i]);
    }
    /**
     * Testroutine
     */
    public static void test() {
        Telefonbuch2 buch = new Telefonbuch2();
        System.out.println("*** Leeres Telefonbuch ***");
        buch.einfuegen(new Person("Manuel","Neuer","0171 1"));
        buch.einfuegen(new Person("Philipp","Lahm","0171 2"));
        buch.einfuegen(new Person("Jérome","Boateng","0171 3"));
        buch.einfuegen(new Person("Mats","Hummels","0171 4"));
        buch.einfuegen(new Person("Benedikt","Höwedes","0171 5"));
        buch.einfuegen(new Person("Christoph","Kramer","0171 6"));
        buch.einfuegen(new Person("Bastian","Schweinsteiger","0171 8"));
        buch.einfuegen(new Person("Thomas","Müller","0171 9"));
        buch.einfuegen(new Person("Toni","Kroos","0171 10"));
        buch.einfuegen(new Person("Per","Mertesacker","0171 11"));
        buch.einfuegen(new Person("Miroslav","Klose","017 12"));
        //
        System.out.println("*** Ganze Mannschaft im Telefonbuch ***");
        buch.drucken();
        System.out.println("*** Kramer raus, Schürrle rein ***");
        buch.loesche(new Person("Christoph","Kramer","0171 6"));
        buch.einfuegen(new Person("André","Schürrle","0171 7"));
        buch.drucken();
        System.out.println("*** Klose raus, Götze rein ***");
        buch.einfuegen(new Person("Miroslav","Klose","017 12"));
        buch.einfuegen(new Person("Mario","Götze","0171 13"));
        buch.drucken();
        System.out.println("... und Weltmeister");
    }
    /**
     * Hauptprogramm
     * @param args
     */
    public static void main(String[] args) {
        test();
    }
}
