package s2.swing;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * 
 * @author s@scalingbits.com
 */
public class BoxLayoutTest {

public static void main(String[] args) {
        int wartezeit = 2000; // in Millisekunden
        JFrame f = new JFrame("BoxLayout");
        JPanel jp = new JPanel();
        
        // Erzeuge ein horizontales und ein vertikales BoxLayout
        BoxLayout horizontal = new BoxLayout(jp, BoxLayout.X_AXIS);
        BoxLayout vertikal = new BoxLayout(jp, BoxLayout.Y_AXIS);
        jp.setLayout(horizontal);
        for (char c = 0; c < 4; ++c) {

            jp.add(new JButton("Button " + (char) ('A' + c)));
        }
        JTextArea jta =new JTextArea(2,10);
        jta.append("JTextArea \nsecond row");
        jp.add(jta);
        f.add(jp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
  
        // Warte 2 Sekunden
        try {
            Thread.sleep(wartezeit);
            // Wechsle fünfmal die Orientierung alle zwei Sekunden
            for (int i = 0; i < 5; i++) {
                jp.setLayout(vertikal);
                f.setTitle("BoxLayout - Vertikal");
                f.pack();
                Thread.sleep(wartezeit);
                jp.setLayout(horizontal);
                f.setTitle("BoxLayout - Horizontal");
                f.pack();
                Thread.sleep(wartezeit);
            }
        } 
        catch (InterruptedException e) {
           // Mache nichts im Fall einer Ausnahme
        }
   }
}
