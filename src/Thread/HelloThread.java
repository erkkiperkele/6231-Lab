package Thread;


public class HelloThread extends Thread{



    public void run(){
        System.out.println("Hello World " + this.getId());
    }

    public static void main(String[] args){
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();
        (new HelloThread()).start();

    }
}
