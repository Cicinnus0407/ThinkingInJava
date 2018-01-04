package chapter_21.cocurrent.coflict_resource;

public class  EventGenerator extends IntGenerator{

    private int currentEvenValue=0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    @Override
    public void unsynchronized() {

    }


}
