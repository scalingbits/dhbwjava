package s2.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Zeigt einen sehr einfachen FlowlayoutManager mit 5 Buttons
 * @author s@scalingbits.com
 */
public class FlowlayoutTest {

    /**
     * Hauptmethode
     * @param args Es werden keine Parameter ausgewertet
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout");
        JPanel jp = new JPanel();
        for (char c = 0; c <= 5; ++c) { // Stecke 6 Buttons in das Panel
            jp.add(new JButton("Button " + (char)('A'+c)));
        }
        f.add(jp); // Füge Panel zu Frame
        //Beende Anwendung beim Schliesen des Fensters
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); // Berechne Layout
        f.setVisible(true);// Zeige alles an
    }
}
