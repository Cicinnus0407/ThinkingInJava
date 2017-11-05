package chapter_7.extend_init;

import java.util.ArrayList;

/**
 * Created by Cicinnus on 2017/10/30.
 */
public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k= " + k);
        System.out.println("j= " + j);
    }
    private static int x2= printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        ArrayList arrayList = new ArrayList();


    }
}
