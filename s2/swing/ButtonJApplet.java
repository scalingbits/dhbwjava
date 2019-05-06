package s2.swing;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;

/**
 *
 * @author s@scalingbits.com
 */
public class ButtonJApplet extends JApplet implements ActionListener {

final private JButton myButton;
    /**
     * zaehlt Tastendrücke
     */
    private int zaehler=0;

public ButtonJApplet() {
        myButton = new JButton();
        myButton.setText("Click mich");
        myButton.addActionListener(this);

Container myPane = getContentPane();
        myPane.add(myButton);
    }

public void actionPerformed(ActionEvent e) {
        myButton.setText("Kicher (" + ++zaehler + ")");
    }
}