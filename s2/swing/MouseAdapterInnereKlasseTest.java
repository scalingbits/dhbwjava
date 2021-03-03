package s2.swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author s@scalingbits.com
 */
public class MouseAdapterInnereKlasseTest {
    /**
     * Die innere Klasses MyMouseListener
     */
    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mEvent) {
            System.out.println("MouseClick wurde auf Position ["
                    + mEvent.getX() + ","
                    + mEvent.getY() + "] "
                    + mEvent.getClickCount() + " mal geklickt");
        }
    }
   /**
    * Erzeuge GUI im Konstruktor
    */
    public MouseAdapterInnereKlasseTest() {
        JFrame myJFrame = new JFrame("Mouse Click Innere Klasse Test");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
        jb.addMouseListener(new MyMouseListener());
        myJFrame.getContentPane().add(jb);
        myJFrame.pack();
        myJFrame.setVisible(true);
    }

    /**
     * Das Hauptprogramm
     * @param args die Parameterliste wird ignoriert
     */
    public static void main(String[] args) {
        MouseAdapterInnereKlasseTest mat =
                new MouseAdapterInnereKlasseTest();
    }
}
