package chapter_8.filed_static_method;

/**
 * Created by Cicinnus on 2017/11/5.
 */
public class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;

    }

    public int getSuperField() {
        return super.getField();
    }

}
