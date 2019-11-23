package s1.block11;
public class TestDollar {
    /**
     *
     * Das Hauptprogramm benötigt keine Parameter
     * Es testet die wichtigsten Eigenschaften der Klasse Dollar
     */
    public static void main(String[] args) {
        System.out.println("Phase 1: Einfache Tests");
        Dollar konto1 = new Dollar(172, 12);
        long d1 = konto1.longValue();
        System.out.println("Dollar.longValue().Sollwert 172; Istwert: " + d1);
        double d2 = konto1.doubleValue();
        System.out.println("Dollar.doubleValue().Sollwert 172.12; Istwert: " + d2);
        float d3 = konto1.floatValue();
        System.out.println("Dollar.floatValue().Sollwert 172.12; Istwert: " + d3);
        System.out.println("Phase 2: Härtere Tests");
        Dollar konto2 = new Dollar(-380, 25);
        d1 = konto2.longValue();
        System.out.println("Dollar.longValue().Sollwert -380; Istwert: " + d1);
        d2 = konto2.doubleValue();
        System.out.println("Dollar.doubleValue().Sollwert -380.25; Istwert: " + d2);
        d3 = konto2.floatValue();
        System.out.println("Dollar.floatValue().Sollwert -380.25; Istwert: " + d3);
        Dollar konto3 = new Dollar (-382,225);
        d1 = konto3.longValue();
        System.out.println("Dollar.longValue().Sollwert -382; Istwert: " + d1);
        d2 = konto3.doubleValue();
        System.out.println("Dollar.doubleValue().Sollwert -382; Istwert: " + d2);
        d3 = konto3.floatValue();
        System.out.println("Dollar.floatValue().Sollwert -382; Istwert: " + d3);
    }
}
