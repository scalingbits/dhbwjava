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
public class BinaerCastApplet extends JApplet implements ActionListener {
    private final JTextField eingabeText;
    private final JButton enterButton;
    private final JRadioButton byteButton;
    private final JRadioButton charButton;
    private final JRadioButton shortButton;
    private final JRadioButton intButton;
    private final JRadioButton longButton;
    private final JRadioButton vonByteButton;
    private final JRadioButton vonCharButton;
    private final JRadioButton vonShortButton;
    private final JRadioButton vonIntButton;
    private final JRadioButton vonLongButton;
    private int[] vonBits;
    private int[] zuBits;
    private String eingabeWert = "0";
    private String typeTxt = "int";
    private String vonTypeTxt = "int";
    private String zuString = "0";
    private String vonString = "0";
    public BinaerCastApplet() {
        JPanel buttonPanel;
        vonBits = new int[32];
        zuBits = new int[32];
        // Erzeugen der Buttons und Texteingabefeld
        JLabel eingabeLabel = new JLabel("Eingabewert y: ");
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
        vonByteButton = new JRadioButton("byte");
        vonCharButton = new JRadioButton("char");
        vonShortButton = new JRadioButton("short");
        vonIntButton = new JRadioButton("int");
        vonIntButton.setSelected(true);
        vonLongButton = new JRadioButton("long");
        ButtonGroup intType = new ButtonGroup();
        intType.add(byteButton);
        intType.add(charButton);
        intType.add(shortButton);
        intType.add(intButton);
        intType.add(longButton);
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typePanel.add(new JLabel("       x"));
        typePanel.add(byteButton);
        typePanel.add(charButton);
        typePanel.add(shortButton);
        typePanel.add(intButton);
        typePanel.add(longButton);
        ButtonGroup vonIntType = new ButtonGroup();
        vonIntType.add(vonByteButton);
        vonIntType.add(vonCharButton);
        vonIntType.add(vonShortButton);
        vonIntType.add(vonIntButton);
        vonIntType.add(vonLongButton);
        JPanel vonTypePanel = new JPanel();
        vonTypePanel.setLayout(new BoxLayout(vonTypePanel, BoxLayout.Y_AXIS));
        vonTypePanel.add(new JLabel("       y"));
        vonTypePanel.add(vonByteButton);
        vonTypePanel.add(vonCharButton);
        vonTypePanel.add(vonShortButton);
        vonTypePanel.add(vonIntButton);
        vonTypePanel.add(vonLongButton);
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
        myPane.add(vonTypePanel, BorderLayout.EAST);
        myPane.add(typePanel, BorderLayout.WEST);
        myPane.add(centerPanel, BorderLayout.CENTER);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int offSetLinks = 80;
        g.setColor(Color.blue);
        g.drawString(vonTypeTxt + " y = "+vonString +"; ", offSetLinks, 20);
        g.drawString(typeTxt + " x = ("+typeTxt +") y;", offSetLinks, 40);
        g.setColor(Color.black);
        g.drawString(" y: " + vonString +"; binär:",offSetLinks, 65);
        int rows=0;
        int cols=0;
        for (int i = (vonBits.length - 1); i >= 0; i--) {
            if (i == vonBits.length - 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawString(Integer.toString(vonBits[i]),
                    offSetLinks + 10 * cols,
                    80+ 15*rows);
            if (cols!=15) cols++;
            else {cols=0; rows++;}
        }
        if (cols==8) rows++; // habe ein byte gemalt.
        cols=0;
        g.drawString(" x: " + zuString +"; binär:",offSetLinks, 85+ 15*rows);
        rows++;
        for (int i = (zuBits.length - 1); i >= 0; i--) {
            if (i == zuBits.length - 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawString(Integer.toString(zuBits[i]),
                    offSetLinks + 10 * cols,
                    85+ 15*rows);
            if (cols!=15) cols++;
            else {cols=0; rows++;}
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            eingabeWert = eingabeText.getText();
            if (source == enterButton) { //enter Button aufgerufen
                if (byteButton.isSelected()) typeTxt = "byte";
                if (shortButton.isSelected()) typeTxt = "short";
                if (charButton.isSelected()) typeTxt = "char";
                if (intButton.isSelected()) typeTxt = "int";
                if (longButton.isSelected()) typeTxt = "long";
                if (vonByteButton.isSelected()) {
                    vonTypeTxt = "byte";
                    byte wert = Byte.parseByte(eingabeWert);
                    vonBits = decode(wert);
                    vonString = Byte.toString(wert);
                    if (byteButton.isSelected()) {
                        byte zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Byte.toString(zuWert);
                    }
                    if (shortButton.isSelected()) {
                        short zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Short.toString(zuWert);
                    }
                    if (charButton.isSelected()) {
                        char zuWert = (char)wert;
                        zuBits = decode(zuWert);
                        zuString = "'"+ zuWert +"'";
                    }
                    if (intButton.isSelected()) {
                        int zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Integer.toString(zuWert);
                    }
                    if (longButton.isSelected()) {
                        long zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Long.toString(zuWert);
                    }
                }
                if (vonShortButton.isSelected()) {
                    vonTypeTxt = "short";
                    short wert = Short.parseShort(eingabeWert);
                    vonBits = decode(wert);
                    vonString = Short.toString(wert);
                    if (byteButton.isSelected()) {
                        byte zuWert = (byte)wert;
                        zuBits = decode(zuWert);
                        zuString = Byte.toString(zuWert);
                    }
                    if (shortButton.isSelected()) {
                        short zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Short.toString(zuWert);
                    }
                    if (charButton.isSelected()) {
                        char zuWert = (char)wert;
                        zuBits = decode(zuWert);
                        zuString = "'"+ zuWert +"'";
                    }
                    if (intButton.isSelected()) {
                        int zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Integer.toString(zuWert);
                    }
                    if (longButton.isSelected()) {
                        long zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Long.toString(zuWert);
                    }
                }
                if (vonCharButton.isSelected()) {
                    vonTypeTxt = "char";
                    char wert = eingabeWert.charAt(0);
                    vonBits = decode(wert);
                    vonString = "'"+ wert +"'";
                    if (byteButton.isSelected()) {
                        byte zuWert = (byte)wert;
                        zuBits = decode(zuWert);
                        zuString = Byte.toString(zuWert);
                    }
                    if (shortButton.isSelected()) {
                        short zuWert = (short)wert;
                        zuBits = decode(zuWert);
                        zuString = Short.toString(zuWert);
                    }
                    if (charButton.isSelected()) {
                        char zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = "'"+ zuWert +"'";
                    }
                    if (intButton.isSelected()) {
                        int zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Integer.toString(zuWert);
                    }
                    if (longButton.isSelected()) {
                        long zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Long.toString(zuWert);
                    }
                }
                if (vonIntButton.isSelected()) {
                    vonTypeTxt = "int";
                    int wert = Integer.parseInt(eingabeWert);
                    vonBits = decode(wert);
                    vonString = Integer.toString(wert);
                    if (byteButton.isSelected()) {
                        byte zuWert = (byte)wert;
                        zuBits = decode(zuWert);
                        zuString = Byte.toString(zuWert);
                    }
                    if (shortButton.isSelected()) {
                        short zuWert = (short)wert;
                        zuBits = decode(zuWert);
                        zuString = Short.toString(zuWert);
                    }
                    if (charButton.isSelected()) {
                        char zuWert = (char)wert;
                        zuBits = decode(zuWert);
                        zuString = "'"+ zuWert +"'";
                    }
                    if (intButton.isSelected()) {
                        int zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Integer.toString(zuWert);
                    }
                    if (longButton.isSelected()) {
                        long zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Long.toString(zuWert);
                    }
                }
                if (vonLongButton.isSelected()) {
                    vonTypeTxt = "long";
                    long wert = Long.parseLong(eingabeWert);
                    vonBits = decode(wert);
                    vonString = Long.toString(wert);
                    if (byteButton.isSelected()) {
                        byte zuWert = (byte)wert;
                        zuBits = decode(zuWert);
                        zuString = Byte.toString(zuWert);
                    }
                    if (shortButton.isSelected()) {
                        short zuWert = (short)wert;
                        zuBits = decode(zuWert);
                        zuString = Short.toString(zuWert);
                    }
                    if (charButton.isSelected()) {
                        char zuWert = (char)wert;
                        zuBits = decode(zuWert);
                        zuString = "'"+ zuWert +"'";
                    }
                    if (intButton.isSelected()) {
                        int zuWert = (int)wert;
                        zuBits = decode(zuWert);
                        zuString = Integer.toString(zuWert);
                    }
                    if (longButton.isSelected()) {
                        long zuWert = wert;
                        zuBits = decode(zuWert);
                        zuString = Long.toString(zuWert);
                    }
                }
            }
        } catch (java.lang.NumberFormatException ex) {
            // Fehlerbehandlung bei fehlerhafter Eingabe
            eingabeWert="Fehler";
            eingabeText.setText(eingabeWert);
            vonBits = decode((byte)0);
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
     * @param args Kommandozeilenparameter (nicht benötigt)
     */
    public static void main(String[] args) {
        // Es wird ein JFrame benötigt, in das das Applet als Komponente
        // gesteckt wird.
        JFrame f = new JFrame("BinaerCastApplet-Standalone");
        f.add(new BinaerCastApplet());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(400, 300);
        f.setVisible(true);
    }
}
