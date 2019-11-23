package s1.block11;
import static java.lang.Math.signum;
/**
 *
 * @author s@scalingbits.com
 * @version 1.2
 */
public class Dollar extends Number{
    public final long cents;
    public Dollar(int dollars, int cents) {
        // Ignoriere Centsbetrag wenn er nicht im richtigen Intervall ist
        if ((cents<0) || (99<cents)) cents=0;
        if (dollars == 0)
            this.cents = cents;
        else
            // Signum ist notwendig da
            // -2.20= -2 - 0.2 sind. Falsch: -2 + 0.2 ergibt -1.8!
            this.cents = dollars*100+cents*(long)signum(dollars);
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
}
