package s1.block4;

public class Flugzeug {
    public void drucken () {
        //...
    }
    public static void main(String[] args) {
        Flugzeug f = new Flugzeug();
        f.drucken();
        f.kennzeichenAusgeben();
        eigenschaft();
        Flugzeug.eigenschaft();
        double pi = Math.sqrt(2.0);
    }
    public void kennzeichenAusgeben() {
        drucken();
    }
    public static void eigenschaft() {
        System.out.println("kann fliegen");
    }
}
