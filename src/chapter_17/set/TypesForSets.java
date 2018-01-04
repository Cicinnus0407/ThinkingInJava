package chapter_17.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type){
        try {

            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class). newInstance(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return set;
    }

    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(),HashType.class);
//        test(new LinkedHashSet<>(),HashType.class);
//        test(new TreeSet<>(),TreeType.class);

        //没有定义hashCode,所以会重复值
//        test(new HashSet<>(),SetType.class);
        //没有定义hashCode,所以会重复值
//        test(new HashSet<>(),TreeType.class);
        //定义了compareTo方法,所以会去重
//        test(new TreeSet<>(),TreeType.class);
        //没有定义hashCode,所以会重复插入
//        test(new LinkedHashSet<>(),SetType.class);
        //没有定义HasCode,重复插入
//        test(new LinkedHashSet<>(),TreeType.class);
    }
}
