package chapter_21.cocurrent.daemon_thread;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
