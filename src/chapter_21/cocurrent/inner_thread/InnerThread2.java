package chapter_21.cocurrent.inner_thread;

import java.util.concurrent.TimeUnit;

/**
 * 匿名内部类
 */
public class InnerThread2 {
    private int countDown = 5;

    private Thread t;

    public InnerThread2(String name){
        t = new Thread(name){
            @Override
            public void run() {
                while (true){
                    System.out.println(this);
                    if (--countDown==0) {
                        return;
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public String toString() {
                return getName()+": "+countDown;
            }
        };
        t.start();
    }
}
