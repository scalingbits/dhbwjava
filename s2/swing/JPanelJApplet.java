package s2.swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author s@scalingbits.com
 */
public class JPanelJApplet extends JApplet implements ActionListener {
  final private JTextField myTextField;

  public JPanelJApplet() {
    myTextField =
        new JTextField("Editier mich. Ich bin ein JTextfield", 25);
    myTextField.addActionListener(this);

    JButton myButton = new JButton("Click mich");
    myButton.addActionListener(this);
     
   JLabel myLabel = new JLabel("Ich bin ein JLabel");

   JPanel myPanel = new JPanel();
      myPanel.add(myButton, BorderLayout.NORTH);
      myPanel.add(myTextField, BorderLayout.CENTER);
      myPanel.add(myLabel, BorderLayout.SOUTH);

      Container myPane = getContentPane();
     myPane.add(myPanel);
  }
@Override
public void actionPerformed(ActionEvent e) {
        String eingabe = myTextField.getText();
        StringBuffer st = new StringBuffer(eingabe.length());
        for (int i = (eingabe.length() - 1); i >= 0; i--) 
            st.append(eingabe.charAt(i));
        myTextField.setText(st.toString());
    }
}
