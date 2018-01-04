package chapter_21.cocurrent.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car2 car2 = new Car2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new WaxOff2(car2));
        service.execute(new WaxOn2(car2));
        TimeUnit.SECONDS.sleep(5);
        service.shutdownNow();
    }
}
