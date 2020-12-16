package s2.thread;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author s@scalingbits.com
 * 
 */
public class ThreadFenster {
    final private JFrame hf;
    private JButton okButton;
    final private JButton exitButton;
    final JTextField threadDisplay;
    private final static int SLEEPMIN = 1;
    private final static int SLEEPMAX = 2000;
    private final static int SLEEPINIT = 500;
    private final int threadCurrent = 10;
    final public ThreadingPanel tp;
    public boolean synchron = true;
    final JRadioButton syncButton;
    final JRadioButton nosyncButton;

public class exitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    /**
     * Aufbau des Fensters zur Ausnahmebehandlung
     *
     */
    public ThreadFenster() {
        JPanel buttonPanel;
        // Erzeugen einer neuen Instanz eines Swingfensters
        hf = new JFrame("Thread Monitor");
        //Nicht Beenden bei Schliesen des Fenster
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Anlegen der Buttons
        exitButton = new JButton("Beenden");
        JLabel threadsLabel = new JLabel("sleep(ms):");
        JSlider threadSlider = new JSlider
                (JSlider.HORIZONTAL, SLEEPMIN, SLEEPMAX, SLEEPINIT);
        threadDisplay = new JTextField();
        threadDisplay.setText(Integer.toString(threadCurrent));
        threadDisplay.setColumns(4);
        threadDisplay.setEditable(false);
        threadSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    MainTest.sleepPeriod = source.getValue();
                    threadDisplay.setText(Integer.toString(MainTest.sleepPeriod));
                }
            }
        });
        exitButton.addActionListener(new exitActionListener());
        syncButton = new JRadioButton("Synchronisiert");
        syncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    synchron= true;
                    System.out.println("Synchronisiert");
            }
         } );
        syncButton.setSelected(true);  
        nosyncButton = new JRadioButton(" Nicht Sync.");
        nosyncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    synchron= false;
                    System.out.println("Nicht synchronisiert");
            }
         } );
        ButtonGroup group = new ButtonGroup();
        group.add(syncButton);
        group.add(nosyncButton);
        JPanel syncPanel = new JPanel();
        BoxLayout bl = new BoxLayout(syncPanel, BoxLayout.Y_AXIS);
        syncPanel.setLayout(bl);
        syncPanel.add(syncButton);
        syncPanel.add(nosyncButton);
        //Aufbau des Panels
        buttonPanel = new JPanel();
        buttonPanel.add(threadsLabel);
        buttonPanel.add(threadSlider);
        buttonPanel.add(threadDisplay);
        buttonPanel.add(syncPanel);
        buttonPanel.add(exitButton);
        tp = new ThreadingPanel();
        // Aubau des ContentPanes
        Container myPane = hf.getContentPane();
        myPane.add(buttonPanel, BorderLayout.SOUTH);
        myPane.add(tp, BorderLayout.CENTER);
        JMenuBar jmb = new JMenuBar();
        JMenu jm = new JMenu("Ablage");
        jmb.add(jm);
        JMenuItem jmi = new JMenuItem("Beenden");
        jmi.addActionListener(new exitActionListener());
        jmi.setEnabled(true);
        jm.add(jmi);
        hf.setJMenuBar(jmb);
        //Das JFrame sichtbar machen
        hf.pack();
        hf.setVisible(true);
        hf.setAlwaysOnTop(true);
    }
}