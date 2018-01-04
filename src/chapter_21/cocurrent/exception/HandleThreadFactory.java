package chapter_21.cocurrent.exception;

import java.util.concurrent.ThreadFactory;

public class HandleThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"creating new Thread");
        Thread thread = new Thread(r);
        System.out.println("created "+thread);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+thread.getUncaughtExceptionHandler());
        return thread;
    }
}
