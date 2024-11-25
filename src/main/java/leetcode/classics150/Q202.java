package leetcode.classics150;

//  编写一个算法来判断一个数 n 是不是快乐数。
//
//        「快乐数」 定义为：
//
//        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//        如果这个过程 结果为 1，那么这个数就是快乐数。
//        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>();
        while (n != 1 && !history.contains(n)) {
            history.add(n);
            n = square_sum(n);
        }
        return n == 1;
    }

    public static int square_sum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += Math.pow(tmp, 2);
            n /= 10;
        }
        return sum;
    }
}
