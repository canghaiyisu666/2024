package HWOD.C.C100;
//  小华地图寻宝
//  ??????????????未看
//  题目描述
//        小华按照地图去寻宝，地图上被划分成 m 行和n列的方格，横纵坐标范围分别是 [0,n-1]和 [0,m-1]。
//        在横坐标和纵坐标的数位之和不大于k的方格中存在黄金(每个方格中仅存在一克黄金)，
//        但横坐标和纵坐标数位之和大于k的方格存在危险不可进入。
//        小华从入口(0.0)进入，任何时候只能向左，右，上，下四个方向移动一格请问小华最多能获得多少克黄金?
//    输入描述
//        坐标取值范围如下:
//                  0≤m≤50
//                  0≤n≤50
//        k的取值范围如下:
//                  0≤k≤100
//        输入中包含3个字数，分别是m，n,k
//    输出描述
//        输出小华最多能获得多少克黄金

import java.util.Scanner;

public class Q59green {
    // 定义地图的行数m、列数n以及数位和限制k
    private static int m, n, k;
    // 定义一个二维数组visited，用于标记格子是否已经被访问过
    private static boolean[][] visited;

    public static void main(String[] args) {
        // 使用Scanner类读取输入
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 读取行数m
        n = sc.nextInt(); // 读取列数n
        k = sc.nextInt(); // 读取数位和限制k
        sc.close();


        visited = new boolean[m][n]; // 初始化访问标记数组

        // 从(0,0)开始进行深度优先搜索，并打印能够收集到的最大黄金数量
        System.out.println(dfs(0, 0));
    }

    // 深度优先搜索函数
    private static int dfs(int x, int y) {
        // 判断坐标(x, y)是否越界，或者已经被访问过，或者数位和大于k
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || sumOfDigits(x) + sumOfDigits(y) > k) {
            return 0; // 如果是，则返回0，表示这个格子不能访问
        }
        visited[x][y] = true; // 标记当前格子为已访问
        // 递归搜索当前格子的上下左右四个方向，并将结果累加，1表示当前格子的黄金
        return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
    }

    // 计算一个数字的数位和
    private static int sumOfDigits(int num) {
        int sum = 0; // 初始化数位和为0
        while (num > 0) { // 当数字大于0时循环
            sum += num % 10; // 取数字的最后一位加到数位和中
            num /= 10; // 去掉数字的最后一位
        }
        return sum; // 返回计算出的数位和
    }
}
