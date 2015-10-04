package Thread;

/**
 * Created by Aymeric on 15-09-14.
 */
public class OperationA implements Runnable {

    private SynchronizedCounter sc;

    public void setSc(SynchronizedCounter sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        System.out.println("Thread A Started.");
        System.out.println("Thread A::Counter Value is: " + sc.value());
        sc.increment();
        System.out.println("Thread A:: Counter value after incrementation is: " + sc.value());
    }

}
