package chapter_21.cocurrent.exception;

public class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by"+thread);
        System.out.println("eh = "+thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
