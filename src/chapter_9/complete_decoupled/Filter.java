package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public abstract class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract WaveForm process(WaveForm input);
}
