package Thread;


public class HelloThread2 implements Runnable {

    @Override
    public void run(){
        System.out.println("Thread Id" + Thread.currentThread().getId());
    }

    public static void main(String[] args){
        HelloThread2 ht2 = new HelloThread2();
        Thread t = new Thread(ht2);
        t.start();

        new Thread(new HelloThread2()).start();
        new Thread(new HelloThread2()).start();
        new Thread(new HelloThread2()).start();
        new Thread(new HelloThread2()).start();

    }
}

class Semaphore{
    private int Value;

    public Semaphore(int value){
        this.Value = value;
    }

    public Semaphore(){
        this(0);
    }

    public synchronized void Wait(){
        while(this.Value <= 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println(
                        "Semaphore: Wait() ..." +
                                e.getMessage()
                );
                e.printStackTrace();
            }
        }
        this.Value--;
    }

    public synchronized void Signal()
    {
        ++ this.Value;
        notify();
    }

    public synchronized void P()
    {
        this.Wait();
    }

    public synchronized void V()
    {
        this.Signal();
    }
}
