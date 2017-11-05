package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public class FilterProcessor {
    public static void main(String[] args) {
        WaveForm waveForm = new WaveForm();
        Apply.process(new FilterAdapter(new LowPass(1.0)), waveForm);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveForm);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), waveForm);
    }
}
