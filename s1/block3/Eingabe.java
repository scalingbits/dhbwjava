/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package block3;

/**
 *
 * @author sschneid
 */
import java.util.Scanner;
public class Eingabe {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Geben Sie die erste Zahl ein: ");
        int zahl1 = eingabe.nextInt();
        System.out.print("Geben Sie die zweite Zahl ein: ");
        int zahl2 = eingabe.nextInt();
        System.out.println("Ergebnis: " + zahl1);
        System.out.println("Ergebnis: " + zahl2);
    }
}
