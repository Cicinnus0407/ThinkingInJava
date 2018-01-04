package chapter_21.cocurrent.coflict_resource;

public class  SynchronizedGenerator extends IntGenerator{

    private int currentEvenValue=0;


    @Override
    public synchronized int next() {
        ++currentEvenValue;

        Thread.yield();

        ++currentEvenValue;

        return currentEvenValue;
    }


}
