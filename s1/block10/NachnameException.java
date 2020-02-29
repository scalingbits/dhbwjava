package s1.block10;

public class NachnameException extends RuntimeException {
    final public String vorname;

    public NachnameException(String vn) {
        super(vn + " hat keinen Nachnamen");
        vorname = vn;
    }
}
