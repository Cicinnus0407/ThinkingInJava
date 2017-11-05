package chapter_8.filed_static_method;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public class FieldAccessMain {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field=" + sup.filed + " sup.getField= " + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub,field=" + sub.filed + " sub.getField= " + sub.getField() + " sub.getSuperField= " + sub.getSuperField());
    }
}
