package s1.block5;

public class Adressbuch {
    private static Adressbuch myInstance;

    private Adressbuch() {
        // Initialisiere Adressbuch
    }

    public static Adressbuch getAdressbuch() {
        if (myInstance == null) myInstance = new Adressbuch();
        return myInstance;
    }

    public static void main(String[] args) {
        Adressbuch ab = getAdressbuch();
        Adressbuch cd = getAdressbuch();
    }
}
