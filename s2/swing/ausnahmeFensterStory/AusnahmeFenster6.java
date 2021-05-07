package s2.swing.ausnahmeFensterStory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

/**
 *
 * @author s@scalingbits.com
 */
public class AusnahmeFenster6 {
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
    public AusnahmeFenster6(String fehlermeldung, Exception e) {
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
        okButton = new JButton();
        okButton.setText("Stack Trace");
        //hf.add(okButton);
        exitButton = new JButton("Beenden");
        // hf.add(exitButton);
        // 6. Aufbau des Panels
        //buttonPanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 0));
        buttonPanel.add(exitButton);
        buttonPanel.add(okButton);
        //hf.add(buttonPanel);

        // 10. Hinzügen der Eventbehandlung
        //  Tipp: Die Klasse muss noch das Interface ActionListener implementieren!
        // ...


        // 6. Aufbau des Panels
        JTextArea fehlertextArea = new JTextArea(2, 20);
        fehlertextArea.append(fehlermeldung + "\n");
        fehlertextArea.append("Exception: "+ myException);
        // 7. Aubau des ContentPanes
        Container myPane = hf.getContentPane();
        myPane.setLayout(new BorderLayout());
        myPane.add(logo, BorderLayout.NORTH);
        myPane.add(fehlertextArea, BorderLayout.CENTER);
        myPane.add(buttonPanel, BorderLayout.SOUTH);

        /*
        Die Story:
        Wir wollen ein komplexeres GUI Bauen. Wir brauchen Platz für ein
        Texfeld und ein Bild (JLabel)
        Welchen LayoutManager nehmen wir? Bild aus der Musterlösung zeigen...
        Borderlayout!
            * Buttons im Süden
            * Textfeld in der Mitte
            * Bild im Norden
        1. Löschen der Zuordnung des JPanels zu JFrame
              //hf.add(buttonPanel);
        2. Wir brauchen das ContentPane
            Absprung zum Skript: Erklären der Ebenen eines JFrames. Diagramm benutzen
              Container myPane = hf.getContentPane();
       3. Setzen des Layouts als BorderLayout
              myPane.setLayout(new BorderLayout());
       4. Hinzufügen des ButtonPanels im Süden
                myPane.add(buttonPanel, BorderLayout.SOUTH);
          Testen: Warum sieht das so aus? Layout vom BorderPanel zeigen
       5. Logo hinzufügen
            myPane.add(logo, BorderLayout.NORTH);
            Erklärung
                * Siehe Punkt 8
                * logo is ein JLabel. Absprung zum Skript
                * JLabel sing langweilig. Sie sind passiv. Sie können einen Text
                    oder ein Bild enthalten
            Es kommt in die Mitte unseres BorderLayouts
            myPane.add(fehlertextArea, BorderLayout.CENTER);
            Zuordnung von web geladenem Bild zu JLabel geschieht in meinLogo()
            Code zeigen. Studenten ermutigen ihr eigenes Bild einzubinden.
            Ausnahme zeigen. Wird kein Bild gefunden, wird ein Text verwendet
            Ist zuviel Arbeit zum selbst implementieren. Methode einfach
            Testen
                * Größe verändern. Wie verändern sich die Komponenten?
       6. Einfügen eines Textfeldes
            Absprung in das Skript. JTextFeld erklären
            Code bei 6. einfügen, Inhalte erklären
            JTextArea fehlertextArea = new JTextArea(2, 20);
            fehlertextArea.append(fehlermeldung + "\n");
            fehlertextArea.append("Exception: "+ myException);

            Textfeld in das Borderlayout einklinken in 7.
            myPane.add(fehlertextArea, BorderLayout.CENTER);
       7. Macht die konstante GUI-Größe ein Problem?
                //hf.setSize(350, 300);
                Zeile löschen. Sie wird nicht mehr gebraucht.
                Man kann sie auch manuell anpassen
        Zustand: Wir haben jetzt ein GUI in dem
        * LayoutManager verwendet werden
        * Geschachtelte Layoutmanager
        * Verschiedene Komponenten
        * Verschiedene Container
        * Es fehlt: Reaktionen auf Benutzereingaben
        */

        // 2.1 Das Layout des JFrame berechnen.

        hf.pack();
        // 3. Gewünschte Größe setzen
        //     1. Parameter: horizontale Größe in Pixel
        //     2. Parameter: vertikale Größe
        //hf.setSize(350, 300);
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
        AusnahmeFenster6 dasFenster;
        try {
            myTestMethod();
        } catch (Exception e) {
            dasFenster = new AusnahmeFenster6("Hier läuft etwas schief", e);
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
