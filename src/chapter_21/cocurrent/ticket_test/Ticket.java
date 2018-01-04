package chapter_21.cocurrent.ticket_test;

public class Ticket {
    private int total = 50;


    public volatile boolean isSoldOut = false;


    public synchronized int decrease() {
        return total -= 1;
    }

    public int getCount() {
        return total;
    }
}
