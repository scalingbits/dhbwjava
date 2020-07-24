/*
 * Eins Beispielprogramm welches von der Konsole liest und in eine Datei schreibt
 */
package s2.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author s@scalingbits.com
 */
public class SchreibInDateiLoesung {
    /**
     * Hauptprogamm
     * @param args wird nicht verwendet...
     */
    public static void main(String[] args) {
        try {
            String f = "scalingbits.txt";
            File datei = new File(f);
            Reader rein = new InputStreamReader(System.in);
            Writer raus = new FileWriter(datei);
            System.out.println("Der Text der jetzt eingegeben wird, wird in " +
                    "der Datei " + f + " gespeichert");
            System.out.println("Abschliessen mit Strg-Z oder Ctrl-Z");
            System.out.println("Abschliessen auf Unix/Linux mit Ctrl-D");
            System.out.println("Abschliessen auf Mac mit IntelliJ mit Cmd-D");
            umkopieren(rein,raus);
            raus.close();

            rein = new FileReader(f);
            raus = new OutputStreamWriter(System.out);

            System.out.println("Ausgabe des in Datei " + f 
                    + " gespeichertem Texts");
            umkopieren(rein,raus);
        } catch (IOException ex) {
            System.out.println("Probleme im IO Subsystem. Scotty beam me up");
        } 
        
    }
    /**
     * Umkopieren zwischen zwei Streams
     * @param r Eingabestream
     * @param w Ausgabestream
     * @throws IOException Probleme mit der  Ein/Ausgabe
     */
    public static void umkopieren(Reader r, Writer w) throws IOException{
        int c;
        while ((c= r.read()) != -1 ) {
            w.write(c);
        }
        r.close();
        w.close();
    } 
}
