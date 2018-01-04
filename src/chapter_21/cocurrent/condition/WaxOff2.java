package chapter_21.cocurrent.condition;

import java.util.concurrent.TimeUnit;

public class WaxOff2 implements Runnable {

    private Car2 car2;

    public WaxOff2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                car2.waitingForWaxing();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.buffed();
            }

        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
