package s2.thread;
/**
 *
 * @author s@scalingbits.com
 */
public class MyRunnable implements Runnable {
@Override
public void run() {
        System.out.println("Hurra ich bin myRunnable in einem Thread mit der Id: "
                + Thread.currentThread().getId());
    }
}
