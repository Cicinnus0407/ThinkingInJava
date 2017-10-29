package chapter_5.static_data_init;

/**
 * Created by Cicinnus on 2017/10/29.
 */
public class Table {
    static Bowl bowl = new Bowl(1);

    public Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2("+marker+")");
    }
    static Bowl bowl2 = new Bowl(2);
}
