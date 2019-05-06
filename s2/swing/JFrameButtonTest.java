package s2.swing;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 
 * @author s@scalingbits.com
 */
public class JFrameButtonTest {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Einfaches Fenster");
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(new JButton("Click mich ich bin ein JButton!"));
        myFrame.setSize(300,100);
        myFrame.setVisible(true);
    }
}


