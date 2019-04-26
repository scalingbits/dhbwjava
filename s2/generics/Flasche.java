package s2.generics;
/**
 *
 * @author s@scalingbits.com
 */
public class Flasche {

    Getraenk inhalt = null;

    public boolean istLeer() {
        return (inhalt == null);
    }

    public void fuellen(Getraenk g) {
        inhalt = g;
    }

    public Getraenk leeren() {
       Getraenk result = inhalt;
        inhalt = null;
        return result;
    }

    public static void main(String[] varargs) {
        // in generischer Implementierung soll
        // f1 nur für Bier dienen
        Flasche f1 = new Flasche();
        f1.fuellen(new Bier("DHBW-Bräu"));
        System.out.println("f1 geleert mit " + f1.leeren());
        f1 = new Flasche();
        f1.fuellen(new Bier("DHBW-Export"));
        System.out.println("f1 geleert mit " + f1.leeren());

        // In der generischen Implementierung soll f2 nur für
        // Weinflaschen dienen
        Flasche f2;
        f2 = new Flasche();
        f2.fuellen(new Weisswein("Pfalz"));
        System.out.println("f2 geleert mit " + f2.leeren());

        f2 = new Flasche();
        f2.fuellen(new Rotwein("Bordeaux"));
        System.out.println("f2 geleert mit " + f2.leeren());
    }
}
