package chapter_21.cocurrent.inner_thread;

import java.util.concurrent.TimeUnit;

/**
 * 内部类
 */
public class InnerThread1 {
    private int countDown =5;

    private Inner inner;

    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }

        @Override
        public void run() {
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

        @Override
        public String toString() {
            return getName()+": "+countDown;
        }
    }
    public InnerThread1(String name){
        inner = new Inner(name);
    }
}
