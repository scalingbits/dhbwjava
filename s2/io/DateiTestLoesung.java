package s2.io;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author s@scalingbits.com
 */
public class DateiTestLoesung {
    /**
     * Hauptprogamm
     * @param args wird nicht verwendet...
     */
    public static void main(String[] args) {
        String d ="testDir";
        String f1 = "datei1.txt";
        String f2 = "datei2.txt";
        File dir  = new File(d);
        File file1  = new File(d + "/" + f1);
        File file2  = new File(d + "/" + f2);
        
        if (dir.exists())
            System.out.println("Verzeichnis " +  d + " existiert bereits");
        
        dir.mkdir();
        try {
            file1.createNewFile();
            System.out.println("Datei wurde angelegt in : " 
                    + file1.getAbsolutePath() );
            file2.createNewFile();
            System.out.println("Datei wurde angelegt in : " 
                    + file1.getAbsolutePath() );
            
            System.out.println("Dateien im Verzeichnis " 
                    + dir.getAbsolutePath());
            String[] alleDateien = dir.list();
            for ( String  f : alleDateien)
                System.out.println("* " + f);
            
            System.out.println("*** Loeschen der Dateien ***");
            boolean result;
            result = file1.delete();
            result = dir.delete();
            System.out.println("Warum kann das Verzeichnis nicht geloescht werden?");
            if (result) System.out.println("Verzeichnis " + d + " geloescht");
            else System.out.println("Verzeichnis " + d + " nicht geloescht");
            if (result) System.out.println("Datei " + f1 + " geloescht");
            else System.out.println("Datei " + f1 + " nicht geloescht");
            result = file2.delete();
            if (result) System.out.println("Datei " + f2 + " geloescht");
            else System.out.println("Datei " + f2 + " nicht geloescht");
            result = dir.delete();
            if (result) System.out.println("Verzeichnis " + d + " geloescht");
            else System.out.println("Verzeichnis " + d + " nicht geloescht");
        } catch (IOException ex) {
            System.out.println("Probleme im IO Subsystem...");
        }

    }
}
