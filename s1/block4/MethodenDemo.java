package s1.block4;
public class MethodenDemo {

    public static void main(String[] args) {

        int[] zahlenFeld;
        zahlenFeld = ganzZahlenEingabe(args);
        System.out.println(args.length + " arguments found");
        for (int i = 0; i < zahlenFeld.length; i++) {
            System.out.println("zahlenFeld[" + i + "] = " + zahlenFeld[i]);
        }
    }

    private static int[] ganzZahlenEingabe(String[] myArgs) {
        int[] z = new int[myArgs.length];
        if (myArgs.length > 0) {
            try {
                for (int i = 0; i < myArgs.length; i++) {
                    z[i] = Integer.parseInt(myArgs[i]);
                }
            } catch (NumberFormatException e) {
                System.err.println("Input Error: " + e.getMessage());
                System.exit(1);
            }
        }
        return z;
    }

}
