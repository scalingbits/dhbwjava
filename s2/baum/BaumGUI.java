package s2.baum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * * Das GUI der Baumanwendung
 * @author sschneid
 */
public class BaumGUI implements ActionListener {

final private JFrame hf;
final private JButton einfButton;
final private JButton entfButton;
final private JTextField eingabeText;
final private JMenuBar jmb;
final private JMenu jm;
final private JMenuItem exitItem;
final private BaumPanel myBaum;
final private Binaerbaum b;

public BaumGUI(Binaerbaum bb) {
        b = bb;
        //ButtonGroup buttonGroup1;
        JPanel buttonPanel;
        // Erzeugen einer neuen Instanz eines Swingfensters
        hf = new JFrame("BaumGUI");
        // Gewünschte Größe setzen
        //     1. Parameter: horizontale Größe in Pixel
        //     2. Parameter: vertikale Größe
        hf.setSize(220, 230);

// Beenden bei Schliesen des Fenster
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Erzeugen der Buttons und Texteingabefeld
        eingabeText = new JTextField("17");
        einfButton = new JButton();
        einfButton.setText("Einfügen");
        entfButton = new JButton();
        entfButton.setText("Entfernen");

        // Registriere die eigene Instanz
        // zum Reagieren auf eine Aktion der beiden Buttons
        einfButton.addActionListener(this);
        entfButton.addActionListener(this);

         // Einfügen der drei Komponenten in ein Panel
        // Das Gridlayout führt zum Strecken der drei Komponenten
        buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(eingabeText);
        buttonPanel.add(entfButton);
        buttonPanel.add(einfButton);

        // Erzeugen des Panels zum Malen des Baums
        myBaum = new BaumPanel(b);

        // setze Titel des Frame
        hf.setTitle(b.algorithmus());

        // Erzeuge ein Menueeintrag zum Beenden des Programms
        jmb = new JMenuBar();
        jm = new JMenu("Datei");
        exitItem = new JMenuItem("Beenden");
        exitItem.addActionListener(this);
        jm.add(exitItem);
        jmb.add(jm);
        hf.setJMenuBar(jmb);

Container myPane = hf.getContentPane();
        myPane.add(myBaum, BorderLayout.CENTER);
        myPane.add(buttonPanel, BorderLayout.SOUTH);

hf.pack();
        hf.setVisible(true);
        hf.setAlwaysOnTop(true);
    }

    /**
     * Diese Methode wird bei allen Aktionen der Menüleiste oder
     * der Buttons aufgerufen
     * @param e Beschreibung der Action
     **/
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int wert = 0;
        try {
            if (source == entfButton) { //Entfernen aufgerufen
                wert = Integer.parseInt(eingabeText.getText());
                b.entfernen(new Baumknoten(wert));
                myBaum.fehlerText("");
                myBaum.repaint();
                eingabeText.setText("");
            }
            if (source == einfButton) { // Einfügen aufgerufen
                wert = Integer.parseInt(eingabeText.getText());
                b.einfuegen(new Baumknoten(wert));
                myBaum.fehlerText("");
                myBaum.repaint();
                eingabeText.setText("");
            }
            if (source == exitItem) { // Beenden aufgerufen
                System.exit(0);
            }
        } catch (java.lang.NumberFormatException ex) {
            // Fehlerbehandlung bei fehlerhafter Eingabe
            myBaum.fehlerText("Eingabe '" + eingabeText.getText() + "' ist keine Ganzzahl");
            myBaum.repaint();
            eingabeText.setText("");
        }
    }

public static void main(String[] args) {
        BaumGUI sg = new BaumGUI(new Binaerbaum());
        if ((args.length > 0) && (args[0].equalsIgnoreCase("magic"))) {
            sg.magicMode(15);
        }

}

public void magicMode(int anzahl) {
        Baumknoten[] gz = new Baumknoten[anzahl];
        for (int i = 0; i < gz.length; i++) {
            gz[i] = new Baumknoten(0);
            gz[i].generiereZufallswert();
        }
        try {
            for (int i = gz.length - 1; i >= 0; i--) {
                eingabeText.setText(gz[i].toString());
                b.einfuegen(gz[i]);
                Thread.sleep(800);
                myBaum.repaint();
            }
            for (int i = 0; i < gz.length; i++) {
                eingabeText.setText(gz[i].toString());
                b.entfernen(gz[i]);
                Thread.sleep(800);
                myBaum.repaint();
            }
        } catch (InterruptedException e) {
        }
    }

}
