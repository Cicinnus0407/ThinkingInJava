package chapter_4;

/**
 * Created by Cicinnus on 2017/10/15.
 */
public class Fibonacci {


    /**
     * 输出长度为n的斐波那契数
     * <p>
     * 1 1 2 3 5 8
     *
     * @param length
     */
    public static void printNum(int length) {
        //一共输出length个数

        if (length <= 2) {
            System.out.println("1,1");
        } else {
            //超过3个数,每一个数都是前两个数的和
            int current = 0;
            int pre = 1;
            int next = 1;
            for (int i = 1; i <=
                    length; i++) {
                if (i < 3) {
                    current = pre = next;
                } else {
                    current = pre + next;
                    pre = next;
                    next = current;
                }
                System.out.print(current + ",");

            }
        }
    }
}
