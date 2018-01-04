package chapter_21.cocurrent.blocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOInterruption {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress address = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(address);
        SocketChannel sc2 = SocketChannel.open(address);
        Future<?> f = service.submit(new NIOBlocked(sc1));
        service.execute(new NIOBlocked(sc2));
        service.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
