package s2.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author s@scalingbits.com
 */
public class ActionListenerBlockiert implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Ausgabe des zum ActionEvent gehörenden Kontexts
        System.out.println("Aktion: " + ae.getActionCommand());
        try {// Thread für 2s blockieren (schlafen)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame myJFrame = new JFrame("Einfacher ActionListener");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
        ActionListenerBlockiert behandeln = new ActionListenerBlockiert();
        jb.addActionListener(behandeln); // Füge Listener zu Button
        myJFrame.add(jb); // Füge Button zu Frame
        myJFrame.pack(); // Berechne Layout
        myJFrame.setVisible(true);
    }
}