package s1.block2;

/**
 *
 * @author s@scalingbits.com
 */
public class Test {

    /** Welche dieser Zuweisungen sind in JDK 7 erlaubt?
     * welche sind nur JDK 7 (oder höher) erlaubt ?
     */
    public static void main (String[] args){
        t1();
        t2();
       int a;
       a = 17;
       a = -17;
       a = 1000;
       a = 1_000;
       a = 10_00;
       a = 1_000_000;
       a = 1_000_000_000;
       //a = 100_000_000_000;
       int b = 'a';
       //int c = "a";
       a = 0b1001;
       a = 0x11;
       //a = 17L;
       a = '\r';

       char c;
       c = 'A';
       c = 17;
       //c = 1_000_000;
       

    }

    public static void t1() {
        int a = 3;
        int b = 5;
        if ((a>1) || (a<b++)){
            System.out.println ("Hallo");
        }
        System.out.println("b= " + b);
    }


    public static void t2() {
        int a = 3;
        int b = 5;
        if ((a>1) | (a<b++)){
            System.out.println ("Hallo");
        }
        System.out.println("b= " + b);
    }

}
