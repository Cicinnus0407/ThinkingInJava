package chapter_21.cocurrent.join;

public class Joiner extends Thread{


    private Sleeper sleeper;

    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("终止");
        }
        System.out.println(getName()+"加入成功");
    }


}
