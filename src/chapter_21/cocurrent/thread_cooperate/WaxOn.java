package chapter_21.cocurrent.thread_cooperate;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax ON");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Exiting Wax On task");
    }
}
