import apple.laf.JRSUIConstants;
import chapter15.border.Bounded;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Test {


    static class FixedSizeStack<T> {
        private int index = 0;
        private Object[] storage;

        public FixedSizeStack(int size) {
            storage = new Object[size];
        }

        public void push(T item) {
            storage[index++] = item;
        }

        @SuppressWarnings("uncheked")
        public T pop() {
            return ((T) storage[--index]);
        }
    }


    public static void main(String[] args) {
     Bounded bounded = new Bounded();
     Bounded bounded1 = new Bounded();
        if (bounded.equals(bounded1)) {

        }
    }

    class test{
    }


}
