/*
 * Eins Beispielprogramm welches von der Konsole liest und in eine Datei schreibt
 */
package s2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author s@scalingbits.com
 */
public class SchreibInDateiGepuffered {
    /**
     * Hauptprogamm
     * @param args wird nicht verwendet...
     */
    public static void main(String[] args) {
        try {
            String f = "scalingbits.txt";
            File datei = new File(f);
            BufferedReader rein = new BufferedReader(
                    new InputStreamReader(System.in));
            BufferedWriter raus = new BufferedWriter(
                    new FileWriter(datei));
            System.out.println("Der Text der jetzt eingegeben wird, wird in " +
                    "der Datei " + f + " gespeichert");
            System.out.println("Abschliesen mit Strg-Z oder Ctrl-Z");
            System.out.println("Abschliesen Auf Unix/Linux mit Ctrl-D");
            umkopieren(rein,raus);
          
            rein = new BufferedReader(
                    new FileReader(f));
            raus = new BufferedWriter(
                    new OutputStreamWriter(System.out));
            
            System.out.println("Ausgabe des in Datei " + f 
                    + "gespeichertem Texts");
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
    public static void umkopieren(BufferedReader r, BufferedWriter w) throws IOException{
        String z;
        while ((z= r.readLine()) != null) {
            w.write(z);
            w.newLine();
        }
        r.close();
        w.close();
    } 
}