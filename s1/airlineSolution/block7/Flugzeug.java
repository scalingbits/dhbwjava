package s1.airlineSolution.block7;
public class Flugzeug {
    public String kennzeichen; // Ein Attribut vom Typ einer Zeichenkette
    // 1. Privates Attribut zur Verwaltung der Passagierkapazität
    //     Tipp: Untersuchen Sie die Druckmethode zur Wahl der
    //           Variablennamen (1-5)!
    private int maxPassagiere;
    // 2. Privates Attribut zur Verwaltung der aktuellen Pasagiere
    private int passagiere;
    // 3. Leergewicht in privates Attribut ändern
    public int leergewicht; // Ein Attribut vom Type einer Ganzzahl
    // 4. Maximales Gewicht des Flugzeugs
    private int maxgewicht;
    // 5. Öffentliche Konstante für durchschn. Passagiergewicht
    public final int PASSAGIERGEWICHT = 85;

    // Anzahl aller erzeugten Flugzeuge
    private static int objekte;

    /**
     * 8. Konstruktor implementieren
     * Konstruktur der Klasse Flugzeug
     * @param kennz     Kennzeichen des Flugzeugs
     * @param kapazitaet Passagierkapazität
     * @param leergew   Leergewicht in kg
     * @param maxgew    Maximalgewicht in kg
     */
    public Flugzeug(String kennz, int kapazitaet, int leergew, int maxgew) {
        kennzeichen = kennz;
        objekte++;
        // Prüfen ob Kapazität größere Null ist
        if (kapazitaet >= 0) {
            maxPassagiere = kapazitaet;
        } else {
            maxPassagiere = 0;
        }
        // Prüfen ob Leergewicht größer Null ist
        if (leergew > 0) {
            leergewicht = leergew;
        } else {
            leergewicht = 0;
        }
        // Prüfen ob Maximalgewicht größer-gleich Leergeicht ist.
        if (maxgew > leergewicht) {
            maxgewicht = maxgew;
        } else {
            maxgewicht = leergewicht; // Viel Spass...
        }
    }

    /**
     * 10. Fügt einen Passagier zum aktuellen Flugzeug hinzu
     */
    public void einsteigen() {
        if (passagiere < maxPassagiere) {
            passagiere++;
        }
    }

    /**
     *
     * @param anzahl Anzahl der Passagiere die einsteigen sollen
     */
    public void einsteigen(int anzahl) {
        if ((anzahl >0) && (passagiere+anzahl) <= maxPassagiere) {
            passagiere+= anzahl;
        }
    }

    /**
     * 11. Entfernt einen Passagier des aktuellen Flugzeugs
     */
    public void aussteigen() {
        if (passagiere > 0) {
            passagiere--;
        }
    }

    /**
     *
     * @param anzahl Anzahl der Passagiere die aussteigen sollen
     */
    public void aussteigen(int anzahl) {
        if ((anzahl >0) && (passagiere-anzahl) >=0) {
            passagiere-= anzahl;
        }
    }

    /**
     * 12. Ausgabe der aktuellen Anzahl der Passagiere
     * @return aktuelle Anzahl der Passagiere
     */
    public int anzahlPassagiere() {return passagiere;}


    /**
     * 6. Berechnen des aktuellen Gewichts
     * @return aktuelles Gewicht
     */
    public int gewicht() {
        return (leergewicht+ passagiere*PASSAGIERGEWICHT);}

    /**
     * 13. Ausgabe der maximalen Anzahl der Passagiere
     * @return Maximale Anzahl der Passagiere
     */
    public int passagierkapazitaet() {return maxPassagiere;}

    /**
     *
     * @return Anzahl aller erzeugten Objekte der Klasse Flugzeug
     */
    public static int anzahlFlugzeuge() {return objekte;}

    /**
     * Eine Methode zum Drucken der Attributbelegung des Objekts
     * Die Methode erfordert keine Eingaben. Sie erzeugt keine
     * Ausgaben
     */
    public void drucken() {
        // 7. Vervollständigen der Druckmethode
        System.out.println("*****************************");
        System.out.println("Kennzeichen:        " + kennzeichen);
        System.out.println("Leergewicht:        " + leergewicht + "kg");
        System.out.println("Maximalgewicht:     " + maxgewicht + "kg");
        System.out.println("Aktuelles Gewicht : " + gewicht() + "kg");
        System.out.println("Passagiere:         " + passagiere);
        System.out.println("Maximal Anzahl P.:  " + maxPassagiere);
        System.out.println("******************** " + objekte + " Flugz.");
    }

    /**
     * Ueberschriebene Methode die das Kennzeichen anstatt der Objektidentitaet
     * druckt
     * @return
     */
    public String toString() {return kennzeichen;}

}