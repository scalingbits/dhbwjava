package block3;
public class Haeufigkeitzeichen {
public static void main(String[] args) {
    String myText="";
    char c;
    int histogram[] = new int[Character.MAX_VALUE];

    if (args.length > 0 ) {
        myText=args[0];
        }
    System.out.println("Eingabe: <<" + myText + ">>");
    for (int i=0;i < myText.length(); i++) {
        // Lese jeden Wert der Zeichenkette aus und erhöhe den Zähler im Feld
        c = myText.charAt(i);
        histogram[c]++;
        }
    for (int i=0; i<Character.MAX_VALUE; i++)
        if (histogram[i]!= 0) {
            // Wichtig: unterdrücke alle leeren Einträge.
            // Das Feld hat ~65000 Zellen!
            System.out.print((char)i + ": ");
            for (int j=0; j<histogram[i]; j++)
                System.out.print('*');
            System.out.println();
        }
    }
}
