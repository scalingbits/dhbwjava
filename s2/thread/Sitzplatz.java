package s2.thread;

/**
 *
 * @author s@scalingbits.com
 */
public class Sitzplatz {
    private boolean frei = true;
    private String reisender;
    
    boolean istFrei() {return frei;}
    
    /**
     * Buche einen Sitzplatz für einen Kunden falls er frei ist
     * @param kunde Name des Reisenden
     * @return erfolg der Buchung
     */
    synchronized boolean belegeWennFrei(String kunde) {
        boolean erfolg = frei; // Kein Erfolg wenn nicht frei
        if (frei) {
            reisender = kunde;
            frei = false;
        }
        return erfolg;
    }

}
