package chapter_21.cocurrent.pipe;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SenderQueue implements Runnable{

    private BlockingQueue<Character> queue;

    private Random random = new Random(47);

    public SenderQueue(BlockingQueue<Character> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            System.out.println("开始发送");
            while (true){
            for(char x='A';x<'z';x++){
                    queue.put(x);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));

            }
        } } catch (InterruptedException e) {
            System.out.println("发送中断..");
        }
        System.out.println("结束发送");
    }
}
