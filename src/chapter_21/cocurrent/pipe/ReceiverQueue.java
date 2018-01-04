package chapter_21.cocurrent.pipe;

import java.util.concurrent.BlockingQueue;

public class ReceiverQueue implements Runnable {

    private BlockingQueue queue;

    public ReceiverQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始接收");
            while (true) {

                Character c = (Character) queue.take();
                System.out.println(c + ", ");

            }
        } catch (InterruptedException e) {
            System.out.println("接收中断..");
        }
        System.out.println("结束接收");
    }
}
