package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public class HighPass extends Filter{
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }
    @Override
    public WaveForm process(WaveForm input) {
        return input;
    }
}
