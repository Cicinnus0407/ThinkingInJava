package chapter_9.complete_decoupled;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public class WaveForm {
    private static long counter;
    public static long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }

}
