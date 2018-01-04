package chapter_21.cocurrent.cyclic_barrier_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService service = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public HorseRace(int nHorses,final int pause){
        cyclicBarrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++) {
                builder.append("=");
            }
            System.out.println(builder);
            for (Horse hors : horses) {
                System.out.println(hors.tracks());
                if(hors.getStrides()>=FINISH_LINE){
                    System.out.println(hors + "won !");
                    service.shutdownNow();
                    return;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            }catch (InterruptedException e){
                System.out.println("barrier-cation sleep interrupted");
            }

        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            service.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause =200;
        new HorseRace(7,pause);
    }
}
