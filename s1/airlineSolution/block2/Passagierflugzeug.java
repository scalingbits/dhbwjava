package s1.airlineSolution.block2;

/**
 *
 * @author s@scalingbits.com
 * // Implementiere Passagiere, Anzahl Besatzung, Methode toString
 */
public class Passagierflugzeug {
    String kennzeichen;
    int passagiere;
    int besatzung;
    double treibstoff;
    double leergewicht;
    final double durchschnittsgewicht=75;
    final double gewichtKerosin= 0.845d;

    /**
     * Hier wird das aktuelle Gewicht berechnet
     * @return Gesamtgewicht des Flugzeuges
     */
    public double gewicht() {
        double meinGewicht = leergewicht + passagiere*durchschnittsgewicht+
                besatzung*durchschnittsgewicht+treibstoff*gewichtKerosin;
        return meinGewicht;
        
    }

    /**
     * Diese Methode erzeugt eine Zeichenkette mit dem Zustand des Flugzeugs
     * @return alle Daten des Flugzeugs als Zeichenkette
     */
    public String toString() {
        return kennzeichen + ", Passagiere: " + passagiere + 
                ", Besatzung: " + besatzung+ ", Treibstoff: " + treibstoff + "l"
                + " Gesamtgewicht: " + gewicht() +"kg"; 
    }
    
}
