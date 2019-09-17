package s1.block4;
public class Dreiecksflaeche {  
    /**
     * Berechnung der Fläche eines Deiecks mit drei beliebigen Seiten.
     * Es wird nicht geprüft ob die Seitenlängen ein korrektes Dreieck ergeben
     * @param a Länge Seite 1
     * @param b Länge Seite 2
     * @param c Länge Seite 3
     * @return Fläche des Dreiecks
     */
    private static double flaeche(double a, double b, double c) {
        System.out.println("Anfang allgemeines Dreieck");
        double s = (a+b+c)/2;
        double erg = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return erg;
    }
    /**
     * Berechnung der Fläche eines gleichschenkligen Deiecks.
     * Es wird nicht geprüft ob die Seitenlängen ein korrektes Dreieck ergeben
     * @param gleicherSchenkel die Länge der beiden gleichlangen Seiten
     * @param basis Länge der Basis
     * @return die Fläche
     */
    private static double flaeche(double gleicherSchenkel, double basis) {
        System.out.println("Anfang gleichschenkliges Dreieck");
        double erg = flaeche(gleicherSchenkel,gleicherSchenkel,basis);
    return erg;
    }
    /**
     * Berechnung der Fläche eines gleichseitig Deiecks
     * @param gleicheSeite Länge der Seite
     * @return die Fläche
     */
    private static double flaeche(double gleicheSeite) {
        System.out.println("Anfang gleichseitiges Dreieck");
    return flaeche(gleicheSeite,gleicheSeite);
    }
    /**
     * Berechnung der Fläche eines rechtwinkligen Dreiecks mit zwei Katheden
     * @param k1 Länge erste Kathede
     * @param k2 Länge zweite Kathede
     * @return Fläche
     */
    private static double flaecheKathedenDreieckeck(double k1, double k2){
    return flaeche(Math.sqrt(k1*k1+k2*k2),k1,k2);
    }
    /**
     * Berechnung der Fläche eines rechtwinkligen Dreiecks mit einer
     * Hypotenuse und einer Kathede
     * @param h Länge Hypothenuse
     * @param k Länge Kathede
     * @return die Fläche
     */
    private static double flaecheKathedeHypothenuseDreieck(double h, double k){
    return flaecheKathedenDreieckeck(k,Math.sqrt(h*h-k*k));
    }
    /**
      * Hauptprogrsam zum Testen
      * @param args keine Eingabeparameter
      */
    public static void main(String[] args) {
        double aa = 3.0d;
        double x = flaeche(aa,4D,5D);
        System.out.println(flaeche(aa,4D,5D));
        System.out.println(flaeche(5D,4D));
        System.out.println(flaeche(3D));
        System.out.println(flaecheKathedenDreieckeck(3D,4D));
        System.out.println(flaecheKathedeHypothenuseDreieck(5D,4D));
    }
}
