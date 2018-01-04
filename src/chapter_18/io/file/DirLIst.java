package chapter_18.io.file;

import java.io.File;
import java.util.Arrays;

public class DirLIst {

    public static void main(String[] args) {
        File path = new File("/Users/cicinnus/Documents/JavaProject/ThinkingInJava/src/chapter_18/io/file");
        String[] list;
        if (args.length==0) {
            list = path.list();
        }
        list = path.list(new DirFilter("D.*\\.java"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
