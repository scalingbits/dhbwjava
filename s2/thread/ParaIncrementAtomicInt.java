package s2.thread;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author s@scalingbits.com
 */

 public  class ParaIncrementAtomicInt extends Thread {
    public static AtomicInteger zaehler;
    public static final int  MAX= Integer.MAX_VALUE/100;
    public static void increment() {
        zaehler.getAndIncrement();
    }
    /**
     * Starten des Threads
     */
    public void run() {
        for (int i=0; i < MAX; i++) {
            increment();
        }
    }
    public static void main(String[] args) {
        zaehler = new AtomicInteger(0);
        ParaIncrementAtomicInt thread1 = new ParaIncrementAtomicInt();
        ParaIncrementAtomicInt thread2 = new ParaIncrementAtomicInt();
        long time = System.nanoTime();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
        }
        time = (System.nanoTime() -time)/1000000L; // time in milliseconds
        if ((2* ParaIncrementAtomicInt.MAX) == zaehler.get())
            System.out.println("Korrekte Ausführung: " +
                    + ParaIncrementAtomicInt.zaehler.get() + " (" + time + "ms)");
        else
            System.out.println("Fehler! Soll: " + (2* ParaIncrementAtomicInt.MAX) +
                    "; Ist: " +ParaIncrementAtomicInt.zaehler.get() + " (" + time + "ms)");
    }
}