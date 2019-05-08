package s2.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author s@scalingbits.com
 */  
public class TextfieldJApplet extends JApplet implements ActionListener {
 
    final private JTextField myTextField;
    static boolean appletContext = true;
    JFrame f;

   public TextfieldJApplet() {
        Container myPane;
        if (appletContext) {
            myPane = getContentPane();
        }
        else { // 
            f= new JFrame("Master");
            myPane = f.getContentPane();
        }
 
        myTextField = new JTextField("Editier mich. Ich bin ein JTextfield", 60);
        myTextField.addActionListener(this);

   myPane.add(myTextField);
        if (!appletContext) {
            f.pack();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String eingabe = myTextField.getText();
        StringBuffer st = new StringBuffer(eingabe.length());
        for (int i = (eingabe.length()-1); i>=0;i--) 
            st.append(eingabe.charAt(i));
        myTextField.setText(st.toString());
    }
}