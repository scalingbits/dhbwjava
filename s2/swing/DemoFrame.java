package s2.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoFrame extends javax.swing.JFrame {
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;


    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My first JFrame");
        jLabel1.setText("Input Text:");
        jTextField1.setText("Input");
        jTextField2.setText("Output");
        jTextField2.setEditable(false);

        jButton1.setText("Do once:");
        jButton2.setText("Do twice:");
        jButton3.setText("Do three times:");

        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(jButton1);
        radioPanel.add(jButton2);
        radioPanel.add(jButton3);

        jButton1.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e) {
                                           if(e.getSource() == jButton1)
                                               jTextField2.setText(
                                                       executeOperation1(jTextField1.getText()));
                                       }
                                   }
        );
        jButton2.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e) {
                                           if(e.getSource() == jButton2)
                                               jTextField2.setText(
                                                       executeOperation2(jTextField1.getText()));
                                       }
                                   }
        );
        jButton3.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e) {
                                           if(e.getSource() == jButton3)
                                               jTextField2.setText(
                                                       executeOperation3(jTextField1.getText()));
                                       }
                                   }
        );

        this.setBounds(300, 300, 200, 30);
        setMinimumSize(new Dimension(200,30));
        getContentPane().add(jLabel1, BorderLayout.WEST);
        getContentPane().add(jTextField1, BorderLayout.CENTER);
        getContentPane().add(radioPanel, BorderLayout.NORTH);
        getContentPane().add(jTextField2, BorderLayout.SOUTH);
        pack();
    }
    public DemoFrame() {
        initComponents();
    }

    public static void main(String[] args) {

        DemoFrame f1 = new DemoFrame();
        f1.setVisible(true);

    }

    public String executeOperation1(String s) {
        // Add Application logic here:
        String result = "Button 1:" + s;
        return (result) ;
    }
    public String executeOperation2(String s) {
        // Add Application logic here:
        String result = "Button 2:" + s + s;
        return (result) ;
    }
    public String executeOperation3(String s) {
        // Add Application logic here:
        String result = "Button 3:" + s + s +s;
        return (result) ;
    }

}
