package s1.airlineSolution.block3;

/**
 *
 * @author s@scalingbits.com
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
        
        System.out.println("\"*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");

         // Boeing 747, https://de.wikipedia.org/wiki/Boeing_747#747-400
        Passagierflugzeug lh1 = new Passagierflugzeug();
        lh1.kennzeichen ="D-ABTL";
        lh1.passagiere=360;
        lh1.besatzung=20;
        lh1.treibstoff= 1000;
        
        pad.treibstoffLager -= lh1.tanken(1000);
        
        pad.gate1 = lh1;
        System.out.println("Flugzeug an Gate 1: " + pad.gate1);


        // Airbus A380 https://de.wikipedia.org/wiki/Airbus_A380#A380-800
        Passagierflugzeug lh2 = new Passagierflugzeug();
        lh2.kennzeichen ="D-AIMN";
        lh2.passagiere=360;
        lh2.besatzung=16;
        lh2.treibstoff= 4000;
        
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
        

        System.out.println("Ablegen Gate 1");
        pad.gate1 = null;
        System.out.println("Flugzeug an Gate 1: " + pad.gate1);
        System.out.println("Rundflug von " + lh1.kennzeichen);
        System.out.println("Anlegen von " + lh1.kennzeichen + " an Gate 3");
        pad.gate3 = lh1;

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");
    
    }
    
    
}
