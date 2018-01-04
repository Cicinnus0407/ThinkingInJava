package chapter_18.io.file_reader;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BufferedInputFile {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/cicinnus/Documents/JavaProject/ThinkingInJava/src/chapter_18/io/file_reader/BufferedInputFile.java");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("/Users/cicinnus/Documents/JavaProject/ThinkingInJava/src/chapter_18/io/file_reader/BufferedInputFile2.java");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        List<String> data = new LinkedList<>();
        String lineData;
        while ((lineData = bufferedReader.readLine()) != null) {
            data.add(lineData+"\n");
            bufferedWriter.write(lineData+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        Collections.reverse(data);
        System.out.println(data);



    }
}
