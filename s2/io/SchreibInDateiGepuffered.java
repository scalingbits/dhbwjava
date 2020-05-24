/*
 * Eins Beispielprogramm welches von der Konsole liest und in eine Datei schreibt
 */
package s2.io;

import java.io.*;

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
            System.out.println("Abschliessen mit Strg-Z oder Ctrl-Z");
            System.out.println("Abschliessen auf Unix/Linux mit Ctrl-D");
            System.out.println("Abschliessen auf Mac mit IntelliJ mit Cmd-D");
            umkopieren(rein,raus);
          
            rein = new BufferedReader(
                    new FileReader(f));
            raus = new BufferedWriter(
                    new OutputStreamWriter(System.out));
            
            System.out.println("Ausgabe des in Datei " + f 
                    + "gespeichertem Texts");
            umkopieren(rein,raus);
            raus.close();
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
