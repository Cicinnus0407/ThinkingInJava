package chapter_21.cocurrent.join;

import java.util.concurrent.TimeUnit;

public class Sleeper extends Thread{

    private int duration;

    public Sleeper(String name,int duration) {
        super(name);
        this.duration = duration;
        start();
    }



    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+"was interrupted "+"isInterrupted()"+isInterrupted());
            return;
        }
        System.out.println(getName()+"has awakened");
    }


}
