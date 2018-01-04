package chapter_21.cocurrent.daemon_thread;


import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(140);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
//            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
//        TimeUnit.MILLISECONDS.sleep(175);
    }
}
