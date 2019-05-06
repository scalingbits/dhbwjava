package s2.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author s@scalingbits.com
 */
public class MouseAdapterAnonymeInnereKlasseTest {
    /**
    * Erzeuge GUI im Konstruktor
    */
    public MouseAdapterAnonymeInnereKlasseTest() {
        JFrame myJFrame = new JFrame("Mouse Click Adapter Test");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mEvent) {
                System.out.println("MouseClick wurde auf Position ["
                        + mEvent.getX() + ","
                        + mEvent.getY() + "] "
                        + mEvent.getClickCount() + " mal geklickt");
            }
        });
        myJFrame.getContentPane().add(jb);
        myJFrame.pack();
        myJFrame.setVisible(true);
    }
    public static void main(String[] args) {
        MouseAdapterAnonymeInnereKlasseTest mat =
                new MouseAdapterAnonymeInnereKlasseTest();
    }
}
