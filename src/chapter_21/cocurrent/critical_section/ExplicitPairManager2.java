package chapter_21.cocurrent.critical_section;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager2 extends PairManager {

    private Lock lock  = new ReentrantLock();

    @Override
    public void increment() {
        Pair tmp;
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            tmp= getPair();
        }finally {
            lock.unlock();
        }
        store(tmp);
    }
}
