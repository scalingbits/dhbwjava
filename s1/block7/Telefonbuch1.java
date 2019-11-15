package s1.block7;

/**
 *
 * @author s@scalingbits.com
 */
public class Telefonbuch1 {
    private String[] vorname;
    private String[] nachname;
    private String[] telefonnummer;
    /**
     * Anlegen eines Telefonbuchs für 4 Einträge
     */
    public Telefonbuch1 () {
        // Telefonbuch mit initial 4 Einträgen
        vorname = new String[4];
        nachname = new String[4];
        telefonnummer = new String[4];
    }
    /**
     * Einfügen einer neuen Telefonnummer mit automatischem
     * Vergrössern um 50% des Telefonbuchs
     * @param vn Vorname
     * @param nn Nachname
     * @param nr Telefonnummer
     */
    public void einfuegen(String vn, String nn, String nr) {
        //Leere Einträge haben keine Telefonummer!
        int pos=0; //Suchposition
        while ((pos<telefonnummer.length)
                && !(telefonnummer[pos]==null)
        ) pos++;
        if (pos>=telefonnummer.length) // kein freier Eintrag!
        { // Feld um 50% vergroessern und alles umkopieren
            String[] tempFeld;
            tempFeld = new String[vorname.length*3/2];
            System.arraycopy(vorname,0,tempFeld,0,vorname.length);
            vorname = tempFeld;
            tempFeld = new String[nachname.length*3/2];
            System.arraycopy(nachname,0,tempFeld,0,nachname.length);
            nachname = tempFeld;

            tempFeld = new String[telefonnummer.length*3/2];
            System.arraycopy(telefonnummer,0,tempFeld,0,telefonnummer.length);
            telefonnummer = tempFeld;
            // Jetzt ist Platz um etwas pos zu speichern!
        }
        vorname[pos]= vn;
        nachname[pos]= nn;
        telefonnummer[pos] = nr;
    }
    /**
     * Loeschen eines Datensatzes wenn alle Parameter identisch sind
     * @param vn vorname
     * @param nn Nachname
     * @param nr Vorname
     */
    public void loesche(String vn, String nn, String nr) {
        //Leere Einträge haben keine Telefonummer!
        int pos=0; //Suchposition
        while ((pos<telefonnummer.length)
                && (telefonnummer[pos]!=null)
                && !(telefonnummer[pos].equals(nr))
                && !(vorname[pos].equals(vn))
                && !(nachname[pos].equals(nn))
        ) pos++;
        if (pos<telefonnummer.length) // Kandidat zum loeschen steht aus pos
        { // Suche hoechsten Eintrag
            int loesche = pos;
            while ((pos<telefonnummer.length)
                    && (telefonnummer[pos]!=null)
            ) pos++;
            pos--; // Einmal zurücksetzen
            // Höchsten Datensatz umkopieren und dann ausnullen
            // Der alte Datensatz wird dereferenziert
            vorname[loesche] = vorname[pos];
            vorname[pos] = null;
            nachname[loesche] = nachname[pos];
            nachname[pos] = null;
            telefonnummer[loesche] = telefonnummer[pos];
            telefonnummer[pos]=null;
        }
    }
    /**
     * Ausdrucken des Telefonbuchs
     */
    public void drucken() {
        System.out.println("Telefonbuch. Groesse: " + telefonnummer.length);
        for (int i=0; i<telefonnummer.length; i++ ){
            System.out.print("[" + i + "]: ");
            System.out.print( vorname[i] + " | ");
            System.out.print( nachname[i] + " | ");
            System.out.println( telefonnummer[i] + " |");
        }
    }
    /**
     * Testroutine
     */
    public static void test() {
        Telefonbuch1 buch = new Telefonbuch1();
        System.out.println("*** Leeres Telefonbuch ***");
        buch.einfuegen("Manuel","Neuer","0171 1");
        buch.einfuegen("Philipp","Lahm","0171 2");
        buch.einfuegen("Jérome","Boateng","0171 3");
        buch.einfuegen("Mats","Hummels","0171 4");
        buch.einfuegen("Benedikt","Höwedes","0171 5");
        buch.einfuegen("Christoph","Kramer","0171 6");
        buch.einfuegen("Bastian","Schweinsteiger","0171 8");
        buch.einfuegen("Thomas","Müller","0171 9");
        buch.einfuegen("Toni","Kroos","0171 10");
        buch.einfuegen("Per","Mertesacker","0171 11");
        buch.einfuegen("Miroslav","Klose","017 12");
        //
        System.out.println("*** Ganze Mannschaft im Telefonbuch ***");
        buch.drucken();
        System.out.println("*** Kramer raus, Schürrle rein ***");
        buch.loesche("Christoph","Kramer","0171 6");
        buch.einfuegen("André","Schürrle","0171 7");
        buch.drucken();
        System.out.println("*** Klose raus, Götze rein ***");
        buch.einfuegen("Miroslav","Klose","017 12");
        buch.einfuegen("Mario","Götze","0171 13");
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
