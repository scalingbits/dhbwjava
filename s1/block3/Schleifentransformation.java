package s1.block3;
import java.io.IOException;

public class Schleifentransformation {
    public static void main(String[] args) {
        int s = 0;
        int x = 0;

        while(true) { //Option 1
            try {
                x = System.in.read(); //liest ein Zeichen von der Konsole
            } catch (IOException ex) {
                System.out.println(" Java IO Exception");
            }
            if (x < 0) break;
            s = s + x;
        }
        do { //OPtion 2
            try {
                x = System.in.read(); //liest ein Zeichen von der Konsole
            } catch (IOException ex) {
                System.out.println(" Java IO Exception");
            }
            if (x < 0) break;
            s = s + x;
        } while(true);
        }
}
