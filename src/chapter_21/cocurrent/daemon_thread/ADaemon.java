package chapter_21.cocurrent.daemon_thread;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程会在最后一个非后台线程终止时"突然"停止
 */
public class ADaemon implements Runnable{
    @Override
    public void run() {
        System.out.println("Starting ADaemon");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("do finally");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
