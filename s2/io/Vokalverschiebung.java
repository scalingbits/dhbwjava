package s2.io;

import java.io.*;

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
        // Diese Dateien haben keinen voll qualifizierten Pfad
        // Sie werden in dem Verzeichnis gelesen und geschrieben in dem die Anwendung
        // gestartet wird
        // Wird die Anwendung mit IntelliJ gestartet, so wird hier das Projektverzeichnis
        // von IntelliJ verwendet
        String fe = "scalingbitsRein.txt";
        String fa = "scalingbitsRaus.txt";
        // Ueberschreiben mit Kommandozeilenparameter falls sie existieren
        if (args.length >= 2) {
            fe = args[0];
            fa = args[1];
        }
        try {
            File dateirein = new File(fe);
            File dateiraus = new File(fa);
            System.out.println("Werde aus Datei " + dateirein.getAbsolutePath() + " lesen.");
            System.out.println("Werde in Datei " + dateiraus.getAbsolutePath() + " schreiben.");

            // Direktes Bearbeiten. Nicht gepuffert
            schieben(new FileReader(dateirein),
                       new FileWriter(dateiraus));
            // Gepuffertes Bearbeiten
            //schieben(new BufferedReader(new FileReader(dateirein)),
            //        new BufferedWriter(new FileWriter(dateiraus)));
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
        // Schliesen der Dateien
        r.close();
        w.close();
    }
}