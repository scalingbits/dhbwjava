package s1.airlineSolution.block1;

/**
 *
 * @author s@scalingbits.com
 */
public class Flughafen {
    String name;
    Flugzeug gate1;
    Flugzeug gate2;
    Flugzeug gate3;
    Flugzeug gate4;
    Flugzeug gate5;
    Flugzeug gate6;
    double treibstoffLager;
    
    public static void main(String[] args) {
        Flughafen pad = new Flughafen();
        pad.name="Paderborn";
        pad.treibstoffLager = 1000000;
        
        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");
        
        // Boeing 747, https://de.wikipedia.org/wiki/Boeing_747#747-400
        Flugzeug lh1 = new Flugzeug();
        lh1.kennzeichen ="D-ABTL";
        
        pad.gate1 = lh1;
        
        // Airbus A380 https://de.wikipedia.org/wiki/Airbus_A380#A380-800
        Flugzeug lh2 = new Flugzeug();
        lh2.kennzeichen = "D-AIMA";
        
        pad.gate2 = lh2;
        
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1.kennzeichen);
        System.out.println("Am Gate 2: " + pad.gate2.kennzeichen);
    

        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + pad.name);
        System.out.println("Am Gate 1: " + pad.gate1);
        System.out.println("Am Gate 2: " + pad.gate2);
        System.out.println("Am Gate 3: " + pad.gate3);
        System.out.println("Treibstoff: " + pad.treibstoffLager);
        System.out.println("***********************");
           
    }
}