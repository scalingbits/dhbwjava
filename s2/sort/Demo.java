/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.sort;

/**
 *
 * @author sschneid
 */
public class Demo {

    public static void main(String[] args) {
        long n = 100;
        test1(n);

    }

    public static void test1(long n) { // O(n)=1
        long a;

        a = n*2;

    }

    public static void testn2(long n) {
        long a=0;
        for (long i=1; i<n; i++) {
            a = a + 5;
            a = a - 2;
        }

        long b = n*n;

    }

    public static void testn3(long n) {
        long a=0;
        for (long i=1; i<n; i++) {
            a = a + 5;
        }
        for (long i=1; i<n; i++) {
            a = a - 2;
        }

    }

    public static void testn4(long n) {
        long a=0;
        for (long i=1; i<n; i++) {
            for (long j=1; i<n; i++)
            a = a + 2;
        }

    }

    public static void testlog(long n) {
        long a=0;
        while (n != 1) {
            a= a+1;
            n = n/2;
        }

    }

}
