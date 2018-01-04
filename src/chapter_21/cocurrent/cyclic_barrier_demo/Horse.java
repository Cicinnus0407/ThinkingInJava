package chapter_21.cocurrent.cyclic_barrier_demo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{
    private static int counter =0;
    private final int id = counter++;
    private int strides = 0;
    private static Random random = new Random(47);
    private static CyclicBarrier cyclicBarrier;

    public synchronized int getStrides(){
        return strides;
    }

    public Horse(CyclicBarrier barrier){
        cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                synchronized (this){
                    strides+=random.nextInt(3);
                }
                cyclicBarrier.await();
            }

        }catch (InterruptedException e){
            System.out.println("");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse "+ id+" ";
    }
    public String tracks(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            builder.append("*");
        }
        builder.append(id);
        return builder.toString();
    }
}
