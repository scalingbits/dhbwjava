package s1.airlineSolution.block7;
public class Flughafen {
    String name;

    // 1. Neu in block 7: Die Anzahl der Gates ist variable
    // Alle Zuweisungen zu den Gates müssen korrigiert werdem
    Passagierflugzeug[] gate;
    double treibstoffLager;

    // 2. Neu im Block 7: Der Flughafen wird mit einem Konstruktor initialisiert
    /**
     *
     * @param name Name des Flughafens
     * @param gates Anzahl der Gates
     */
    public Flughafen(String name, int gates) {
        this.name = name;
        gate = new Passagierflugzeug[gates];
    }


    public static void main(String[] args) {

        // 3. Neu in Block 7 : Anlegen eines Flughafen mit einem Konstruktor
        Flughafen pad = new Flughafen("Paderborn",6);
        pad.treibstoffLager = 1000000;


        // Boeing 747, https://de.wikipedia.org/wiki/Boeing_747#747-400
        Passagierflugzeug lh1 = new Passagierflugzeug("ABTL",450000,200,200);
        lh1.einsteigen(120);

        double aktGewicht=lh1.gewicht();
        System.out.println("gewicht" + aktGewicht);

        lh1.drucken();

        pad.gate[1] = lh1;
        pad.gate[2] = lh1;
        System.out.println("Boarding für lh1 nach Mannheim...");
        pad.gate[1].einsteigen(17);
        pad.gate[1].einsteigen(2);
        pad.gate[2].einsteigen();
        lh1.einsteigen(2);

        lh1.drucken();

        // Airbus A380 https://de.wikipedia.org/wiki/Airbus_A380#A380-800
        Passagierflugzeug lh2 = new Passagierflugzeug("ABTL",500000,100,200);

        lh2.einsteigen(100);

        lh2.drucken();

        pad.gate[2] = lh2;

        pad.drucken();

        // Hänge Flugzeug um. mover bewegt Flugzeug
        // von Gate 1 nach Gate 3

        Passagierflugzeug mover = pad.gate[1];
        pad.gate[1]=null;

        pad.drucken();

        pad.gate[3]= mover;
        mover=null;

    }

    /**
     * druckt alle wichtigen Informationen ueber einen Flughafen auf die Konsole
     */
    public void drucken() {
        System.out.println("*** Unser Flughafen ***");
        System.out.println("Flughafen " + name);
        for (int i=0; i<gate.length; i++) {
            if (gate[i] != null)
                System.out.println("Am Gate " + i +": " + gate[i]);
            else
                System.out.println("Gate " + i +" unbelegt");
        }
        System.out.println("Treibstoff: " + treibstoffLager);
        System.out.println("***********************");
    }
}