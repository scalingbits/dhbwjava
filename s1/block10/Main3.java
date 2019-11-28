package s1.block10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    public static void main(String[] args) {
        String eingabe = "";
        eingabe = StringLesen1();
        System.out.println(eingabe);
        try {
            eingabe = StringLesen2();
        } catch (IOException e) {
            eingabe = " KEINE EINGABE BEI ZWEITEM AUFRUF;";
        }
        System.out.println(eingabe);
    }

    public static String StringLesen1() {
        String input = "Konsoleneingabe(1): ";
        // liest einen vom Benutzer eingegebenen Text (String) ein
        BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            input = input + keyboard.readLine() + ";";
        } catch (IOException e) {
            input = input + " KEINE EINGABE;";
        }
        return input;
    }

    public static String StringLesen2() throws IOException{
        String input = "Konsoleneingabe(2): ";
        // liest einen vom Benutzer eingegebenen Text (String) ein
        BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));
        input = input + keyboard.readLine() + ";";
        return input;
    }
}