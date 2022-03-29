package s1.block3;

public class AufgabeSwitchCase {
    static short k;

    public static void main(String[] args) {
        short i, k;
        short imax = 10;
        for (i = 1; i < imax; i++) {
            for (k = 1; k < imax; k++) {
                if ((k == i) || (k == (imax - i))) {
                    System.out.print("*");
                }
                else { System.out.print(" "); // ein Leerzeichen
                }
            } // for k
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.print("LINKS");
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.print("RECHTS");
                    break;
                default:
                    System.out.print("MITTE");
            } // switch
            System.out.println(); //Neue Zeile
        } // for i
    } // main
}
