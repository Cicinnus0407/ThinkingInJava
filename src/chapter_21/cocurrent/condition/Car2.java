package chapter_21.cocurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car2 {
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean waxOn = false;

    public void waxed(){
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void buffed(){
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void waitingForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (!waxOn){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void watingForBuffed() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn){
                condition.await();
            }
        }finally {

            lock.unlock();
        }
    }

}
