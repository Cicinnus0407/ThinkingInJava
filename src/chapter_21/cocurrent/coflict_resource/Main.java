package chapter_21.cocurrent.coflict_resource;

public class Main {
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedGenerator());
    }
}
