package s1.block10;
public class Main1 {
    public static void main(String[] args) {
        int firstArg=0;
        int stellen=0;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                firstArg = 0;
            }
            finally {
                System.out.println("Die Zahl firstArg = " + firstArg + " wurde eingelesen");
            }
        }
    }
}