package s2.listen;
/**
 *
 * @author s@scalingbits.com
 */
public class Listenknoten {
    private Listenknoten vorgaenger;
    private Listenknoten nachfolger;
    private int wert;

public Listenknoten(int einWert) { wert=einWert;}
   public Listenknoten getNachfolger() { return nachfolger;}
   public void setNachfolger(Listenknoten nachfolger) {
        this.nachfolger = nachfolger;
    }
    public Listenknoten getVorgaenger() {
        return vorgaenger;
    }
    public void setVorgaenger(Listenknoten vorgaenger) {
        this.vorgaenger = vorgaenger;
    }
    public int getWert() {
        return wert;
    }
    public void setWert(int wert) {
        this.wert = wert;
    }
     /**
     * Erlaubt den Zahlenwert als Text auszudrucken
     * @return Wert des Objektes
     */
    @Override
    public String toString() { return Integer.toString(wert);}
}
