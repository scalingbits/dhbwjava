package s2.generics.intro;

/**
 *
 * @author s@scalingbits.com
 * @param <T> der Einwohner des Zimmers
 */
public class Zimmer<T> {
    private T insasse;
    public void rein(T p) {
        insasse = p;
    }
    
    public T einwohner() {
        return insasse;
    }
    
}
