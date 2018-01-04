package chapter_21.cocurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtExcpetion {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool(new HandleThreadFactory());
        service.execute(new ExceptionThread2());
        service.shutdown();
    }
}
