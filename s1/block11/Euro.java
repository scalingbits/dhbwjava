package s1.block11;
import static java.lang.Math.abs;
import static java.lang.Math.signum;
/**
 *
 * @author s@scalingbits.com
 * @version 1.2
 */
public class Euro extends Number implements Waehrung, Comparable{
    /**
     * Der gesamte Betrag wird intern in Cents verwaltet
     */
    public final long cents;
    public Euro(long euros, long cents) {
        // Ignoriere Centsbetrag wenn er nicht im richtigen Intervall ist
        if ((cents<0) || (99<cents)) cents=0;
        if (euros == 0)
            this.cents = cents;
        else
            // Signum ist notwendig da
            // -2.20= -2 - 0.2 sind. Falsch: -2 + 0.2 ergibt -1.8!
            this.cents = euros*100+cents*(long)signum(euros);
    }
    @Override
    public int intValue() {
        return (int)cents/100;
    }
    @Override
    public long longValue() {
        return cents/100;
    }
    @Override
    public float floatValue() {
        return cents/100f;
    }
    @Override
    public double doubleValue() {
        return cents/100d;
    }
    @Override
    public String symbol() {
        return "€";
    }
    @Override
    public String toString() {
        // Füge eine Null bei Centbeträgen zwischen 0 und 9 eine
        String leerstelle = ((abs(cents)%100)<10) ? "0" : "";
        return cents / 100L + "." + leerstelle +
                abs(cents % 100L) + symbol();
    }
    @Override
    public Waehrung mult(double d) {
        long temp;
        temp = (long)(cents *d);
        return new Euro(temp/100L,abs(temp%100L));
    }
    @Override
    public int compareTo(Object o) {
        int result;
        if (o instanceof Euro) {
            Euro e = (Euro) o;
            result = (int)(this.cents-e.cents);
        }
        else {result = -1;} // Alles was kein Euro ist, ist kleiner
        return result;
    }
}