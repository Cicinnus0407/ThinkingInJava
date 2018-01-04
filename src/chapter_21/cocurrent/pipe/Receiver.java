package chapter_21.cocurrent.pipe;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable {

    private PipedReader reader;

    public Receiver(Sender sender) throws IOException {
        reader = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read : " + ((char) reader.read()) + ", ");
            }
        } catch (IOException e) {
            System.out.println("Receiver rea exception");
        }
    }
}
