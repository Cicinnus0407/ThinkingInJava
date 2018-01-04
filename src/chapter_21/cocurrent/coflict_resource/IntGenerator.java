package chapter_21.cocurrent.coflict_resource;

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    public  void unsynchronized(){}

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
