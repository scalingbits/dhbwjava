package s1.array;
/**
 *
 * @author s@scalingbits.com
 */
public class Person {
    final private String vorname;
    final private String nachname;
    final private String telefonnummer;
    /**
     * Der Konstruktor erlaubt das Belegen der Attribute. Sie können
     * spaeter nicht mehr geändert werden
     * @param vn Vorname
     * @param nn Nachname
     * @param nr Telefonnummer
     */
    public Person (String vn, String nn, String nr) {
        vorname = vn;
        nachname = nn;
        telefonnummer = nr;
    }
    /**
     * Standardisierte Vergeleichsoperation in Java
     * @param o Das Objekt mit dem verglichen werden soll
     * @return wahr wenn Objekte gleich sind
     */
    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return ((vorname.equals(p.vorname))
                &&(nachname.equals(p.nachname))
                &&(telefonnummer.equals(p.telefonnummer)));
    }
    /**
     * Standardisierte Methode zum Konvertieren eines Objekts in eine
     * Zeichenkett
     * @return Das Objekt in einer Repräsentation als Zeichenkette
     */
    @Override
    public String toString(){
        return (" " +vorname + " | " + nachname + " | " + telefonnummer +" |");
    }
}
