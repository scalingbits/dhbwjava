package s1.block10;
public class LimitAusnahme extends UeberweisungsAusnahme {
    public int limit;
    public LimitAusnahme(String text, int ll) {
        super(text);
        limit = ll;
    }
}