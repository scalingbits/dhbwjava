/*
 * Ein Beispielprogramm welches von der Konsole liest und in eine Datei schreibt
 */
package s2.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author s@scalingbits.com
 */
public class SchreibInDatei {
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
            System.out.println("Abschliesen mit Strg-Z oder Ctrl-Z");
            System.out.println("Abschliesen Auf Unix/Linux mit Ctrl-D");
            umkopieren(rein,raus);
        } catch (IOException ex) {
            System.out.println("Probleme im IO Subsystem. Scotty beam me up");
        } 
        
    }
    /**
     * Umkopieren zwischen zwei Streams
     * @param r Eingabestream
     * @param w Ausgabestream
     * @throws IOException 
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