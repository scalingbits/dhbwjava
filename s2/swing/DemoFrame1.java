package s2.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author s@scalingbits.com
 */
public class DemoFrame1 extends javax.swing.JFrame {

    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JTextField jTextFieldin[];
    private JTextField jTextField2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    /**
     * Anzahl der Eingabefelder
     */
    private int inFields = 3;

    /**
     * Initialisieren aller Komponenten
     */
    private void initComponents() {
        jLabel1 = new JLabel();
        jTextFieldin = new JTextField[inFields];
        for (int i = 0; i < inFields; i++) {
            jTextFieldin[i] = new JTextField();
        }
        jTextField2 = new JTextField();

        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My second JFrame");

        jLabel1.setText("Input Text:");

        // Belegen alle Eingabefelder mit Standwerten
        for (int i = 0; i < inFields; i++) {
            jTextFieldin[i].setText("Input" + i);
        }
        // Belegen des Augabefeldes mit Standartwert
        jTextField2.setText("Output");
        jTextField2.setEditable(false);

        // Erzeugen dreier Buttons
        jButton1.setText("Do once:");
        jButton2.setText("Do twice:");
        jButton3.setText("Do three times:");

        // Ezeugen einer Datenstruktur(Panel) die drei Buttons aufnimmt
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(jButton1);
        radioPanel.add(jButton2);
        radioPanel.add(jButton3);

        // Führe Operation 1 aus wenn Button 1 gedrückt wird
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {
                    jTextField2.setText(executeOperation1(
                            jTextFieldin[0].getText(),
                            jTextFieldin[1].getText(),
                            jTextFieldin[2].getText()));
                }
            }
        });

        // Führe Operation 2 aus wenn Button 2 gedrückt wird
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {
                    jTextField2.setText(executeOperation2(
                            jTextFieldin[0].getText(),
                            jTextFieldin[1].getText(),
                            jTextFieldin[2].getText()));
                }
            }
        });

        // Führe Operation 3 aus wenn Button 3 gedrückt wird
        jButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton3) {
                    jTextField2.setText(executeOperation3(
                            jTextFieldin[0].getText(),
                            jTextFieldin[1].getText(),
                            jTextFieldin[2].getText()));
                }
            }
        });

        // Allgemeine Konfiguration des Fensters
        this.setBounds(300, 300, 200, 30);
        setMinimumSize(new Dimension(200, 30));
        // Einfügen der Eingabeaufforderung links
        getContentPane().add(jLabel1, BorderLayout.WEST);
        // Panel zum verwalten von mehreren Eingabefelder
        JPanel inputPanel = new JPanel(new GridLayout(inFields, 0));
        for (int i = 0; i < inFields; i++) {
            inputPanel.add(jTextFieldin[i]);
        }
        // Einfügen des Panels mit Eingabefeldern in der Mitte
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        // Einfügen des Panels mit Buttons oben
        getContentPane().add(radioPanel, BorderLayout.NORTH);
        // Einfügen der Ausgabezeile unten
        getContentPane().add(jTextField2, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Initialierung alle Komponenten
     */
    public DemoFrame1() {
        initComponents();
    }

    /**
     * Hauptprogramm: Erzeuge eine Instanz von DemoFrame1 und zeige sie an
     * @param args
     */
    public static void main(String[] args) {

        DemoFrame1 f1 = new DemoFrame1();
        f1.setVisible(true);
    }

    /**
     * Führe Operation 1 aus (Button 1 wurde gedrückt)
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public String executeOperation1(String s1, String s2, String s3) {
        // Add Application logic here:
        String result = "Button 1:" + s1 + s2 + s3;
        return (result);
    }

    /**
     * Führe Operation 2 aus (Button 2 wurde gedrückt)
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public String executeOperation2(String s1, String s2, String s3) {
        // Add Application logic here:
        String result = "Button 2:" + s1 + s2 + s3;
        return (result);
    }

    /**
     * Führe Operation 3 aus (Button 3 wurde gedrückt)
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public String executeOperation3(String s1, String s2, String s3) {
        // Add Application logic here:
        String result = "Button 3:" + s1 + s2 + s3;
        return (result);
    }
}