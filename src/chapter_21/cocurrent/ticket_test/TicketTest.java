package chapter_21.cocurrent.ticket_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Ticket ticket = new Ticket();
        for (int i = 0; i < 5; i++) {
            service.execute(new TicketRunner(i,ticket));
        }
        service.shutdown();
    }
}
