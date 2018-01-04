package chapter_21.cocurrent.toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                jamedQueue = new ToastQueue();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Toaster(dryQueue));
        service.execute(new Butterer(dryQueue,butteredQueue));
        service.execute(new Jammer(butteredQueue,jamedQueue));
        service.execute(new Eater(jamedQueue));
        TimeUnit.SECONDS.sleep(5);
        service.shutdownNow();



    }
}
