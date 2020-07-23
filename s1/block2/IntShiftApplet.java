package s1.block2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author sschneid
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
public class IntShiftApplet extends JApplet implements ActionListener {

    private final JTextField eingabeText;
    private final JButton enterButton;
    private final JButton leftShiftNullFillButton;
    private final JButton rightShiftButton;
    private final JButton rightShiftNullFillButton;
    private final JButton maxButton;
    private final JButton minButton;
    private int[] bits;
    private String eingabeWert = "1";
    private int vorzeichen;
    private float mantisse;
    private int exponent;
    int wert = 1;
    public IntShiftApplet() {
        JPanel buttonPanel;
        bits = new int[32];
        bits = decode(1);
        // Erzeugen der Buttons und Texteingabefeld
        JLabel eingabeLabel = new JLabel("Eingabewert: ");
        eingabeText = new JTextField(eingabeWert);
        eingabeText.setPreferredSize(new Dimension(100, 20));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        leftShiftNullFillButton = new JButton("a << 1");
        leftShiftNullFillButton.addActionListener(this);
        rightShiftButton = new JButton("a >> 1");
        rightShiftButton.addActionListener(this);
        rightShiftNullFillButton = new JButton("a >>> 1");
        rightShiftNullFillButton.addActionListener(this);
        maxButton = new JButton("MAX_VALUE");
        maxButton.addActionListener(this);
        minButton = new JButton("MIN_VALUE");
        minButton.addActionListener(this);
        JPanel optPanel = new JPanel();
        optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));
        optPanel.add(minButton);
        optPanel.add(maxButton);
        optPanel.add(leftShiftNullFillButton);
        optPanel.add(rightShiftButton);
        optPanel.add(rightShiftNullFillButton);
        buttonPanel = new JPanel();
        buttonPanel.add(eingabeLabel);
        buttonPanel.add(eingabeText);
        buttonPanel.add(enterButton);
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(500, 500);
        Container myPane = getContentPane();
        myPane.add(buttonPanel, BorderLayout.SOUTH);
        myPane.add(optPanel, BorderLayout.EAST);
        myPane.add(centerPanel, BorderLayout.CENTER);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int hoffSet = 8;  // Ziffernbreite
        int voffset = 15; // Zeilenabstand
        int binaerStart = 80; // Horizontaler Offset für Bitsdarstellung
        int dezimalStart = hoffSet * 2;
        int vertikal = 25;
        g.setColor(Color.blue);
        g.drawString("32 Bit Integer", dezimalStart, vertikal);
        g.setColor(Color.black);
        vertikal += hoffSet*2;
        g.drawString("Dezimal: a = "+ eingabeWert, dezimalStart, vertikal);
        vertikal += hoffSet*2;
        g.drawString("Binär: a =", dezimalStart, vertikal);

        int rows = 0;
        int cols = 0;
        for (int i = (bits.length - 1); i >= 0; i--) {
            if (i == bits.length - 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawString(Integer.toString(bits[i]),
                    binaerStart + 10 * cols,
                    vertikal+ 15*rows);
            if (cols != 7) cols++;
            else {cols=0; rows++;}
        }
}
    /**
     * Diese Methode decodiert Benutzer
     * @param e das Ereignisobjekt
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == leftShiftNullFillButton) {
            eingabeWert = eingabeText.getText();
            wert = wert << 1;
        }
        if (source == minButton) {
            wert = Integer.MIN_VALUE;
        }
        if (source == maxButton) {
            wert = Integer.MAX_VALUE;
        }
        if (source == rightShiftButton) {
            wert = wert >> 1;
        }
        if (source == rightShiftNullFillButton) {
            wert = wert >>> 1;
        }
        if (source == enterButton) {
            try {
                eingabeWert = eingabeText.getText();
                wert = Integer.parseInt(eingabeWert);
            } catch (java.lang.NumberFormatException ex) {
                // Fehlerbehandlung bei fehlerhafter Eingabe
                eingabeText.setText("Fehler");
                wert = 0;
            }
        }
        bits = decode(wert);
        eingabeText.setText(Integer.toString(wert));
        eingabeWert = Integer.toString(wert);
        repaint();
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
     /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args Kommandozeilenparameter (nicht benötigt)
     */
    public static void main(String[] args) {
        // Es wird ein JFrame benötigt, in das das Applet als Komponente
        // gesteckt wird.
        JFrame f = new JFrame("IntShiftApplet-Standalone");
        f.add(new IntShiftApplet());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(400, 300);
        f.setVisible(true);
    }
}
