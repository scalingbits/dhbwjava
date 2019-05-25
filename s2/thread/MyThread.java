package s2.thread;

/**
 *
 * @author s@scalingbits.com
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hurra ich bin myThread in einem Thread mit der Id: "
                + Thread.currentThread().getId());
    }
   
    public static void main(String[] args) {
        System.out.println("Start MyThread.main() Methode im Thread mit der Id: "
                + Thread.currentThread().getId());
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Ende MyThread.main() Methode im Thread mit der Id: "
                + Thread.currentThread().getId());
        MyThread t2 = new MyThread();
        // t2 ist zwar ein Threadobjekt und repräsentiert einen Thread
        // da das Objekt nicht mit start() aufgerufen läuft es im gleichen
        // Thread wie die main() Routine!
        t2.run();
    }
}