package s1.block9;

/**
 *
 * @author s@scalaingbits.com
 */
public class TierTest {

    private static Haustier[] hausTiere;

    public static void main(String[] args) {
        populate();
        neuerLieblingsvogel();
        iterate();
    }

    public static void populate() {
        hausTiere = new Haustier[6];

        hausTiere[0] = new Vogel("Hansi", 50.55f, true);
        hausTiere[1] = new Vogel("Piep", 50.44f, false);
        hausTiere[2] = new Hund("Waldi", 222.22f, "Dackel");
        hausTiere[3] = new Hund("Fiffi", 202.22f, "Terrier");
        hausTiere[4] = new Katze("Isis", 88.88f, (Vogel) hausTiere[0]);
        hausTiere[5] = new Katze("Napoleon", 77.77f, null);
    }

    public static void neuerLieblingsvogel() {
        Vogel v;
        Katze k;
        if ((hausTiere[1] instanceof Vogel)
                && (hausTiere[4] instanceof Katze)) {
            v = (Vogel) hausTiere[1];
            k = (Katze) hausTiere[4];
            k.setVogel(v);
        }
    }

    public static void iterate() {
        double kosten = 0;
        for (int i = 0; i < hausTiere.length; i++) {
            kosten += hausTiere[i].getKostenTierarzt();
            System.out.println(
                    "Art: " + hausTiere[i].getClass().getSimpleName()
                            + "; " + hausTiere[i].beschreibung());
        }
        System.out.println("Gesamtjahrekosten "+ kosten +" Euro");
    }
}