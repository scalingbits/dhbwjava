package s1.block1;
public class Flugzeug {
    String kennzeichen; // Ein Attribut vom Typ einer Zeichenkette
    int leerGewicht; // Ein Attribut vom Type einer Ganzzahl

    /**
     * Eine Methode zum Drucken der Attributbelegung des Objekts
     * Die Methode erfordert keine Eingaben. Sie erzeugt keine
     * Aufgaben
     */
    public void drucken() {
        System.out.println("Kennzeichen " + kennzeichen + " "
                + leerGewicht + "kg");
    }

    /**
     * Die Methode main() wir zum Starten des Programms benutzt
     * @param args Übergabe von Konsolenparameter. Hier nicht genutzt
     */
    public static void main(String[] args) {
        // Erzeugen zweier Objekte
        Flugzeug jumbo = new Flugzeug();
        Flugzeug a380 = new Flugzeug();
        // Belegen der Attribute des ersten Objekts mit Werten

        jumbo.kennzeichen = "D-ABYT";
        jumbo.leerGewicht = 191000;

        // Belegen der Attribute des zweiten Objekts mit Werten
        a380.kennzeichen = "D-AIMD";
        a380.leerGewicht = 286000;

        // Drucken der beiden Objekte auf der Konsole
        jumbo.drucken();
        a380.drucken();
    }
}