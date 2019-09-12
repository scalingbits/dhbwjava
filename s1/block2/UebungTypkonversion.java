package s1.block2;

public class UebungTypkonversion {

    public static void main(String[] args) {
        // Alle Werte sind der drittgrößte Wert des jeweiligen Wertebereichs
        short a_short = Short.MAX_VALUE-2;     // short = 16 bit
        int b_int     = Integer.MAX_VALUE-2;   // int = 32 bit
        long c_long   = Long.MAX_VALUE-2;      // long = 64 bit

        // cast auf float: Welche Zuweisungen können zu Präzisionsverlusten führen?
        float c_float = a_short;
        float d_float = b_int;
        float e_float = c_long;

        // cast auf double:Welche Zuweisungen können zu Präzisionsverlusten führen?
        double f_double = a_short;
        double g_double = b_int;
        double h_double = c_long;

        // Auswertelogik und Kontrolle
        System.out.println("a_short=" + a_short);
        System.out.println("a_int=" + b_int);
        System.out.println("a_long=" + c_long);
        System.out.print("short auf float= " + c_float + " ");
        // Sind die Werte nach der Rückkonvertierung noch gleich?
        if (a_short == (short)c_float) {System.out.println("(OK)");}
        else {System.out.println("(Fehler)");}
        System.out.print("int auf float= " + d_float);
        if (b_int == (int)d_float) {System.out.println("(OK)");}
        else {System.out.println("(Fehler)");}
        System.out.print("long auf float= " + e_float);
        if (c_long == (long)e_float) {System.out.println("(OK)");}
        else { System.out.println("(Fehler)");}

        System.out.print("short auf double= " + f_double + " ");
        if (a_short == (short)f_double) {System.out.println("(OK)");}
        else {System.out.println("(Fehler)");}
        System.out.print("int auf double= " + g_double);
        if (b_int == (int)g_double) {System.out.println("(OK)");}
        else {System.out.println("(Fehler)");}
        System.out.print("long auf double= " + h_double);
        if (c_long == (long)e_float) {System.out.println("(OK)");}
        else { System.out.println("(Fehler)");}

        System.out.println("short max"+ Short.MAX_VALUE);
        System.out.println("char max"+ (int)Character.MAX_VALUE);
    }
}
