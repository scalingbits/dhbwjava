package s2.swing.ausnahmeFensterStory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;

/**
 *
 * @author s@scalingbits.com
 */
public class AusnahmeFenster2 {
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
    public AusnahmeFenster2(String fehlermeldung, Exception e) {
/*
     Die Story:
     Kurze Orientierung:
     Eine Variable logo die einen Zeiger auf ein Bild enthalten wird
     Ein buttonPanel, das wird später verwendet
     Ein Zeiger auf die Ausnahme. Sie enthält die Details der Ausnahme

     1. Wir kommentieren die Ausgabe aus.
         hf bedeutet Haupt Fenster
     2. Wir Erzeugen ein JFrame mit einem netten Titel in der Fensterleiste
         hf = new JFrame("Anwendungsfehler");
    Jetzt muss noch Infrastrukturarbeit gemacht werden!
    3. Am Ende des Bauens des GUI muss es sichtbar gemacht werden.
        Wir wollen den Zeitpunkt des Erscheinens kontrollieren.
       hf.setVisible(true);
    4. Vor dem Erscheinen muss das Laufzeitsystem die minimale Größe des
        GUIs berechnen. Wir packen es. D.H. wir schnüren eine Art Gummi um es herum
        hf.pack();
    5. Wir lassen das Programm laufen. Ein leeres Fenster erscheint.
         * Es ist sehr klein (schlecht). Man kann es aber groß ziehen!
         * Vorsicht: Das Löschen des Fensters beendet nicht das Programm!
    6. Mit dem folgenden Befehl setzen wir eine Minimalgröße:
       Suche nach Punkt 3
       hf.setSize(350, 300);
       Testen...
    6. Mit dem folgenden Befehl bleibt ein JFrame immer oben.
       hf.setAlwaysOnTop(true);
       Testen ...
    7. Wir wollen, dass das Program beim Schliesen des Fensters beendet wird
        Suche nach Punkt 4.
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Testen....
 */
        JLabel logo;
        JPanel buttonPanel;
        myException = e;

        // 1. Erzeugen einer neuen Instanz eines Swingfensters
        //System.out.println("Hier beginnt die Arbeit: Löschen Sie dieses Kommando");
        // ...
        hf = new JFrame("Anwendungsfehler");
        // 3. Gewünschte Größe setzen
        // 1. Parameter: horizontale Größe in Pixel: 220
        // 2. Parameter: vertikale Größe: 230
        // ...
        // 8. Labelerzeugung
        logo = meinLogo();
        // 4. Nicht Beenden bei Schliessen des Fenster
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        hf.pack();
        // 3. Gewünschte Größe setzen
        //     1. Parameter: horizontale Größe in Pixel
        //     2. Parameter: vertikale Größe
        hf.setSize(350, 300);
        // 2.2 Sichtbar machen des JFrames. Immer im Vordergrund
        hf.setVisible(true);
        hf.setAlwaysOnTop(true);
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
        AusnahmeFenster2 dasFenster;
        try {
            myTestMethod();
        } catch (Exception e) {
            dasFenster = new AusnahmeFenster2("Hier läuft etwas schief", e);
        }
     }
     /**
     * Eine Testmethode die mit einer Division durch Null eine
     * Ausnahme provoziert
     */

    public static void myTestMethod() {
        int a = 5;
        int b = 4+1;
        int c = 10;
        c = c / (a - b);
        System.out.println("Programm regulär beendet");
    }
}
