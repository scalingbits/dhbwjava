package s2.thread;

public class JoinAndSleep  extends Thread{
    /**
     * Der Thread auf dessen Beendigung gewartet wird
     */
    Thread joinIt;
    /**
     * Zeit in Millisekunden zum Schlafen
     */
    int schlafen;

    /**
     * Der Konstruktor
     * @param sleeptime Die Zeit in msdie der Thread schlafen soll
     * @param toJoin der Thread auf den gewartet werden solll bis er beendet ist
     */
    public JoinAndSleep(int sleeptime, Thread toJoin) {
        joinIt = toJoin;
        schlafen = sleeptime;
        System.out.println("Thread: " + this + " erzeugt");
    }

    /**
     * Die überschriebene Methode run() sie führt den Code aus
     */
    public void run() {
        System.out.println("Thread: " +Thread.currentThread() + " gestartet");
        try {
            if (joinIt!=null) {
                joinIt.join();
                System.out.println("Thread: " +Thread.currentThread()
                        + " join auf " + joinIt + " fertig");
            }
        } catch (InterruptedException e) {}
        System.out.println("Thread: " +Thread.currentThread()
                + " schlaeft jetzt fuer " + schlafen + "ms");
        try {
            Thread.sleep(schlafen);
        } catch (InterruptedException e) {}
        System.out.println("Thread: " +Thread.currentThread() + " endet");
    }

    /**
     * Das Hauptprogramm
     * @param args keine Parameter benoetigt!
     */
    public static void main (String[] args) {
        JoinAndSleep s3= new JoinAndSleep(2003, null);
        JoinAndSleep s2= new JoinAndSleep(2002, s3);
        JoinAndSleep s1= new JoinAndSleep(2001, s2);
        s1.start();
        s2.start();
        s3.start();
    }
}