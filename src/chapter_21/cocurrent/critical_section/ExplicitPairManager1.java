package chapter_21.cocurrent.critical_section;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager{

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            store(pair);
        }finally {
            lock.unlock();
        }
    }
}
