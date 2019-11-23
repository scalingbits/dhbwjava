package s1.airlineSolution.block5;

/**
 *
 * @author stsch
 */
public class Flughafen {

    String name;
    Passagierflugzeug gate1;
    Passagierflugzeug gate2;
    Passagierflugzeug gate3;
    Passagierflugzeug gate4;
    Passagierflugzeug gate5;
    Passagierflugzeug gate6;
    double treibstoffLager;

    public static void main(String[] args) {
        Flughafen pad = new Flughafen();
        pad.name = "Paderborn";
        pad.treibstoffLager = 1000000;
        
        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");
        

        // Boeing 747, https://de.wikipedia.org/wiki/Boeing_747#747-400
        Passagierflugzeug lh1 = new Passagierflugzeug("D-ABTL", 360, 191000, 400000);
        lh1.besatzung = 16;

        pad.treibstoffLager -= lh1.tanken(1000);

        pad.gate1 = lh1;
        System.out.println("Flugzeug an Gate 1: " + pad.gate1);

        int reisende = 100;
        System.out.println("Boarding Gate1!");
        System.out.println("Bereit zum Einsteigen: " + reisende + " Passagiere");
        for (int i = 0; i < 100; i++) {
            lh1.einsteigen();
        }
        System.out.println("Flugzeug an Gate 1: " + pad.gate1);

        // Airbus A380 https://de.wikipedia.org/wiki/Airbus_A380#A380-800
        Passagierflugzeug lh2 = new Passagierflugzeug("D-AIMN", 526, 286000, 500000);
        lh2.besatzung = 20;
        pad.treibstoffLager -= lh2.tanken(4000);

        pad.gate2 = lh2;
        System.out.println("Am Gate 2: " + pad.gate2);
        
        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");
        
        reisende = 200;
        System.out.println("Boarding Gate 2!");
        System.out.println("Bereit zum Einsteigen: " + reisende + " Passagiere");
        lh2.einsteigen(reisende);
        System.out.println("Flugzeug an Gate 2: " + pad.gate2);

        System.out.println("Ablegen Gate 1");
        pad.gate1 = null;
        System.out.println("Flugzeug an Gate 1: " + pad.gate1);
        System.out.println("Rundflug von " + lh1.kennzeichen);
        System.out.println("Anlegen von " + lh1.kennzeichen + " an Gate 3");
        pad.gate3 = lh1;
        for (int i = lh1.anzahlPassagiere(); i > 0; i--) {
            lh1.aussteigen();
            System.out.println("Willkomen in " + pad.name + " Passagier "
                    + i + "!");
        }

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");

    }

}
