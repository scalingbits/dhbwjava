package s2.thread;

/**
 *
 * @author s@scalingbits.com
 */
public class MainTest extends Thread {

public static final int INCRITICALPATH = 0;
    public static final int NOTINCRITICALPATH = 1;
    public static final int ENDED = 2;
    public static int anzahlThreads = 15;
    public static MainTest[] mt;
    public int threadStatus = NOTINCRITICALPATH;
    private static EinMonitor myMonitor;
    public static int sleepPeriod = 500;
    public int meineID;
    public static ThreadingPanel tp;
    public static ThreadFenster tg;
    public boolean stop = false;
    public boolean synchron = true;

    public MainTest(int id) {
        meineID = id;
    }
    @Override
    public void run() {
        long anfangszeit = System.nanoTime();
        System.out.println("Thread [" + meineID + "] gestartet");
        //GUIupdate(NOTINCRITICALPATH);
        for (long i = 0; i < 200; i++) {
            Thread t = Thread.currentThread();
            // Erlaube anderen Threads die CPU zu holen
            t.yield();
            if (tg.synchron)
                myMonitor.buchen(10);
            else
                myMonitor.parallelbuchen(10);
        }
        threadStatus = ENDED;
        System.out.println("Thread [" + meineID + "] beendet...");
    }

    public static void main(String[] args) {
        // Anlegen des Monitorobjekts
        myMonitor = new EinMonitor(1000000L);
        mt = new MainTest[anzahlThreads];
        tg = new ThreadFenster();
        tp = tg.tp;
        // Erzeuge die Threads
        for (int i = 0; i < anzahlThreads; i++) {
            mt[i] = new MainTest(i);
        }
        // Starte die Threads
        for (int i = 0; i < anzahlThreads; i++) {
            mt[i].start();
        }
    }
}