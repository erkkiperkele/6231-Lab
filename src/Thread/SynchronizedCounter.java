package Thread;

/**
 * Created by Aymeric on 15-09-14.
 */
public class SynchronizedCounter {

    private int c = 0;

    public synchronized void increment(){
        c++;
    }
    public synchronized void decrement(){
        c--;
    }

    public int value(){
        return c;
    }
}
