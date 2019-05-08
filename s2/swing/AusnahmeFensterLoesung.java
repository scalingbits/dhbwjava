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
public class AusnahmeFensterLoesung implements ActionListener {
    private JFrame hf;
    private JButton okButton;
    private JButton exitButton;
    final private Exception myException;
    /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     * @param fehlermeldung ein beliebiger Fehlertext der angezeigt wird
     * @param e Die Ausnahme die angezeigt werden soll
     */
    public AusnahmeFensterLoesung(String fehlermeldung, Exception e) {
        JLabel logo;
        JPanel buttonPanel;
        myException = e;
        hf=null;
        okButton=null;
        exitButton=null;
        // 1. Erzeugen einer neuen Instanz eines Swingfensters
        hf = new JFrame("Anwendungsfehler");
        // 8. Labelerzeugung
        logo = meinLogo();
        // 4. Beenden bei Schliesen des Fenster
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 5. Anlegen der Buttons
        okButton = new JButton();
        okButton.setText("Stack Trace");
        exitButton = new JButton();
        exitButton.setText("Beenden");
        // 10. Hinzügen der Eventbehandlung
        okButton.addActionListener(this);
        exitButton.addActionListener(this);
        // 6. Aufbau des Panels
        buttonPanel = new JPanel(new GridLayout(1, 0));
        buttonPanel.add(exitButton);
        buttonPanel.add(okButton);
 
        JTextArea fehlertextArea = new JTextArea(2, 20);
        fehlertextArea.append(fehlermeldung + "\n");
        fehlertextArea.append("Exception: "+ myException);
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
        String myURL = "http://www.dhbw-mannheim.de/fileadmin/templates/default/img/signet.gif";
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
     * Behandlung der JButton Ereignisse
     * 11. ter Schritt
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) (e.getSource());
        if (source == exitButton) {
            System.exit(0);
        }
        if (source == okButton) {
            System.out.println("OK Button clicked");
            myException.printStackTrace();
        }
   }
    /**
     * Hauptprogramm zum Testen des Ausnahmefensters
     * @param args keine Eingaben
     */
    public static void main(String[] args) {
        AusnahmeFensterLoesung dasFenster;
        try {myTestMethod();}
        catch (Exception e) {
            dasFenster = new AusnahmeFensterLoesung("Hier läuft etwas schief",e);
            }
    }
    /**
     * Eine Testmethode die eine durch eine Division durch Null eine
     * Ausnahme provoziert
     * @throws Exception
     */
    public static void myTestMethod() throws Exception {
        int a = 5;
        int b = 5;
        int c = 10;
        c = c / (a-b);
        System.out.println("Programm regulär beendet");
    }
}