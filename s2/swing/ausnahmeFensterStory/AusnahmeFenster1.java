package s2.swing.ausnahmeFensterStory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;

/**
 *
 * @author s@scalingbits.com
 */
public class AusnahmeFenster1 {
    private final JFrame hf;
    private final JButton okButton;
    private final JButton exitButton;
    private final Exception myException;
     /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     * @param fehlermeldung ein beliebiger Fehlertext der angezeigt wird
     * @param e Die Ausnahme die angezeigt werden soll
     */
    public AusnahmeFenster1(String fehlermeldung, Exception e) {
        JLabel logo;
        JPanel buttonPanel;
        myException = e;
        // 1. Erzeugen einer neuen Instanz eines Swingfensters
        System.out.println("Hier beginnt die Arbeit: Löschen Sie dieses Kommando");
        // ...
        hf = null;
        // 3. Gewünschte Größe setzen
        // 1. Parameter: horizontale Größe in Pixel: 220
        // 2. Parameter: vertikale Größe: 230
        // ...
        // 8. Labelerzeugung
        logo = meinLogo();
        // 4. Nicht Beenden bei Schliessen des Fenster
        // 5. Anlegen der Buttons
        okButton = null;
        exitButton= null;
        // 10. Hinzügen der Eventbehandlung
        //  Tipp: Die Klasse muss noch das Interface ActionListener implementieren!
        // ...
        // 6. Aufbau des Panels
        //        ...
        // 7. Aubau des ContentPanes
        //         ...
        // 2.1 Das Layout des JFrame berechnen.
        // ...
        // 3. Gewünschte Größe setzen
        //     1. Parameter: horizontale Größe in Pixel
        //     2. Parameter: vertikale Größe
        // ...
        // 2.2 Sichtbar machen des JFrames. Immer im Vordergrund
        // ...
        // ...
    }
    /**
     * Implementieren des Logos
     * 9.ter Schritt
     * @return Zeiger auf das Logoobjekt
     */
    private JLabel meinLogo() {
        URL logoURL;
        JLabel logoLabel;
        String myURL = "https://upload.wikimedia.org/wikipedia/commons/0/01/DHBW_MA_Logo.jpg";
        try {
            logoURL = new URL(myURL);
            ImageIcon myImage = new ImageIcon(logoURL);
            logoLabel = new JLabel(myImage);
        } catch (java.net.MalformedURLException e) {
            System.out.println(e);
            System.out.println("Logo URL kann nicht aufgelöst werden");
            logoLabel = new JLabel("Logo fehlt");
        }
        return logoLabel;
    }
    /**
     * Behandlung der JButton-Ereignisse
     * 11. ter Schritt
     * @param e ActionEvent eines Ereignisses, wie gefordert von Schnittstelle
     */
    public void actionPerformed(ActionEvent e) {
        //System.exit(0);
        //System.out.println("OK Button clicked");
        //myException.printStackTrace();
    }
    /**
     * Hauptprogramm zum Testen des Ausnahmefensters
     * @param args keine Eingaben
     */
    public static void main(String[] args) {
        AusnahmeFenster1 dasFenster;
        try {
            myTestMethod();
        } catch (Exception e) {
            dasFenster = new AusnahmeFenster1("Hier läuft etwas schief", e);
        }
     }
     /**
     * Eine Testmethode die mit einer Division durch Null eine
     * Ausnahme provoziert
     */

     /*
     Die Story:
     Ein einfaches Programm produziert eine Division durch  Null und wird normalerweise
     mit einem Stack Trace beendet.

     Wir wollen eine graphische Feldermeldung produzieren die dem Benutzer erklärt
     was falsch gelaufen ist und ihm die Möglichkeit den Stacktrace auf der Konsole
     zu drucken oder weiter zu machen.
     Ein Problem was immer wieder vorkommt.
     Man braucht Eingaben, Ausgaben, wir werden ein Bild anzeigen.
     Das ist ein modaler Dialog. Modale Dialoge sind besonders: Ein Programm wird
     erst weiterlaufen wenn der Dialog bearbeitet worden ist.
     Der Benutzer muss ihn sehen können, sonst wird er frustriert aufgeben!

     Am Anfang gibt es nur die Ausnahme. Sie ruft den Konstruktor der Klasse auf.
     Es geht im Konstruktor weiter.
      */
    public static void myTestMethod() {
        int a = 5;
        int b = 4+1;
        int c = 10;
        c = c / (a - b);
        System.out.println("Programm regulär beendet");
    }
}
