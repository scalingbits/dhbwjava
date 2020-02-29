package s1.block1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author s@scalingbits.com
 * @version 1.4
 *
 * Copyright (c) 2016, Dr. Stefan Schneider, schneider4me.de All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of the FreeBSD Project.
 */
public class Kubikwurzel extends JApplet {
    private int versuche = 0;
    private int richtig = 0;
    private int falsch = 0;
    private int wurzel = 0;
    private int potenz = 0;
    final private JTextField eingabeFeld;
    final private JLabel status;
    final private JLabel challenge;
    /**
     * Innere Klasse zum Behandeln der GUI Eingaben
     */
    private class MyListener implements ActionListener {
        String statusText;
        @Override
        public void actionPerformed(ActionEvent e) {
            int eing = 0;
            boolean ergebnis;
            try {
                eing = Integer.decode(eingabeFeld.getText());
            } catch (NumberFormatException n) {
                ergebnis = false;
            }
            ergebnis = (eing == wurzel);
            versuche++;
            if (ergebnis) {
                eingabeFeld.setBackground(Color.green);
                richtig++;
            } else {
                eingabeFeld.setBackground(Color.red);
                falsch++;
            }
            statusText = (ergebnis ? "Richtig! " : "Falsch! ")
                    + versuche + " Versuche, "
                    + richtig + " richtig, "
                    + falsch + " falsch";
            status.setText(statusText);
            status.setBackground(Color.RED);
            neueWurzel();
            challenge.setText("Kubikwurzel von " + potenz + " ?");
            eingabeFeld.setText("");
        }
    }
    /**
     * Konstruktor der Klasse. Hier werden alle graphischen
     * Objekte konfiguriert.
     */
    public Kubikwurzel() {
        neueWurzel();
        JFrame f;
        Container co;
        JPanel meinPanel = new JPanel();
        meinPanel.setLayout(new BorderLayout());
        Kubikwurzel.MyListener ml = new Kubikwurzel.MyListener();
        eingabeFeld = new JTextField(4);
        eingabeFeld.setBackground(Color.white);
        eingabeFeld.addActionListener(ml);
        challenge = new JLabel("Kubikwurzel von " + potenz + " ?");
        JButton enter = new JButton("Enter");
        enter.addActionListener(ml);
        status = new JLabel("0 Versuche. 0 richtig. 0 falsch");
        status.setBackground(Color.pink);
        meinPanel.add(challenge, BorderLayout.WEST);
        meinPanel.add(eingabeFeld, BorderLayout.CENTER);
        meinPanel.add(enter, BorderLayout.EAST);
        meinPanel.add(status, BorderLayout.SOUTH);
        this.add(meinPanel);
    }
     /**
     * Starten der Anwendung als eigenständiges Programm
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Kubikwurzel");
        f.add(new Kubikwurzel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
    /**
     * Berechnen eines neuen Tupels von Kubikwurzel
     * und dazu gehöriger dritter Potenz
     */
    public final void neueWurzel() {
        wurzel = (int) (Math.random() * 100D);
        potenz = wurzel * wurzel * wurzel;
    }
    /**
     * Berechnet die Kubikwurzel eine positiven Zahl
     *
     * @param k  Zahl von der die Kubikwurzel berechnet werden soll.
     * @return ergebnis die Kubikwurzel
     */

    public static int kubikwurzelVon(int k) {
        int ergebnis=1;
        do {
           int f = primfaktor(k);
           ergebnis = ergebnis*f;
           k = k / (f*f*f);
        } while (k>1);
        return ergebnis;
    }
    /**
     * Diese Methode berechnet einen Primfaktor des Werts k
     * Es wird 1 zurückgegeben wenn es keine anderen Primfaktoren
     * gibt
     * @param k Die Zahl von der ein Primfaktor berechnet wird
     * @return f ein Primfaktor der Zahl oder 1 falls keiner existiert
     */
    public static int primfaktor(int k) {
        int f = 1;
        do { f++;
        }
        while ((k/f*f!=k)&&(f<k));
        if (f==k) f=1;
       return f;
    }
}
