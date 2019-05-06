package s2.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author s@scalingbits.com
 */
public class ActionListenerBeispiel implements ActionListener {

@Override
public void actionPerformed(ActionEvent ae) {
        //Ausgabe des zum ActionEvent gehörenden Kontexts
        System.out.println("Aktion: " + ae.getActionCommand());
    }

public static void main(String[] args) {
        JFrame myJFrame = new JFrame("Einfacher ActionListener");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
  
        ActionListenerBeispiel behandeln = new ActionListenerBeispiel();
        jb.addActionListener(behandeln); // Füge Listener zu Button
        myJFrame.add(jb); // Füge Button zu Frame
        myJFrame.pack();
        myJFrame.setVisible(true);
    }
}

