package chapter_17.hash;


import java.util.*;

/**
 * 简单的hashMap实现
 */
public class SimpleHasMap<K,V> extends AbstractMap<K,V>{

    public static final int SIZE =997;


    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];


    @Override
    public V put(K key, V value) {
        V oldValue = null;
        //获取一个hash后的位置
        int index = Math.abs(key.hashCode()%SIZE);
        //如果所在的位置是空,则创建一个list
        if (buckets[index]==null) {
            buckets[index] = new LinkedList<>();
        }
        //同一个位置的key-value
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        //遍历相同位置的key-value集合
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            //相同键,替换原有的值
            if (iPair.getKey().equals(key)) {
                //将旧值替换为新值
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        //如果没有相同的键,则正常放入集合中
        if (!found) {
            buckets[index].add(pair);
        }
        //返回存入的value
        return oldValue;

    }

    @Override
    public V get(Object key) {
        //先将key值hash获取index,
        int index = Math.abs(key.hashCode()%SIZE);
        if(buckets[index]==null)return null;
        for (MapEntry<K, V> mapEntry : buckets[index]) {
            if (mapEntry.getKey().equals(key)) {
                return mapEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            set.addAll(bucket);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHasMap<String,String> simpleHasMap = new SimpleHasMap<>();
        simpleHasMap.put("key","value");
        simpleHasMap.put("key1","value1");
        System.out.println(simpleHasMap);
        System.out.println(simpleHasMap.get("key"));
        System.out.println(simpleHasMap.entrySet());
    }
}
