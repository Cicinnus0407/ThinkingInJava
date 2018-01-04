package chapter_21.cocurrent.critical_section;

public class PairChecker implements Runnable{


    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: "+pm.getPair()+" checkCounter =  "+ pm.checkCounter.get();

    }
}
