package Thread;

/**
 * Created by Aymeric on 15-09-14.
 */
public class OperationB implements Runnable {

    private SynchronizedCounter sc;

    public void setSc(SynchronizedCounter sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        System.out.println("Thread B Started.");
        System.out.println("Thread B::Counter Value is: " + sc.value());
        sc.decrement();
        System.out.println("Thread B:: Counter value after decrementation is: " + sc.value());
    }

}
