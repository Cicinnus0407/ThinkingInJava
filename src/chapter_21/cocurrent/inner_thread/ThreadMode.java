package chapter_21.cocurrent.inner_thread;

import java.util.concurrent.TimeUnit;

public class ThreadMode {
    private int countDown =5;
    private Thread t;
    private String name;
    public ThreadMode(String name){
        this.name = name;
    }

    public void runTask(){
        if (t == null) {
            t = new Thread(name){

                @Override
                public void run() {
                    try {

                        while (true){
                            System.out.println(this);
                            if (--countDown==0) {
                                return;
                            }
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
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
}
