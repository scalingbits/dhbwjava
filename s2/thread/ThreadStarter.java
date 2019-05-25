package s2.thread;
/**
 *
 * @author s@scalingbits.com
 */
public class ThreadStarter{
    public static void main(String[] args) {
        System.out.println("Start ThreadStarter.main() Methode im Thread mit der Id: "
                + Thread.currentThread().getId());
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        System.out.println("Ende ThreadStarter.main() Methode im Thread mit der Id: "
                + Thread.currentThread().getId());
        // r2 ist zwar ein Runnableobjekt , da das Objekt aber nicht von einem
        //  Threadobjekt indirekt aufgerufen wirdläuft es im gleichen
        // Thread wie die main() Routine!
        r2.run();
    }
}