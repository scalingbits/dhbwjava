package s1.block11;

import java.util.Arrays;

/**
 *
 * @author s@scalingbits.com
 * @ version 1.1
 */
public class TestEuro {
    public static void main(String[] args) {
        System.out.println("Phase 1: Einfache Tests");
        Euro konto1 = new Euro(172, 12);
        long d1 = konto1.longValue();
        System.out.println("   Euro.longValue().Sollwert 172; Istwert: " + d1);
        double d2 = konto1.doubleValue();
        System.out.println("   Euro.doubleValue().Sollwert 172.12; Istwert: " + d2);
        float d3 = konto1.floatValue();
        System.out.println("   Euro.floatValue().Sollwert 172.12; Istwert: " + d3);
        System.out.println("   Euro.symbol().Sollwert €; Istwert: " + konto1.symbol());
        System.out.println("   Euro.toString().Sollwert 172.12€; Istwert: " + konto1);
        System.out.println("Phase 2: Härtere Tests");
        Euro konto2 = new Euro(-380, 25);
        d1 = konto2.longValue();
        System.out.println("   Euro.longValue().Sollwert -380; Istwert: " + d1);
        d2 = konto2.doubleValue();
        System.out.println("   Euro.doubleValue().Sollwert -380.25; Istwert: " + d2);
        d3 = konto2.floatValue();
        System.out.println("   Euro.floatValue().Sollwert -380.25; Istwert: " + d3);
        Euro konto3 = new Euro (-382,225);
        d1 = konto3.longValue();
        System.out.println("   Euro.longValue().Sollwert -382; Istwert: " + d1);
        d2 = konto3.doubleValue();
        System.out.println("   Euro.doubleValue().Sollwert -382; Istwert: " + d2);
        d3 = konto3.floatValue();
        System.out.println("   Euro.floatValue().Sollwert -382; Istwert: " + d3);
        System.out.println("Phase 3: Multiplikation testen");
        Waehrung konto10 = new Euro(1,23);
        double m1 = 2;
        Waehrung konto11 = konto10.mult(m1);
        System.out.println("   Euro.mult(): "+konto10 +" * "+ m1 + " = " + konto11);
        Waehrung konto20 = new Euro(1,98);
        double m2 = 2;
        Waehrung konto21 = konto20.mult(m2);
        System.out.println("   Euro.mult(): "+konto20 +" * "+ m2 + " = " + konto21);
        Waehrung konto30 = new Euro(-1,98);
        double m3 = 2;
        Waehrung konto31 = konto30.mult(m3);
        System.out.println("   Euro.mult(): "+konto30 +" * "+ m3 + " = " + konto31);
        Waehrung konto40 = new Euro(-1,98);
        double m4 = -2;
        Waehrung konto41 = konto40.mult(m4);
        System.out.println("   Euro.mult(): "+konto40 +" * "+ m4 + " = " + konto41);
        Waehrung konto50 = new Euro(10,10);
        double m5 = -2.01;
        Waehrung konto51 = konto50.mult(m5);
        System.out.println("   Euro.mult(): "+konto50 +" * "+ m5 + " = " + konto51);
        Waehrung konto60 = new Euro(10,1);
        double m6 = -2.001;
        Waehrung konto61 = konto60.mult(m6);
        System.out.println("   Euro.mult(): "+konto60 +" * "+ m6 + " = " + konto61);
        System.out.println("Phase 4: Einfache Tests für Comparable");
        if (konto1.compareTo(konto2) >0)
        {System.out.println("   "+konto1 + " ist groeßer als " + konto2);}
        else
        {System.out.println("   "+konto1 + " ist nicht groeßer als " + konto2);}
        if (konto3.compareTo(konto2) >0)
        {System.out.println("   "+konto3 + " ist groeßer als " + konto2);}
        else
        {System.out.println("   "+konto3 + " ist nicht groeßer als " + konto2);}
        sortierTest();
    }
    public static void sortierTest() {
        System.out.println("Phase 4: Testen der Schnittstelle Comparable");
        Euro[] bank = {
                new Euro(99,99),
                new Euro(66,66),
                new Euro(33,33),
                new Euro(11,11),
                new Euro(22,22),
                new Euro(88,88),
                new Euro(55,55),
                new Euro(22,22),
                new Euro(44,44),
                new Euro(0,0)};
        System.out.println("   Unsortiertes Feld:");
        for (Euro konto : bank) System.out.println("      "+konto);
        // Diese Methode sortiert ein Feld in seiner natürlichen Ordnung
        // Die ntürliche Ordnung wird durch die Schnittstelle Comparable
        // festgelegt
        Arrays.sort(bank);
        System.out.println("   Sortiertes Feld:");
        for (Euro konto : bank) System.out.println("      "+konto);
    }
}
