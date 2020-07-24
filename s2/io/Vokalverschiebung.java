package s2.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author s@scalingbits.com
 */
public class Vokalverschiebung {
    /**
     * Hauptprogamm
     * @param args enthält optional zuerst Pfad zur Engabedatei, und zur Ausgabedatei
     */
    public static void main(String[] args) {
        String fe = "scalingbitsRein.txt";
        String fa = "scalingbitsRaus.txt";
        if (args.length >= 2) {
            fe = args[0];
            fa = args[1];
        }
        try { 
            schieben(new FileReader(new File(fe)),
                       new FileWriter(new File(fa)));
        } catch (IOException ex) {

            System.out.println("Probleme im IO Subsystem. Scotty beam me up...");
            System.out.println(ex.getMessage());
        } 
        
    }
    /**
     * Vokalverschieben zwischen zwei Streams
     * @param r Eingabestream
     * @param w Ausgabestream
     * @throws IOException Probleme mit Ein/Ausgabe
     */
    public static void schieben(Reader r, Writer w) throws IOException{
        int c;
        while ((c= r.read()) != -1 ) {
            switch ((char) c) {
                case 'a' : c = 'e'; break;
                case 'A' : c = 'E'; break;
                case 'e' : c = 'i'; break;
                case 'E' : c = 'I'; break;
                case 'i' : c = 'o'; break;
                case 'I' : c = 'O'; break;
                case 'o' : c = 'u'; break;
                case 'O' : c = 'U'; break;
                case 'u' : c = 'a'; break;
                case 'U' : c = 'A'; break;
            }
            w.write(c);
        }
        r.close();
        w.close();
    }
}