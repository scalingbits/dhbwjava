package s2.swing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author s@scalingbits.com
 */
public class ActionListenerBeispiel implements ActionListener {

@Override
/**
 * Diese Methode der Schnittstelle muss implementiert werden um Aktionen
 * auszufuehren
 * @param ae Informationen zur Aktion
 */
public void actionPerformed(ActionEvent ae) {
        //Ausgabe des zum ActionEvent gehörenden Kontexts
        System.out.println("Aktion: " + ae.getActionCommand());
    }

    /**
     * Das Hauptprogramm. Hier beginnt das Program
     * @param args dieser Parameter wird ignoriert.
     */
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

