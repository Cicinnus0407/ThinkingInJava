package chapter_21.cocurrent.task;

import java.util.concurrent.BlockingQueue;

public class LiftoffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;

    public LiftoffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff liftOff){
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                LiftOff take = rockets.take();
                take.run();
            }

        }catch (InterruptedException e){
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
