package chapter_21.cocurrent.toast;

public class Eater implements Runnable{

    private ToastQueue queue;

    private int count = 0;

    public Eater(ToastQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = queue.take();
                if (toast.getId()!=count++||toast.getStatus()!= Toast.Status.JAMMED) {
                    System.out.println(">>>>>ERROR"+toast);
                    System.exit(1);
                }else {
                    System.out.println("Chomp! "+ toast);
                }

            }
        }catch (InterruptedException e){
            System.out.println("Enter interrupted");
        }
        System.out.println("Eater off");
    }
}
