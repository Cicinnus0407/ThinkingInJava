package chapter_21.cocurrent.new_component.countdown_latch_demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    static final int SIZE =10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            service.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            service.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        service.shutdown();
    }
}
