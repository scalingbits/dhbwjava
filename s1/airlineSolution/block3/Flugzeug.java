package s1.airlineSolution.block3;

/**
 *
 * @author s@scalingbits.com
 */
public class Flugzeug {
    String kennzeichen;
    int passagiere;
    int besatzung;
    double treibstoff;
    double leergewicht;
    final double durchschnittsgewicht=75;
    final double gewichtKerosin= 0.845d;
    double maxTreibstoff = 100000;
    
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
     * 
     * @return aktuelles Gesamtgewicht des Flugzeugs 
     */
    public double gewicht() {
        double meinGewicht = leergewicht + passagiere*durchschnittsgewicht+
                besatzung*durchschnittsgewicht+treibstoff*gewichtKerosin;
        return meinGewicht;
        
    }
    @Override
    /**
     * @return Daten des Flugzeugs als Zeichenkette
     */
    public String toString() {
        return kennzeichen + ", Passagiere: " + passagiere + 
                ", Besatzung: " + besatzung+ ", Treibstoff: " + treibstoff + "l"
                + " Gesamtgewicht: " + gewicht() +"kg"; 
    }
    
}
