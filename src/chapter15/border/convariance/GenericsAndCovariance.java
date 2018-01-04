package chapter15.border.convariance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsAndCovariance {


    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Jonathan extends Apple {
    }

    static class Orange extends Fruit {
    }

    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<Apple>();
        ((List<Apple>) list).add(new Apple());
        System.out.println(list.get(0));


    }

    private List<? super Object> list;
    void setData(){
    }
}
