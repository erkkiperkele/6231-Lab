package Thread;

/**
 * Created by Aymeric on 15-09-14.
 */
public class Main {

    public static void main(String[] args) {

        SynchronizedCounter syncCounter = new SynchronizedCounter();

        OperationA operationA = new OperationA();
        OperationB operationB = new OperationB();

        operationA.setSc(syncCounter);
        operationB.setSc(syncCounter);

        Thread threadA = new Thread(operationA);
        Thread threadB = new Thread(operationB);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();

            System.out.println("The final value is: " + syncCounter.value());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
