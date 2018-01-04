package chapter_21.cocurrent.pipe;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService service  = Executors.newCachedThreadPool();
        service.execute(sender);
        service.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        service.shutdownNow();
    }
}
