package chapter_21.cocurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ExceptionThread2());
        service.shutdown();
    }
}
