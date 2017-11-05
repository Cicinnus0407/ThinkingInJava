package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
