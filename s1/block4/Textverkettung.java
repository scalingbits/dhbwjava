package s1.block4;
public class Textverkettung {
    public static void main(String[] args) {
        System.out.println(textverkettung("Sonnenschein", 3));
        System.out.println(textverkettung("Sonnenschein", 0));
        
        String result;
        String text1 = "Mustertext";
        result= textverkettung("PingPong", 2);
        System.out.println("Ergebnis: " + result);

        result= textverkettung(text1, 3);
        System.out.println("Ergebnis: " + result);
        testTextRahmen();
    }
    private static String textverkettung(String text, final int anzahl) {
        String s="";
        if (anzahl < 1) {
            return "Gewählte Anzahl ist zu klein";
        } else {
            for (int i = 0; i < anzahl; i++) {
                s = s + text;
            }
            return s;
        }
    } 
    private static String textRahmen(String s) {
        return "<< " + s + " >>";
    }
    
    public static void testTextRahmen() {
        String s = "Inhalt";
        String result = textRahmen(textverkettung(s,2));
        System.out.println(result);
    }
}
