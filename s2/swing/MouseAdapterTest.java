package s2.swing;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author s@scalingbits.com
 */
public class MouseAdapterTest extends MouseAdapter {

    public MouseAdapterTest() {
        erzeugeGUI();
   }

    /**
     * Hier geht es los! Das Hauptprogramm
     * @param args die EIngabeparamter werden ignoriert
     */
    public static void main(String[] args) {
        MouseAdapterTest mat = new MouseAdapterTest();
   }

    private void erzeugeGUI() {
        JFrame myJFrame = new JFrame("Mouse Click Adapter Test");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
        jb.addMouseListener(this);
        myJFrame.getContentPane().add(jb);
        myJFrame.pack();
        myJFrame.setVisible(true);
   }
   
   @Override
   public void mouseClicked(MouseEvent mEvent) {
        System.out.println("MouseClick wurde auf Position ["
                + mEvent.getX() + ","
                + mEvent.getY() + "] "
                + mEvent.getClickCount() + " mal geklickt");
    }
}
