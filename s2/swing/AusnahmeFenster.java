package s2.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author s@scalingbits.com
 */
public class AusnahmeFenster {
    private JFrame hf;
    private JButton okButton;
    private JButton exitButton;
    private Exception myException;
     /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     * @param fehlermeldung ein beliebiger Fehlertext der angezeigt wird
     * @param e Die Ausnahme die angezeigt werden soll
     */
    public AusnahmeFenster(String fehlermeldung, Exception e) {
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
        String myURL = "http://www.dhbw-mannheim.de/fileadmin/templates/default/img/DHBW_Header_Logo.gif";
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
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //System.exit(0);
        //System.out.println("OK Button clicked");
        //myException.printStackTrace();
    }
    /**
     * Hauptprogramm zum Testen des Ausnahmefensters
     * @throws Exception
     */
    public static void main(String[] args) {
        AusnahmeFenster dasFenster;
        try {
            myTestMethod();
        } catch (Exception e) {
            dasFenster = new AusnahmeFenster("Hier läuft etwas schief", e);
        }
     }
     /**
     * Eine Testmethode die mit einer Division durch Null eine
     * Ausnahme provoziert
     * @throws Exception
     */
    public static void myTestMethod() throws Exception {
        int a = 5;
        int b = 5;
        int c = 10;
        c = c / (a - b);
        System.out.println("Programm regulär beendet");
    }
}
