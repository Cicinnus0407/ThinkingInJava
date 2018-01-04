package chapter_21.cocurrent.producer_consumer;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable{

    private Restaurant restaurant;
    private int count=0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal!=null){
                        //等待食物被消费
                        wait();
                    }
                }
                if (++count==10) {
                    restaurant.service.shutdownNow();
                }
                System.out.println("Order up");
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }
}
