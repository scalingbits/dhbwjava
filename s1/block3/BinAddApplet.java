package s1.block3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
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
public class BinAddApplet extends JApplet implements ActionListener {

    private JTextField eingabeText;
    private JButton enterButton;
    private final JButton maxButtonA;
    private final JButton maxButtonB;
    private final JButton minButtonA;
    private final JButton minButtonB;
    private final JButton berechneButton;
    private final JTextField inputFieldA;
    private final JTextField inputFieldB;
    private final JTextField outputDigitalField;
    private int[] bitsA;
    private int[] bitsB;
    private String inputA = "1";
    private String inputB = "1";
    private int vorzeichen;

    float wert = 0;
    public BinAddApplet() {
        /*
        JPanel minPanel = new JPanel();
        minPanel.setLayout(new BoxLayout(minPanel,BoxLayout.Y_AXIS));

        JPanel maxPanel = new JPanel();
        maxPanel.setLayout(new BoxLayout(maxPanel,BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.Y_AXIS));

        JPanel digitalPanel = new JPanel();
        digitalPanel.setLayout(new BoxLayout(digitalPanel,BoxLayout.Y_AXIS));

        JPanel binaerPanel = new JPanel();
        binaerPanel.setLayout(new BoxLayout(binaerPanel,BoxLayout.Y_AXIS));
*/
        minButtonA = new JButton("MIN");
        minButtonB = new JButton("MIN");
        maxButtonA = new JButton("MAX");
        maxButtonB = new JButton("MAX");
        berechneButton = new JButton("Berechne");
        inputFieldA = new JTextField(inputA,1);
        inputFieldA.setHorizontalAlignment(JTextField.RIGHT);
        inputFieldB = new JTextField(inputB,1);
        inputFieldB.setHorizontalAlignment(JTextField.RIGHT);
        outputDigitalField =
                new JTextField(Short.toString((short)(Integer.decode(inputA)+Integer.decode(inputB))),6);
        outputDigitalField.setEditable(false);
        outputDigitalField.setHorizontalAlignment(JTextField.RIGHT);
        minButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = Short.toString(Short.MIN_VALUE);
                inputFieldA.setText(inputA);
            }
        });

        maxButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = Short.toString(Short.MAX_VALUE);
                inputFieldA.setText(inputA);
            }
        });

        minButtonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputB = Short.toString(Short.MIN_VALUE);
                inputFieldB.setText(inputB);
            }
        });

        maxButtonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputB = Short.toString(Short.MAX_VALUE);
                inputFieldB.setText(inputB);
            }
        });

        berechneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=0;
                int b=0;
                try {
                a = Integer.decode(inputFieldA.getText());
                }
                catch (NumberFormatException ex) {}
                try {
                    b = Integer.decode(inputFieldB.getText());

                }
                catch (NumberFormatException ex) {}
                outputDigitalField.setText(Integer.toString((short) (a + b)));
            }
        });
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.Y_AXIS));
        inputPanel.add(inputFieldA);
        inputPanel.add(inputFieldB);
        inputPanel.add(outputDigitalField);
        //JPanel buttonPanel;

        /*
        bitsA = new int[8];
        bitsB = new int[8];
        //bits = decode(1.0f);

        nanPanel = new JPanel();

        // Erzeugen der Buttons und Texteingabefeld
        JLabel eingabeLabel = new JLabel("Eingabewert: ");
        eingabeText = new JTextField(eingabeWert);
        eingabeText.setPreferredSize(new Dimension(100, 20));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        nanButton = new JButton("N.a.N.");
        nanButton.addActionListener(this);
        negativeInfinityButton = new JButton("-Infinity");
        negativeInfinityButton.addActionListener(this);
        positiveInfinityButton = new JButton("+Infinity");
        positiveInfinityButton.addActionListener(this);
        maxButton = new JButton("MAX_VALUE");
        maxButton.addActionListener(this);
        minButton = new JButton("MIN_VALUE");
        minButton.addActionListener(this);
        JPanel optPanel = new JPanel();
        optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));
        optPanel.add(nanButton);
        optPanel.add(minButton);
        optPanel.add(maxButton);
        optPanel.add(negativeInfinityButton);
        optPanel.add(positiveInfinityButton);
        buttonPanel = new JPanel();
        buttonPanel.add(eingabeLabel);
        buttonPanel.add(eingabeText);
        buttonPanel.add(enterButton);
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(500, 500);

         */
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new BoxLayout(aPanel,BoxLayout.Y_AXIS));
        aPanel.add(minButtonA);
        aPanel.add(maxButtonA);
        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel,BoxLayout.Y_AXIS));
        bPanel.add(minButtonB);
        bPanel.add(maxButtonB);

        JPanel aRow = new JPanel();
        aRow.setLayout(new BoxLayout(aRow,BoxLayout.X_AXIS));
        aRow.add(aPanel);
        aRow.add(inputFieldA);

        JPanel bRow = new JPanel();
        bRow.setLayout(new BoxLayout(bRow,BoxLayout.X_AXIS));
        bRow.add(bPanel);
        bRow.add(inputFieldB);

        JPanel ergebnisPanel = new JPanel();
        ergebnisPanel.setLayout(new BoxLayout(ergebnisPanel,BoxLayout.X_AXIS));
        ergebnisPanel.add(berechneButton);
        ergebnisPanel.add(outputDigitalField)
;
        /* Füllen des HauptPanes */
        Container myPane = getContentPane();

        myPane.setLayout(new BoxLayout(myPane,BoxLayout.Y_AXIS));
        myPane.add(aRow);
        myPane.add(bRow);
        myPane.add(ergebnisPanel);

         //
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
/*
        int hoffSet = 8;  // Ziffernbreite
        int voffset = 15; // Zeilenabstand
        int binaerStart = 100; // Horizontaler Offset für Bitsdarstellung
        int dezimalStart = hoffSet * 2;
        g.setColor(Color.blue);
        g.drawString("32 Bit float:", dezimalStart, 25);
        g.drawString(eingabeWert + " = ", dezimalStart, 45);
        dezimalStart += 10+(eingabeWert.length()) * hoffSet;
        g.drawString("(-1)", dezimalStart, 45);
        dezimalStart += 3 * hoffSet;
        g.drawString(Integer.toString(bits[31]), dezimalStart, 40);
        dezimalStart += 1 * hoffSet;
        g.drawString("*2", dezimalStart, 45);
        dezimalStart += 2 * hoffSet;
        g.drawString("(", dezimalStart, 40);
        dezimalStart += 1 * hoffSet;
        g.drawString(Integer.toString(exponent), dezimalStart, 40);
        dezimalStart += Integer.toString(exponent).length() * hoffSet;
        g.drawString("-127)", dezimalStart, 40);
        dezimalStart += 5 * hoffSet;
        g.drawString("*", dezimalStart, 45);
        dezimalStart += 1 * hoffSet;
        g.drawString(Float.toString(mantisse), dezimalStart, 45);
        int rows = 0;
        int cols;
        g.setColor(Color.black);
        g.drawString("Vorzeichen : ",20,60 + voffset * rows);
        String vorz = "-1*";
        if (bits[31] == 0) {
            vorz = "1*";
        }
        g.drawString(Integer.toString(bits[31]),
                binaerStart,
                60 + voffset * rows);
        rows++;
        g.setColor(Color.black);
        g.drawString("Exponent : ",
                20,
                60 + voffset * rows);
        cols = 0;
        for (int i = 30; i >= 23; i--) {
            g.drawString(Integer.toString(bits[i]),
                    binaerStart + 10 * cols,
                    60 + voffset * rows);
            if (cols != 7) {
                cols++;
            } else {
                cols = 0;
                rows++;
            }
        }
        g.drawString("Mantisse :",20,60 + voffset * rows);
        cols = 0;
        g.setColor(Color.blue);
        g.drawString("1",
                binaerStart + 10 * cols,
                60 + voffset * rows);
        g.setColor(Color.black);
        cols++;
        for (int i = 22; i >= 0; i--) {
            g.drawString(Integer.toString(bits[i]),
                    binaerStart + 10 * cols,
                    60 + voffset * rows);
            if (cols != 7) {
                cols++;
            } else {
                cols = 0;
                rows++;
            }
        }
        g.setColor(Color.blue);
        g.fill3DRect(20,(70 + voffset * rows), 200, 40, rootPaneCheckingEnabled);
                rows++;
        g.setColor(Color.black);
        g.drawString("Die führende 1 der Mantisse ist",
                    20,70 + voffset * rows);
        rows++;
        g.drawString("nicht Teil der Datenstruktur!",
                    20, 70 + voffset * rows);
*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        Object source = e.getSource();
        if (source == nanButton) { //>> Button aufgerufen
            eingabeWert = eingabeText.getText();
            wert = Float.NaN;
        }
        if (source == minButton) {
            wert = Float.MIN_VALUE;
        }
        if (source == maxButton) {
            wert = Float.MAX_VALUE;
        }
        if (source == negativeInfinityButton) {
            wert = Float.NEGATIVE_INFINITY;
        }
        if (source == positiveInfinityButton) {
            wert = Float.POSITIVE_INFINITY;
        }
        if (source == enterButton) {
            try {
                eingabeWert = eingabeText.getText();
                wert = Float.parseFloat(eingabeWert);
            } catch (NumberFormatException ex) {
                // Fehlerbehandlung bei fehlerhafter Eingabe
                eingabeText.setText("Fehler");
                wert = 0;
            }
        }
        bits = decode(wert);
        eingabeText.setText(Float.toString(wert));
        eingabeWert = Float.toString(wert);
        repaint();
         */
    }
    public int[] decode(float s) {
        int size = 32;
        /*
        int t = Float.floatToRawIntBits(s);
        mantisse = Float.intBitsToFloat((t & 0x007FFFFF) | 0x40000000);
        mantisse /= 2;

        System.out.println("Binär Mantisse: "
                + Integer.toBinaryString(Float.floatToRawIntBits(mantisse)));
        exponent = (t & 0x7F800000) >> 23;
        vorzeichen = (t & 0x80000000) >> 31;
        System.out.println("Mantisse:" + mantisse);
        System.out.println("Exponent:" + (exponent - 127));
        System.out.println("Vorzeichen:" + vorzeichen);
        */
        int[] stellen = new int[size];
        /*
        for (int i = 0; i < size; i++) {
            stellen[i] = (1 & t);
            t >>>= 1;
        }
         */
        return stellen;
    }
    public int[] decode(short s) {
        int size = 8;
        long t = Double.doubleToRawLongBits(s);
        int[] stellen = new int[size];
        for (int i = 0; i < size; i++) {
            stellen[i] = (int) (1 & t);
            t >>>= 1;
        }
        return stellen;
    }
     /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args Kommadozeilenargumente, hier nicht benoetigt
     */
    public static void main(String[] args) {
        // Es wird ein JFrame benötigt, in das das Applet als Komponente
        // gesteckt wird.
        JFrame f = new JFrame("BinaerFloatApplet-Standalone");
        f.add(new BinAddApplet());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(400, 300);
        f.setVisible(true);
    }
}
