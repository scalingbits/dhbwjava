package s2.swing.ausnahmeFensterStory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 *
 * @author s@scalingbits.com
 */
public class AusnahmeFenster8 implements ActionListener {
    private final JFrame hf;
    private final JButton okButton;
    private final JButton exitButton;
    private final Exception myException;

    /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     * @param fehlermeldung ein beliebiger Fehlertext der angezeigt wird
     * @param e             Die Ausnahme die angezeigt werden soll
     */
    public AusnahmeFenster8(String fehlermeldung, Exception e) {
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
        okButton.addActionListener(this);
        exitButton.addActionListener(this);

        // 6. Aufbau des Panels
        JTextArea fehlertextArea = new JTextArea(2, 20);
        fehlertextArea.append(fehlermeldung + "\n");
        fehlertextArea.append("Exception: " + myException);
        // 7. Aubau des ContentPanes
        Container myPane = hf.getContentPane();
        myPane.setLayout(new BorderLayout());
        myPane.add(logo, BorderLayout.NORTH);
        myPane.add(fehlertextArea, BorderLayout.CENTER);
        myPane.add(buttonPanel, BorderLayout.SOUTH);

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
     *
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
     *
     * @param e ActionEvent eines Ereignisses, wie gefordert von Schnittstelle
     */
    public void actionPerformed(ActionEvent e) {
        JButton meinButton = (JButton) e.getSource();
        if (meinButton == exitButton)
            System.exit(0);
        else {
          System.out.println("OK Button clicked");
          myException.printStackTrace();
        }
        /*
        Die Story: Code siehe oben
        Wir können auch mit einem ActionListener unterschiedliche Dinge tun:
        1. Wir holen uns vom ActionEvent e das beteiligt graphische Object
        2. Wir vergleichen es Klassenvariablen
        3. Testen: Vorsicht die Reihenfolge ist wichtig
            * 2 mal auf Stacktrace klicken
            * dann auf Beenden klicken. Das Programm beendet sich
         */
    }
    /**
     * Hauptprogramm zum Testen des Ausnahmefensters
     * @param args keine Eingaben
     */
    public static void main(String[] args) {
        AusnahmeFenster8 dasFenster;
        try {
            myTestMethod();
        } catch (Exception e) {
            dasFenster = new AusnahmeFenster8("Hier läuft etwas schief", e);
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
