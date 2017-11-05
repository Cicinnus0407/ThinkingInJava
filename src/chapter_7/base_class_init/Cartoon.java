package chapter_7.base_class_init;

/**
 * Created by Cicinnus on 2017/10/29.
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
