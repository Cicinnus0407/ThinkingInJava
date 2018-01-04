package chapter_21.cocurrent.critical_section;

public class PairManager1 extends PairManager{
    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}
