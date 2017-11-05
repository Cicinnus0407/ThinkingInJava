package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public interface Processor {
    String name();

    Object process(Object input);
}
