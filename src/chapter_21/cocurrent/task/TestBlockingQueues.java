package chapter_21.cocurrent.task;

import chapter_4.main;
import sun.jvm.hotspot.opto.Block;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueues {

    static void getKey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftoffRunner runner = new LiftoffRunner(queue);
        Thread thread = new Thread(runner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press   'Enter' " +"("+ msg+")" );
        thread.interrupt();
        System.out.println("Finished "+msg +" test");
    }

    public static void main(String[] args) {
//        test("LinkedBlockingQueue",new LinkedBlockingQueue<>());
        test("ArrayBlockingQueue",new ArrayBlockingQueue<>(3));
//        test("SynchronousQueue",new SynchronousQueue<>());
    }
}
