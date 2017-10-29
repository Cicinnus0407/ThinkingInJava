package chapter_5.static_data_init;

/**
 * Created by Cicinnus on 2017/10/29.
 */
public class Cupboard {
    Bowl bowl3= new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int makrer){
        System.out.println("f3("+makrer+")");
    }
    static Bowl bowl5= new Bowl(5);
}
