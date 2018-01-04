package chapter_21.cocurrent.toast;

import java.util.concurrent.TimeUnit;

public class Butterer implements Runnable{

    private ToastQueue dryQueue,butteredQueue;


    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.add(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Buttered interrupted");
        }
        System.out.println("Butterer off");
    }

}
