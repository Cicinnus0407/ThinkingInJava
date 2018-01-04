package chapter_21.cocurrent.simple_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread{

    private int countDown = 5;

    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
    }

    @Override
    public String toString() {
        return "#"+getName()+"("+countDown+"),";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDown==0) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new SimpleThread());

        service.shutdown();
        TimeUnit.MILLISECONDS.sleep(100);
        service.execute(new SimpleThread());

//        new SimpleThread();
    }
}
