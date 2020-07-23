package s1.block11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author s@scalingbits.com
 */
public class Serialisierung {
    /**
     * Erzeuge eine Person und die Adresse. Schreibe sie in eine
     * Datei und lese sie aus der Datei
     * @param args Kommandozeilenparameter (hier nicht benoetigt)
     */
    public static void main(String[] args) {
        final String meineDatei = "serialisiert.ser";
        // Erzeuge das Objekt der Person und das Objekt mit der Adresse
        Person p = new Person("Urmel", new Adresse("Lummerland"));
        System.out.println("Zu schreibende Person " + p.name +
                " wohnt in " + p.wohnort.stadt);
        // Schreibe die Objekte in eine Datei
        schreiben(p, meineDatei);
        Person p1 = (Person) lesen(meineDatei);
        System.out.println("Gelesene Person " + p1.name +
                " wohnt in " + p1.wohnort.stadt);
        System.out.println("Die geschrieben Adresse und die gelesene"+
                " Adresse " + p.wohnort.stadt + " sind" +
                (p.wohnort==p1.wohnort? " " : " nicht ") +
                "identisch");
    }
    /**
     * Diese Methode schreibt ein beliebiges serialisierbares Objekt
     * in eine Datei
     * @param o Objekt welches in eine Datei geschrieben wird.
     *           Es muss serialisierbar sein!
     * @param datei Die Datei in die geschrieben werden soll
     */
    public static void schreiben(Object o, String datei) {
        try {
            // Erzeuge einen Stream der in eine Datei geleitet wird
            FileOutputStream fileOut = new FileOutputStream(datei);
            // Erzeuge einen Strem der Objekte in einen Filestrem leitet
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Schreibe ein beliebiges Objekt in diesen Objectstream
            out.writeObject(o);
            // Schliesse Stream
            out.close();
            // Schliesse Dateistream. Die letzten Bytes werden so raus geschrieben
            fileOut.close();
            System.out.println("Serialisierte Daten sind gespeichert in Datei "
                    + datei);
        } catch (IOException i) { // Hier können Ausnahmen auftreten
            i.printStackTrace();
        }
    }
    /**
     *
     * @param datei die Datei aus der gelesen werden soll
     * @return das gelesene Objekt
     */
    public static Object lesen(String datei) {
        System.out.println("Lesen aus " + datei);
        Object o;
        try { // Hier können Ausnahmen Auftreten
            // Öffne Datei aus der gelesen werden soll
            FileInputStream fileIn = new FileInputStream(datei);
            // Erzeuge Objectstream der aus Datei liest
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //Lies Objekt aus Stream
            o = in.readObject();
            // Schließe Objectstream
            in.close();
            // Schließe Datei
            fileIn.close();
        } catch (IOException i) { // Wird ausgeführt wenn Probleme auftreten
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Gelesene Klasse nicht gefunden");
            c.printStackTrace();
            return null;
        }
        return o;
    }

}
