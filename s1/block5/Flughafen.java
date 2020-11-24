package s1.block5;
public class Flughafen {
    String name;
    public Flugzeug gate1;
    Flugzeug gate2;
    Flugzeug gate3;
    public Flugzeug gate4;
    Flugzeug gate5;
    Flugzeug gate6;
    double treibstoffLager;

    public static void main(String[] args) {
        Flughafen pad = new Flughafen();
        pad.name="Paderborn";
        pad.treibstoffLager = 1000000;

        Vorfeldbus bus1 = Vorfeldbus.busausliefern("PAD");
        Vorfeldbus bus2 = Vorfeldbus.busausliefern("PAD");


        // Boeing 747, https://de.wikipedia.org/wiki/Boeing_747#747-400
        Flugzeug lh1 = new Flugzeug("ABTL",450000,200,200);
        lh1.einsteigen();

        double aktGewicht=lh1.gewicht();
        System.out.println("gewicht" + aktGewicht);

        lh1.drucken();

        pad.gate1 = lh1;
        pad.gate2 = lh1;
        System.out.println("Boarding für lh1 nach Mannheim...");
        pad.gate1.einsteigen();
        pad.gate1.einsteigen();
        pad.gate2.einsteigen();
        lh1.einsteigen();

        lh1.drucken();

        // Airbus A380 https://de.wikipedia.org/wiki/Airbus_A380#A380-800
        Flugzeug lh2 = new Flugzeug("ABTL",500000,100,200);

        lh2.einsteigen();

        lh2.drucken();

        pad.gate2 = lh2;

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1.kennzeichen);
        System.out.println("Am Gate 2: " + pad.gate2.kennzeichen);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");

        // Hänge Flugzeug um. mover bewegt Flugzeug
        // von Gate 1 nach Gate 3

        Flugzeug mover = pad.gate1;
        pad.gate1=null;

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2.kennzeichen);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");

        pad.gate3= mover;
        mover=null;

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2.kennzeichen);
        System.out.println("Am Gate 3: " + pad.gate3.kennzeichen);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");

        System.out.println("Mein Tower: " + Luftraumkontrolle.meineLuftraumkontrolle());
        System.out.println("Mein Tower: " + Luftraumkontrolle.meineLuftraumkontrolle());
    }
}