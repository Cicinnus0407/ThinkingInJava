package chapter_21.cocurrent.toast;

public class Jammer implements Runnable{

    private ToastQueue butterQueue,jamQueue;

    public Jammer(ToastQueue butterQueue, ToastQueue jamQueue) {
        this.butterQueue = butterQueue;
        this.jamQueue = jamQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = butterQueue.take();
                toast.jam();
                System.out.println(toast);
                jamQueue.put(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}
