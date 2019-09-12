package s1.block2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Kubikwurzel extends JApplet {

    private static boolean appletMode = true;
    private int versuche = 0;
    private int richtig = 0;
    private int falsch = 0;
    private int wurzel = 0;
    private int potenz = 0;
    private JTextField eingabeFeld;
    private String statusText;
    private JLabel status;
    private JLabel challenge;

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int eing = 0;
            boolean ergebnis = true;
            try {
                eing = Integer.decode(eingabeFeld.getText());
            } catch (NumberFormatException n) {
                ergebnis = false;
            }
            ergebnis = (eing == wurzel);
            versuche++;
            if (ergebnis) {
                eingabeFeld.setBackground(Color.green);
                richtig ++;
            }
                     else {
                eingabeFeld.setBackground(Color.red);
                falsch++;
            }
            statusText = (ergebnis?"Richtig! ":"Falsch! ") +
                    versuche + " Versuche, " +
                    richtig + " richtig, " +
                    falsch + " falsch";
            status.setText(statusText);
            status.setBackground(Color.RED);
            neueWurzel();
            challenge.setText("Kubikwurzel von " + potenz +" ?");
            eingabeFeld.setText("");
        }
}

    /**
     * Der Konstruktor ohne Argumente wird nur beim einem Start als Applet
     * benutzt. Hier wird ein Applet mit einem Grid erzeugt.
     */
    public Kubikwurzel() {
        neueWurzel();
        JFrame f = null;
        Container co;
        JPanel meinPanel = new JPanel();
        meinPanel.setLayout(new BorderLayout());

        MyListener ml = new MyListener();

        eingabeFeld = new JTextField(4);
        eingabeFeld.setBackground(Color.white);
        eingabeFeld.addActionListener(ml);
        challenge = new JLabel("Kubikwurzel von " + potenz +" ?");
        JButton enter = new JButton("Enter");
        enter.addActionListener(ml);
        status = new JLabel("0 Versuche. 0 richtig. 0 falsch");
        status.setBackground(Color.pink);
        meinPanel.add(challenge,BorderLayout.WEST);
        meinPanel.add(eingabeFeld,BorderLayout.CENTER);
        meinPanel.add(enter,BorderLayout.EAST);
        meinPanel.add(status,BorderLayout.SOUTH);

        if (!appletMode) {
            f = new JFrame("Kubikwurzel");
            co = f;
        } else {
            co = this;
        }
        co.add(meinPanel);

        if (!appletMode) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }
    }

    /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args
     */
    public static void main(String[] args) {
        appletMode = false;
        Kubikwurzel k = new Kubikwurzel();
    }

    public final void neueWurzel() {
        wurzel = (int)(Math.random()*100D);
        potenz = wurzel * wurzel * wurzel;
    }
}
