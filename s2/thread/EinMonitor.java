package s2.thread;

/**
 *
 * @author s@scalingbits.com
 */
public class EinMonitor {

long invariante;
    long a;
    long b;

public EinMonitor(long para) {
        invariante = para;
        a = para;
        b = 0L;
    }

synchronized  public void buchen(long wert) {
       GUIupdate(MainTest.INCRITICALPATH);
        sleepABit(MainTest.sleepPeriod/5);
        this.a = this.a - wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.b = this.b + wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.a = this.a + wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.b = this.b - wert;
        sleepABit(MainTest.sleepPeriod/5);
        GUIupdate(MainTest.NOTINCRITICALPATH);

if ((a+b) != invariante)
            System.out.println("Inkonsistenter Zustand");
    }
   
   public void parallelbuchen(long wert) {
        GUIupdate(MainTest.INCRITICALPATH);
        sleepABit(MainTest.sleepPeriod/5);
        this.a = this.a - wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.b = this.b + wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.a = this.a + wert;
        sleepABit(MainTest.sleepPeriod/5);
        this.b = this.b - wert;
        sleepABit(MainTest.sleepPeriod/5);
        GUIupdate(MainTest.NOTINCRITICALPATH);

if ((a+b) != invariante)
            System.out.println("Inkonsistenter Zustand");
    }

private void sleepABit(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {}
    }

private void GUIupdate(int status) {
        MainTest t = (MainTest) Thread.currentThread();
        t.threadStatus = status;
        t.tp.repaint();
    }
}
