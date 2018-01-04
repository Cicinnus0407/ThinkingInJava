package chapter_21.cocurrent.new_component.countdown_latch_demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable{

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;


    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();

        }catch (InterruptedException e){
            System.out.println(this+" Interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ",id);
    }
}
