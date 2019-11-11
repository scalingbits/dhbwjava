package s1.airlineSolution.block4;

/**
 *
 * @author s@scalingbits.com
 * Implementiere einen Konstruktor
 */
public class Flugzeug {
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
    public Flugzeug(String kennzeichen, int maxPassagiere, double leergewicht,
            double maxGewicht) {
        this.kennzeichen = kennzeichen;
        if (maxPassagiere >= 0)
            this.maxPassagiere = maxPassagiere;
        else
            this.maxPassagiere = 0;
        this.besatzung = 0;
        this.treibstoff = 0;
        this.leergewicht = leergewicht;
        if (maxGewicht > leergewicht)
            this.maxGewicht= maxGewicht;
        else
            this.maxGewicht= leergewicht;
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
     * @return 
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
    
    @Override
    /**
     * @return Daten des Flugzeugs als Zeichenkette
     */
    public String toString() {
        return kennzeichen + ", Passagiere: " + passagiere + 
                ", Besatzung: " + besatzung+ ", Treibstoff: " + treibstoff + "l"
                + " Gesamtgewicht " + gewicht(); 
    }
    
}
