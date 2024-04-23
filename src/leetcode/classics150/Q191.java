package leetcode.classics150;

/**
 * 计算一个整数二进制表示中1的个数。
 */
public class Q191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }

    /**
     * 计算整数n的二进制表示中1的个数。
     * 使用循环和取模运算，逐位检查整数n的二进制表示中每个位是否为1。
     *
     * @param n 需要计算的整数
     * @return 整数n的二进制表示中1的个数
     */
    public static int hammingWeight(int n) {
        int flag = 0; // 用于计数1的个数
        while (n != 0) {
            if (n % 2 == 1) { // 检查当前位是否为1
                flag++;
            }
            n = n / 2; // 将n右移一位，检查下一位
        }
        return flag;
    }
}
