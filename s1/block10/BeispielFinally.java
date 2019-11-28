package s1.block10;
class BeispielFinally {
    public static int finallyTest (int a) {
        int result=0;

        try {
            result = 17/a; // Hier kann eine ArithmeticException ausgelöst werden
        }
        catch (ArithmeticException e) {
            return 0;
        }
        finally {
            return 1;
        }
        //System.out.println("Methode beendet. Wir nie erreicht. Daher auskommentiert");
    }
    public static void main(String[] args) {
        int x=0;
        System.out.println(finallyTest(0));
    }
}