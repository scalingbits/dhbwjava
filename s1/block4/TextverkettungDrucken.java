package s1.block4;
public class TextverkettungDrucken {
    public static void main(String[] args) {
        textverkettungDrucken("Sonnenschein", 3);
        textverkettungDrucken("Sonnenschein", 0);
    }
    private static void textverkettungDrucken(String text, final int anzahl) {
        String s= "";
        if (anzahl >0)
            for (int i = 0; i < anzahl; i++)
                s = s + text;
        System.out.println("Ergebnis: " + s);
    }   
}
