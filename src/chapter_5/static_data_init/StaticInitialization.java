package chapter_5.static_data_init;

/**
 * Created by Cicinnus on 2017/10/29.
 * static变量,成员变量,构造函数的初始化顺序demo
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main()");
        new Cupboard();
        System.out.println("Create new Cupboard in main()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
