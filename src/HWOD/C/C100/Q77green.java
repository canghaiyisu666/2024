package HWOD.C.C100;
//  分披萨： 动态规划
//????????????未看
//  题目描述
//        "吃货"和"馋嘴"两人到披萨店点了一份铁盘(圆形)披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数个小块。
//        但是粗心的服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。
//        由于两人都想吃到最多的披萨，他们商量了一个他们认为公平的分法:从"吃货"开始，轮流取披萨。
//        除了第一块披萨可以任意选取外，其他都必须从缺口开始选。
//        他俩选披萨的思路不同。"馋嘴"每次都会选最大块的披萨，而且"吃货“知道”馋嘴"的想法。
//        已知披萨小块的数量以及每块的大小，求”吃货"能分得的最大的披萨大小的总和。
//    输入描述
//        第1行为一个正整数奇数 N，表示披萨小块数量。
//                  3≤N<500
//        接下来的第2行到第 N+1行(共 N行)，每行为一个正整数，表示第i块披萨的大小
//                  1≤i≤N
//        披萨小块从某一块开始，按照一个方向次序顺序编号为1~N
//                  每块披萨的大小范围为[1,2147483647]
//    输出描述
//        "吃货"能分得到的最大的披萨大小的总和。

import java.util.Arrays;
import java.util.Scanner;

public class Q77green {
    static int n;  // 披萨的数量
    static int[] a;  // 每块披萨的美味值
    static int[][] dp;  // 记忆化数组，用于存储已计算过的状态

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 输入披萨的数量
        a = new int[n];  // 初始化存储每块披萨美味值的数组
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();  // 输入每块披萨的美味值
        }
        sc.close();

        dp = new int[n][n];  // 初始化记忆化数组，其维度为披萨数量的平方
        for (int[] row : dp) {
            Arrays.fill(row, -1);  // 初始化记忆化数组，将所有值设为-1，表示未计算
        }

        int ans = 0;  // 初始化最大美味值为0
        // 遍历每块披萨，尝试以每块披萨作为起点计算最大美味值
        for (int i = 0; i < n; i++) {
            // 更新最大美味值，allocation函数计算从当前披萨开始的最大美味值
            ans = Math.max(ans, allocation((i + 1) % n, (i + n - 1) % n) + a[i]);
        }

        System.out.println(ans);  // 输出最多能吃到的披萨的美味值总和
    }

    static int allocation(int L, int R) {
        // 如果当前状态已经计算过，则直接返回结果
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        // 根据贪心策略，选择当前美味值较大的披萨
        if (a[L] > a[R]) {
            L = (L + 1) % n;  // 如果左边的披萨更美味，则吃掉左边的披萨
        } else {
            R = (R + n - 1) % n;  // 如果右边的披萨更美味，则吃掉右边的披萨
        }
        // 如果只剩下一块披萨，则直接返回这块披萨的美味值
        if (L == R) {
            dp[L][R] = a[L];
        } else {
            // 否则，递归计算剩下披萨的最大美味值，并更新记忆化数组
            dp[L][R] = Math.max(a[L] + allocation((L + 1) % n, R), a[R] + allocation(L, (R + n - 1) % n));
        }
        return dp[L][R];  // 返回当前状态下的最大美味值
    }
}



