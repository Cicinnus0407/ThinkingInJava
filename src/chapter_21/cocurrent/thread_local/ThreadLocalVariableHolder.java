package chapter_21.cocurrent.thread_local;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder{
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random random = new Random(47);
        protected synchronized Integer initialValue(){
            return random.nextInt(10000);
        }
    };

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){
        return value.get();
    }

    public static void main(String[] args) {
        ExecutorService service  = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new Accessor(i));
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
