package chapter_21.cocurrent.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
     Meal meal;
    ExecutorService service= Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        service.execute(chef);
        service.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
