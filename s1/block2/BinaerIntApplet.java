package s1.block2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 *
 * @author s@scalingbits.com
 * @version 1.2
 *
 * Copyright (c) 2013, Dr. Stefan Schneider, schneider4me.de
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
public class BinaerIntApplet extends JApplet implements ActionListener {
    private JTextField eingabeText;
    private JButton enterButton;
    private JRadioButton byteButton;
    private JRadioButton charButton;
    private JRadioButton shortButton;
    private JRadioButton intButton;
    private JRadioButton longButton;
    private int[] bits;
    private String eingabeWert = "0";
    private String typeTxt = "int";
    /**
     * Konstruktor der Klasse. Hier werden alle graphischen
     * Objekte angeliegt.
     */
    public BinaerIntApplet() {
        JPanel buttonPanel;
        JFrame f;
        Container co;
        bits = new int[32];
        // Erzeugen der Buttons und Texteingabefeld
        JLabel eingabeLabel = new JLabel("Eingabewert: ");
        eingabeText = new JTextField(eingabeWert);
        eingabeText.setPreferredSize(new Dimension(100, 20));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        byteButton = new JRadioButton("byte");
        byteButton.setMnemonic(KeyEvent.VK_B);
        charButton = new JRadioButton("char");
        charButton.setMnemonic(KeyEvent.VK_C);
        shortButton = new JRadioButton("short");
        shortButton.setMnemonic(KeyEvent.VK_S);
        intButton = new JRadioButton("int");
        intButton.setMnemonic(KeyEvent.VK_I);
        intButton.setSelected(true);
        longButton = new JRadioButton("long");
        longButton.setMnemonic(KeyEvent.VK_L);
        ButtonGroup intType = new ButtonGroup();
        intType.add(byteButton);
        intType.add(charButton);
        intType.add(shortButton);
        intType.add(intButton);
        intType.add(longButton);
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typePanel.add(byteButton);
        typePanel.add(charButton);
        typePanel.add(shortButton);
        typePanel.add(intButton);
        typePanel.add(longButton);
        // Einfügen der drei Komponenten in ein Panel
        // Das Gridlayout führt zum Strecken der drei Komponenten
        buttonPanel = new JPanel();
        buttonPanel.add(eingabeLabel);
        buttonPanel.add(eingabeText);
        buttonPanel.add(enterButton);
        JPanel centerPanel=new JPanel();
        centerPanel.setSize(500, 500);
        Container myPane = getContentPane();
        myPane.add(buttonPanel, BorderLayout.SOUTH);
        myPane.add(typePanel, BorderLayout.EAST);
        myPane.add(centerPanel, BorderLayout.CENTER);
    }
    /**
     * Dies Methode erlaubt das Malen der Vektorgraphik
     * auf dem Hintergrund der graphischen Komponente
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.blue);
        g.drawString(typeTxt + ", " +bits.length + " bits, "
                +eingabeWert +": ", 20, 25);

        int rows=0;
        int cols=0;
        for (int i = (bits.length - 1); i >= 0; i--) {
            if (i == bits.length - 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawString(Integer.toString(bits[i]),
                    20 + 10 * cols,
                    50+ 25*rows);
            if (cols!=15) cols++;
            else {cols=0; rows++;}
        }
    }
    /**
     * Diese Methode wird nach einer Eingabe aufgerufen.
     * Sie dekodiert die Eingabe des Benutzers
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            eingabeWert = eingabeText.getText();
            if (source == enterButton) { //enter Button aufgerufen
                if (byteButton.isSelected()) {
                    typeTxt = "byte";
                    byte wert = Byte.parseByte(eingabeWert);
                    bits = decode(wert);
                }
                if (shortButton.isSelected()) {
                    typeTxt = "short";
                    short wert = Short.parseShort(eingabeWert);
                    bits = decode(wert);
                }
                if (charButton.isSelected()) {
                    typeTxt = "char";
                    char wert = eingabeWert.charAt(0);
                    bits = decode(wert);
                    eingabeWert = eingabeWert.substring(0, 1);
                }
                if (intButton.isSelected()) {
                    typeTxt = "int";
                    int wert = Integer.parseInt(eingabeWert);
                    bits = decode(wert);
                }
                if (longButton.isSelected()) {
                    typeTxt = "long";
                    long wert = Long.parseLong(eingabeWert);
                    bits = decode(wert);
                }
            }
        } catch (java.lang.NumberFormatException ex) {
            // Fehlerbehandlung bei fehlerhafter Eingabe
            eingabeWert="Fehler";
            eingabeText.setText(eingabeWert);
            bits = decode((byte)0);
        }
        repaint();
    }
    public static int[] decode(short s) {
        int size = 16;
        int[] stellen = new int[size];
        for (int i = 0; i < size; i++) {
            stellen[i] = (1 & s);
            s >>>= 1;
        }
        return stellen;
    }
    public static int[] decode(byte s) {
        int size = 8;
        int[] stellen = new int[size];
        for (int i = 0; i < size; i++) {
            stellen[i] = (1 & s);
            s >>>= 1;
        }
        return stellen;
    }

    public static int[] decode(char s) {
        return decode((short) s);
    }

    public static int[] decode(int s) {
        int size = 32;
        int[] stellen = new int[size];
        for (int i = 0; i < size; i++) {
            stellen[i] = (1 & s);
            s >>>= 1;
        }
        return stellen;
    }
    public static int[] decode(long s) {
        int size = 64;
        int[] stellen = new int[size];
        for (int i = 0; i < size; i++) {
            stellen[i] = (int) (1 & s);
            s >>>= 1;
        }
        return stellen;
    }
     /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args
     */
    public static void main(String[] args) {
        // Es wird ein JFrame benötigt, in das das Applet als Komponente
        // gesteckt wird.
        JFrame f = new JFrame("BinaerIntApplet-Standalone");
        f.add(new BinaerIntApplet());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
