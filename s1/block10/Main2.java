package s1.block10;

public class Main2 {

    public static void main(String[] args) {
        int firstArg = 0;
        int stellen = 0;
        try {
            firstArg = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            firstArg = -1;
            System.out.println("Argument auf Position "
                    + e.getMessage()
                    + " nicht vorhanden");
        } catch (NumberFormatException e) {
            firstArg = 0;
        } finally {
            System.out.println("Die Zahl firstArg = " + firstArg + " wurde eingelesen");
        }
    }
}