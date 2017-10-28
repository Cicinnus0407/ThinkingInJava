package chapter_4;

import java.util.Arrays;

/**
 * Created by Cicinnus on 2017/10/28.
 */
public class VampireNumber {


    /**
     * 所有4位数的吸血鬼数
     */
    public static void printVampireNumberLimitIn10000() {
        String[] strVampire, strNum;
        for (int i = 10; i < 100; i++) {
            //第二个循环从i+1开始,保证不会有对二个乘数大于第一个,导致出现重复的结果
            for (int j = i + 1; j < 100; j++) {
                int vampireNum = i * j;
                if (vampireNum < 1000 || vampireNum > 9999) {
                    //小于1000或者大于9999跳过
                    continue;
                }
                //将两个数字转为String后排序
                strVampire = String.valueOf(vampireNum).split("");
                strNum = (String.valueOf(i) + String.valueOf(j)).split("");
                //排序
                Arrays.sort(strVampire);
                Arrays.sort(strNum);
                //对比两个字符串是否相等,
                if (Arrays.equals(strVampire, strNum)) {
                    //输出值
                    System.out.println(i + " * " + j + " = " + vampireNum);
                }
            }
        }
    }

}
