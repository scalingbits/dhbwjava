package s1.block3;
public class Textverschluesselung {
    public static void main(String[] args) {
    String myText = "";
    int offSet = 0;
    char c;

    if (args.length > 1 ) {
        offSet = Integer.parseInt(args[0]);
        myText = args[1];
        }
    System.out.println("Eingabe: <<" + myText + ">>, Verschiebung: " + offSet);
    System.out.print("Ausgabe: <<");
    offSet = offSet%26; // Bei 26 Buchstaben kann der Versatz nur module 26 sein
    for (int i=0;i < myText.length(); i++) {
        // Lese jeden Wert der Zeichenkette aus und erhöhe den Zähler im Feld
        c = myText.charAt(i);
        if ((c>='A') && (c<='Z')) {
            c = (char)(c + offSet);
            if (c > 'Z') c-=(char)26; //Ziehe vom Ergebnis 26 ab da es jenseits von "Z" liegt.
            System.out.print(c);
            }
        }
        System.out.println(">>");
 }       
}
