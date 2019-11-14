package s1.block6.reference;

public class Main {
    public static void main(String[] args) {
        Kraftwagen wagen1 = new Kraftwagen("M-O-4711");
        Kraftwagen wagen2 = wagen1;
        Kraftwagen wagen3 = new Kraftwagen("MA-S-11");
        wagen2 = null;
        wagen3 = null;

        try{
            System.out.println(wagen2.getKennzeichen());
        }
        catch (NullPointerException e)
        {
            System.out.println("Variable wagen2 ist eine Null Referenz");

        }
        if (wagen3!=null)
            System.out.println(wagen3.getKennzeichen());
        else
            System.out.println("Hoppla");
        System.out.println("Diese Zeile des Programms wird nicht erreicht..");

    }

}
