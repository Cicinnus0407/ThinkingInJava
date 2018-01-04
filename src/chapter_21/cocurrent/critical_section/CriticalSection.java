package chapter_21.cocurrent.critical_section;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    static void testApproaches(PairManager pairManager1,PairManager pairManager2){
        ExecutorService service = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pairManager1),
                pm2= new PairManipulator(pairManager2);

        PairChecker pairChecker1 = new PairChecker(pairManager1),
                pairChecker2 = new PairChecker(pairManager2);

        service.execute(pm1);
        service.execute(pm2);
        service.execute(pairChecker1);
        service.execute(pairChecker2);


        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm1"+pm1+"\npm2"+pm2);
        System.exit(0);

    }

    public static void main(String[] args) {
        PairManager pman1 = new PairManager1(),
                paman2 = new PairManager2();
        testApproaches(pman1,paman2);
    }
}
