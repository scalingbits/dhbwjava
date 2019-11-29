package s1.airlineSolution.block10;

/**
 *
 * @author s@scalingbits.com
 */
public class Flughafen {

    String name;
    Passagierflugzeug[] gates;
    // 1. Neu in Block 8: Ein Vorfeld für Flugzeuge
    Flugzeug[] vorfeld;
    float treibstofflager;

    public Flughafen(String name, int anzahlGates) {
        vorfeld = new Flugzeug[10]; // Fest für jeden Flughafen
        this.name = name;
        if (anzahlGates > 0)
            gates = new Passagierflugzeug[anzahlGates];
    }

    public void andocken(int gatenr, Passagierflugzeug f) {
        if ((gatenr >= 0) && (gates.length-1 >= gatenr))
            gates[gatenr] = f;
    }

    public Passagierflugzeug anGate(int gatenr) {
        return gates[gatenr];
    }

    public void drucken() {
        System.out.println(" *** Status Flughafen: " + name);
        for ( int i = 0; i< gates.length; i++)
        {
            if (gates[i] == null)
                System.out.println("Gate " + i + ": ist leer.");
            else
                System.out.println("Gate " + i + ": "  +
                        anGate(i).getKennzeichen());
        }
        System.out.println("Vorfeld");
        for (Flugzeug f: vorfeld) {
            if (f != null) System.out.println(f.kennzeichen +
                    ", Gewicht: " + f.gewicht());
            else System.out.println("Leere Vorfeldposition");
        }
        System.out.println("Treibstoff: " + treibstofflager);
        System.out.println(" ******");
    }

    public static void main(String[] args) {

        Flughafen paderborn = new Flughafen("Paderborn",6);
        paderborn.treibstofflager = 1_000_000F;
        paderborn.vorfeld[0] = new Frachtflugzeug("D-AAA1", 200000F);
        paderborn.vorfeld[1] = new Frachtflugzeug("D-AAA2", 200000F);
        paderborn.vorfeld[2] = new Frachtflugzeug("D-AAA3", 200000F);
        paderborn.vorfeld[3] = new Passagierflugzeug("D-AAA4",170, 200000F);

        //Mehr Gates machen die Ausgabe sehr lang...
        Flughafen fra = new Flughafen("Frankfurt", 9);

        Passagierflugzeug meinFlieger = new Passagierflugzeug("D-ABDT", 119, 20_000F);
        meinFlieger.setBesatzung(4);
        meinFlieger.einsteigen(64);
        meinFlieger.treibstoff = 4_000.5F;

        Passagierflugzeug deinFlieger = meinFlieger;
        System.out.println("deinFlieger Passagiere: " + deinFlieger.anzPassagiere());

        System.out.println("meinFlieger Passagiere: " + meinFlieger.anzPassagiere());

        paderborn.andocken(1,meinFlieger);
        paderborn.andocken(2, Passagierflugzeug.baueAirbusA320("D-ACCC"));
        paderborn.andocken(3,paderborn.gates[2]);
        paderborn.andocken(4, Passagierflugzeug.baueAirbusA320("D-ADDD"));
        //

        paderborn.drucken();
        fra.drucken();
        System.out.println("Gewicht Flugzeug Gate1 "
                + paderborn.anGate(1).gewicht());
        System.out.println("Gewicht Flugzeug Gate2 "
                + paderborn.anGate(2).gewicht());

        System.out.println("Passagiere im Fl. am Gate 1: "
                + paderborn.anGate(1).anzPassagiere());
        System.out.println("Letzter Aufruf Boarding am Gate 1...");
        paderborn.anGate(1).einsteigen(10);
        System.out.println("Passagiere im Fl. am Gate 1: "
                + paderborn.anGate(1).anzPassagiere());
        System.out.println("Alle DHBW Studenten einsteigen");
        paderborn.anGate(1).einsteigen(100);
        paderborn.anGate(1).einsteigen();
        System.out.println("Passagiere im Fl. am Gate 1: "
                + paderborn.anGate(1).anzPassagiere()
                + " Besatzung: " + paderborn.anGate(1).lese_Besatzung());
        paderborn.anGate(1).alleEinsteigen(10, 2);
        System.out.println("Passagiere im Fl. am Gate 1: "
                + paderborn.anGate(1).anzPassagiere()
                + " Besatzung: " + paderborn.anGate(1).lese_Besatzung());
        System.out.println("Was wiegt ein Passagier?");
        System.out.println(Flugzeug.duchschnittsgewicht);
        System.out.println("Was wiegt ein Passagier maximal?");
        System.out.println(Flugzeug.maxPassagierGewicht());

        paderborn.drucken();

        Frachtflugzeug jumbo = new Frachtflugzeug("D-AFF1", 10000F);
        jumbo.laden(100F);
        jumbo.entladen(50F);

        paderborn.vorfeld[4] = jumbo;

        paderborn.drucken();
        // Viel Zeit vergangen
        // Variablennamen vergessen...
        // Laden Sie 20kg auf dem Flugzeug auf Vorfeldposition 4 aus...
        // ==> Das muss ein Frachtflugzeug sein

        Frachtflugzeug meinFrachter;

        if (paderborn.vorfeld[4] instanceof Frachtflugzeug) {
            meinFrachter =  (Frachtflugzeug) paderborn.vorfeld[4];
            meinFrachter.entladen(50F);
        }
        else System.out.println(paderborn.vorfeld[4] + " ist kein Frachter");
        // Ein Passagierflugzeug ist kein Frachtflugzeug
        //System.out.println("Mein Typ: " + paderborn.vorfeld[3].getClass()) ;
        //Frachtflugzeug meinF =  (Frachtflugzeug) paderborn.vorfeld[3];
        //System.out.println("Kennzeichen: " + meinF.kennzeichen);
        //meinF.entladen(100F);

        paderborn.drucken();

    }

}
