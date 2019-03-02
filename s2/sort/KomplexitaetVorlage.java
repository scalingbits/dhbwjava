package s2.sort;

public class KomplexitaetVorlage {

    public static void main(String[]args) {
        long n=10;
        test2(n);
        System.out.println("Fertig");
    }

    public static void test1(long n) {
        long a=0;
        a = a+n;
    }

    public static void test2(long n) {
        long a=0;
        a = a+n;
        a = a+n;
    }

    public static void testk(long n) {
        long a=0;
        a = a+n;
        a = a+n;
        a = a+n;
        a = a+n;
        a = a+n;
        a = a+n;
    }

    public static void testn(long n) {
        long a=0;
        for (long i=0; i<n;i++)
            a= a+4;
    }

    public static void testn2(long n) {
        long a=0;
        for (long i=0; i<n;i++) {
            a= a+4;
            a=a-1;
        }
        a=a*2; //Optional
    }

    public static void testn3(long n) {
        long a=0;
        for (long i=0; i<n;i++)
            a= a+4;
        for (long i=0; i<n;i++)
            a=a-1;
    }

    public static void testn4(long n) {
        testn2(n);
        testn2(n);
    }

    public static void testnn(long n) { // O(n^2)
        long a=0;
        for (long i=0; i<n;i++)
            for (long j=0; j<n;j++)
            a=a+1;
    }

    public static void testnn2(long n) { // O(n^2)
        long a=0;
        for (long i=0; i<n;i++)
            for (long j=0; j<i;j++)
            a=a+1;
    }

    public static void testnn3(long n) { // O(n^3)
        long a=0;
        for (long i=0; i<n;i++)
            testnn2(n);
    }

    public static void testlogn(long n) { // O(log(n))
        long a=0;
        while (n>1) {
            a=a+1;
            n/=2;
        }

    }
}
