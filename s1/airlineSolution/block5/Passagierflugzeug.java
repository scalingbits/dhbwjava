package s1.airlineSolution.block5;

/**
 *
 * @author s@scalingbits.com
 *
 */
public class Passagierflugzeug {
    String kennzeichen;
    int passagiere;
    int besatzung;
    private double treibstoff;
    double leergewicht;
    final double durchschnittsgewicht=75;
    final double gewichtKerosin= 0.845d;
    double maxTreibstoff = 100000;
    final int maxPassagiere;
    final double maxGewicht;
    /**
     * Beim Anlegen eines Flugzeuges werden die wichtigsten invarianten
     * Größen erfasst
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     * @param maxPassagiere maximale Anzahl der Passagiere
     * @param leergewicht Leergewicht des Flugzeugs
     * @param maxGewicht Maximalgewicht des Flugzeugs
     */
    public Passagierflugzeug(String kennzeichen, int maxPassagiere, double leergewicht,
                             double maxGewicht) {
        this.kennzeichen = kennzeichen;
        this.maxPassagiere = Math.max(maxPassagiere, 0);
        this.besatzung = 0;
        this.treibstoff = 0;
        this.leergewicht = leergewicht;
        this.maxGewicht = Math.max(maxGewicht, leergewicht);
    }
    /**
     * Alternatives Anlegen eines Flugzeugs
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     * @param maxPassagiere maximale Anzahl der Passagiere
     * @param leergewicht Leergewicht des Flugzeugs
     */
    public Passagierflugzeug(String kennzeichen, int maxPassagiere, double leergewicht) {
        this(kennzeichen,maxPassagiere,leergewicht,2*leergewicht);
        // Hier kann man noch spezielles machen...
    }

    /**
     * Anlegen eines Airbus A320 (zum Bsp.)
     * @param kennzeichen das was da hinten auf dem Leitwerk steht...
     */
    public Passagierflugzeug(String kennzeichen) {
        this(kennzeichen,120,400000F);
        besatzung++; //Ein Pilot
        System.out.println("Flugzeug ist fertig");
    }
    /**
     * 
     * @param angebot Menge des anbebotenen Treibstoffs
     * @return wirklich getankter Treibstoff
     */
    public double tanken(double angebot) {
        if (angebot <= maxTreibstoff-treibstoff) {
            treibstoff += angebot;
            return angebot;
        }
        else {
            double zutanken = maxTreibstoff-treibstoff;
            treibstoff = maxTreibstoff;
            return  zutanken;
        }
    }

    /**
     * Tankinhalt in Liter
     * @return  Tankinhalt
     */
    public double getankt() {return treibstoff;}
    
    /**
     * 
     * @return aktuelles Gesamtgewicht des Flugzeugs 
     */
    public double gewicht() {
        double meinGewicht = leergewicht + passagiere*durchschnittsgewicht+
                besatzung*durchschnittsgewicht+treibstoff*gewichtKerosin;
        return meinGewicht;
        
    }
    
    /**
     * Einsteigen einer einzelnen Person.
     * Es gibt keine Rückmeldung wenn das Flugzeug bereits voll ist
     * und der Passagier nicht einsteigen konnte.
     */
    public void einsteigen() {
        if (passagiere < maxPassagiere) passagiere++;
    }
    /**
     * Einsteigen einer Anzahl von Personen. Es gibt keine Rückmeldung
     * wenn die maximale Passagieranzahl erreicht ist.
     * @param i Anzahl der Personen die einsteigen
     */
    public void einsteigen(int i) {
        if (passagiere + i <= maxPassagiere) passagiere += i;
        else passagiere=maxPassagiere;
    }
    /**
     * Aussteigen einer einzelnen Person.
     * Es gibt keine Rückmeldung wenn das Flugzeug bereits leer ist
     * und ein Passagier nicht aussteigen konnte.
     */
    public void aussteigen() {
        if (passagiere > 0) passagiere--;
    }
    /**
     * Aussteigen einer ANzahl von Personen. Es gibt keine Rückmeldung
     * wenn die maximale Passagieranzahl erreicht ist.
     * @param i Anzahl der Personen die aussteigen
     */
    public void aussteigen(int i) {
        if (passagiere >= i) passagiere -= i;
        else passagiere=0;
    }
    
    public int anzahlPassagiere() {return passagiere;}
    

    /**
     * Erzeugen einer Zeichenkette zum Erkennen des Objekts
     * @return Daten des Flugzeugs als Zeichenkette
     **/
    @Override
    public String toString() {
        return kennzeichen + ", Passagiere: " + passagiere + 
                ", Besatzung: " + besatzung+ ", Treibstoff: " + treibstoff + "l"
                + " Gesamtgewicht " + gewicht(); 
    }
    
}
