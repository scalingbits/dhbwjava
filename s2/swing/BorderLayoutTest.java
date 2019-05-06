package s2.swing;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author s@scalingbits.com
 */
public class BorderLayoutTest {
 
    public static void main(String[] args) {
        JFrame f = new JFrame("BorderLayout");
        JPanel jp = new JPanel();
 
        jp.setLayout(new BorderLayout());
        jp.add(new JButton("Norden"),BorderLayout.NORTH);
        jp.add(new JButton("Westen"),BorderLayout.WEST);
        jp.add(new JButton("Osten"),BorderLayout.EAST);
        jp.add(new JButton("Süden"),BorderLayout.SOUTH);
        jp.add(new JButton("Center"),BorderLayout.CENTER);
        f.add(jp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}