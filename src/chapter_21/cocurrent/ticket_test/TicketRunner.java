package chapter_21.cocurrent.ticket_test;

public class TicketRunner implements Runnable {

    private Ticket ticket;
    private final int id;

    public TicketRunner(int id, Ticket ticket) {
        this.id = id;
        this.ticket = ticket;
    }

    @Override
    public void run() {


        while (!ticket.isSoldOut) {
            int left = ticket.decrease();
            if (left == 0) {
                ticket.isSoldOut = true;
            }
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return "Thread " + id + " selling ticket " + ticket.getCount();
    }
}
