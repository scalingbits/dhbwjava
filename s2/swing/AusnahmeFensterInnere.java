package s2.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
 
/**
 *
 * @author s@scalingbits.com
 */ 
public class AusnahmeFensterInnere {
    private final JFrame hf;
    private final JButton okButton;
    private final JButton exitButton;
    private final Exception myException;
 
    public class SystemExitAction implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
        System.out.println(hf);
    }
 
}
    /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     * @param fehlermeldung ein beliebiger Fehlertext der angezeigt wird
     * @param e Die Ausnahme die angezeigt werden soll
     */
    public AusnahmeFensterInnere(String fehlermeldung, Exception e) {
                JLabel logo;
        JPanel buttonPanel;
        myException = e;
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
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myException.printStackTrace();
            }
            });
        exitButton.addActionListener(new SystemExitAction());
        // 6. Aufbau des Panels
        buttonPanel = new JPanel(new GridLayout(1, 0));
        buttonPanel.add(exitButton);
        buttonPanel.add(okButton);
 
        JTextArea fehlertextArea = new JTextArea(2, 20);
        fehlertextArea.append(fehlermeldung + "\n");
        fehlertextArea.append("Exception: "+ myException);
        // 7. Aubau des ContentPanes
        Container myPane = hf.getContentPane();
        myPane.add(logo, BorderLayout.NORTH);
        myPane.add(fehlertextArea, BorderLayout.CENTER);
        myPane.add(buttonPanel, BorderLayout.SOUTH);
        JMenuItem jmi = new JMenuItem("Beenden");
        jmi.addActionListener(new SystemExitListener());
        JMenu jm = new JMenu("Ablage");
        jm.add(jmi);
        JMenuBar jmb = new JMenuBar();
        jmb.add(jm);
        hf.setJMenuBar(jmb);
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
        String myURL =
                "https://upload.wikimedia.org/wikipedia/commons/0/01/DHBW_MA_Logo.jpg";
 
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
     * @param e Parameter wie von Schnittstelle gefordert
     */
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
     * Hauptporgramm zum Testen des Ausnahmefensters
     * @param args keine Eingaben
     */
    public static void main(String[] args) {
        AusnahmeFensterInnere dasFenster;
 
        try {myTestMethod();}
        catch (Exception e) {
            dasFenster = new AusnahmeFensterInnere("Hier läuft etwas schief",e);
            }
 
    }
 
    /**
     * Eine Testmethode die eine durch eine Division durch Null eine
     * Ausnahme provoziert
     */
    public static void myTestMethod()  {
 
        int a = 5;
        int b = 4+1;
        int c = 10;
        c = c / (a-5);
        System.out.println("Programm regulär beendet");
    }
}
