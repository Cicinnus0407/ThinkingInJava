package chapter_17.map;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedHashMap.put(null,null);
    }
}
