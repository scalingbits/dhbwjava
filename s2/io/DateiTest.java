package s2.io;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author s@scalingbits.com
 */
public class DateiTest {
    /**
     * Hauptprogamm
     * @param args wird nicht verwendet...
     */
    public static void main(String[] args) {
        String d ="testDir";
        String f1 = "datei1.txt";
        String f2 = "datei2.txt";
        File dir  = new File(d);
        File file1  = new File(d + File.separatorChar + f1);
        File file2  = new File(d + File.separatorChar + f2);
        
        if (dir.exists())
            System.out.println("Verzeichnis " +  d + " existiert bereits");
        else
            dir.mkdir();
        try {
            file1.createNewFile();
            System.out.println("Datei wurde angelegt in : " 
                    + file1.getAbsolutePath() );
            file2.createNewFile();
            System.out.println("Datei wurde angelegt in : " 
                    + file2.getAbsolutePath() );
            
            System.out.println("Dateien im Verzeichnis " 
                    + dir.getAbsolutePath());
            String[] alleDateien = dir.list();
            for ( String  f : alleDateien)
                System.out.println("* " + f);
        } catch (IOException ex) {
            System.out.println("Probleme im IO Subsystem...");
        }

    }
}
