package chapter_21.cocurrent.pipe;

import java.util.concurrent.*;

public class BlockingIO {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Character> receiveQueue = new LinkedBlockingQueue<>();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new SenderQueue(receiveQueue));
        service.execute(new ReceiverQueue(receiveQueue));
        TimeUnit.SECONDS.sleep(5);
        service.shutdownNow();
    }
}
