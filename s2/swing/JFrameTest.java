package s2.swing;
import javax.swing.JFrame;
/**
 * @author stsch
 */
public class JFrameTest {
    /**
     * Dieses Hauptprogramm erzeugt ein JFrame
     * @param args die Parameterliste wird ignoriert
     */
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Einfaches Fenster");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Beende Anwendung bei Schließen des Fensters
        myFrame.setSize(300,100); // Fenstergroesse 300x100 Pixel
        myFrame.setVisible(true); // Mache Fenster sichtbar
    }
}