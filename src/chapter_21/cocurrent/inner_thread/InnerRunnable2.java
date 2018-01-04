package chapter_21.cocurrent.inner_thread;

import java.util.concurrent.TimeUnit;

public class InnerRunnable2 {
    private int countDown =5;
    private Thread t;

    public InnerRunnable2(String name){
        t = new Thread(name){
            @Override
            public void run() {
                try {
                    System.out.println(this);
                    if (--countDown==0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName()+": "+countDown;
            }
        };
        t.start();
    }
}
