package s1.airlineSolution.block7;

/**
 *
 * @author s@scalingbits.com
 */
public class Flughafen {

    String name;
    Flugzeug[] gates;
    Flugzeug[] vorfeld;
    float treibstofflager;

    public Flughafen(String name, int anzahlGates) {
        vorfeld = new Flugzeug[10]; // Fest für jeden Flughafen
        this.name = name;
        if (anzahlGates > 0)
            gates = new Flugzeug[anzahlGates];
    }

    public void andocken(int gatenr, Flugzeug f) {
        if ((gatenr >= 0) && (gates.length-1 >= gatenr))
            gates[gatenr] = f;
    }

    public Flugzeug anGate(int gatenr) {
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
            if (f != null) System.out.println(f.kennzeichen);
            else System.out.println("Leere Vorfeldposition");
        }
        System.out.println("Treibstoff: " + treibstofflager);
        System.out.println(" ******");
    }

    public static void main(String[] args) {

        Flughafen paderborn = new Flughafen("Paderborn",6);
        paderborn.treibstofflager = 1_000_000F;
        paderborn.vorfeld[0] = new Flugzeug("D-AAA1",140, 200000F);
        paderborn.vorfeld[1] = new Flugzeug("D-AAA2",150, 200000F);
        paderborn.vorfeld[2] = new Flugzeug("D-AAA3",160, 200000F);

        //Mehr Gates machen die Ausgabe sehr lang...
        Flughafen fra = new Flughafen("Frankfurt", 9);

        Flugzeug meinFlieger = new Flugzeug("D-ABDT", 119, 20_000F);
        meinFlieger.setBesatzung(4);
        meinFlieger.einsteigen(64);
        meinFlieger.treibstoff = 4_000.5F;

        Flugzeug deinFlieger = meinFlieger;
        System.out.println("deinFlieger Passagiere: " + deinFlieger.anzPassagiere());

        System.out.println("meinFlieger Passagiere: " + meinFlieger.anzPassagiere());

        paderborn.andocken(1,meinFlieger);
        paderborn.andocken(2,Flugzeug.baueAirbusA320("D-ACCC"));
        paderborn.andocken(3,paderborn.gates[2]);
        paderborn.andocken(4,Flugzeug.baueAirbusA320("D-ADDD"));

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
    }

}

