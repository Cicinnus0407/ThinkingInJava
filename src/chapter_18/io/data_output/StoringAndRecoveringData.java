package chapter_18.io.data_output;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/cicinnus/Documents/JavaProject/ThinkingInJava/src/chapter_18/io/data_output/Data.txt");
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream= new DataOutputStream(bufferedOutputStream);
        dataOutputStream.writeUTF("中文");
        dataOutputStream.writeUTF("中文1");
        dataOutputStream.writeDouble(3.1415926);
        dataOutputStream.flush();
        dataOutputStream.close();


        FileInputStream fileInputStream=new FileInputStream("/Users/cicinnus/Documents/JavaProject/ThinkingInJava/src/chapter_18/io/data_output/Data.txt");
        BufferedInputStream bufferedReader = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedReader);
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readDouble());



    }
}
