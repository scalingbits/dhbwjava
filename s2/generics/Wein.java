package s2.generics;

/**
 *
 * @author s@scalingbits.com
 */
public class Wein extends Getraenk {

    private final String herkunft;

    public String getHerkunft() {
        return herkunft;
    }

    @Override
    public String toString() {
        return ("Wein aus " + herkunft);
    }

    public Wein(String origin) {
        herkunft = origin;
    }

}
