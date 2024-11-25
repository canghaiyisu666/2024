package HWOD.C.C100;

//  最多购买宝石数目:  数组前缀和

//  题目描述
//        橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为 gems[i]
//                0 ≤ i <n
//                n=gems.length
//        宝石可同时出售0个或多个，如果同时出售多个，则要求出售的宝石编号连续;
//        例如客户最大购买宝石个数为m，购买的宝石编号必须为:gems[i]，gems[i+1]，…，gems[i+m-1]
//        0≤i<n
//        m≤n
//        假设你当前拥有总面值为 value 的钱，请问最多能购买到多少个宝石，如无法购买宝石，则返回0,
//    输入描述
//        第一行输入n，参数类型为int，取值范围:[0,10^6]，表示橱窗中宝石的总数量
//        之后n行分别表示从第0个到第n-1个宝石的价格，
//        即 gems[0]到 gems[n-1]的价格，类型为int，取值范围:(0.1000].
//        之后一行输入v，类型为int，取值范围:[0,10^9]，表示你拥有的钱。
//    输出描述
//        输出int类型的返回值，表示最大可购买的宝石数量。

import java.util.Scanner;

public class Q38green_HIT1 {
    public static void main(String[] args) {
        // 创建一个 Scanner 对象来读取输入
        Scanner sc = new Scanner(System.in);
        // 读取宝石的数量
        int n = sc.nextInt();
        // 创建一个数组来存储每个宝石的价格
        int[] gems = new int[n];
        // 读取每个宝石的价格
        for (int i = 0; i < n; i++) {
            gems[i] = sc.nextInt();
        }
        // 读取你拥有的钱的总面值
        int maxMoney = sc.nextInt();
        sc.close();

        // 初始化滑动窗口的左右边界和窗口内宝石的总价
        int left = 0, right = 0, sum = 0;
        // 初始化最大可购买的宝石数量
        int max = 0;
        // 当滑动窗口的右边界没有超过宝石数量时，继续循环
        while (right < gems.length) {
            // 将右边界的宝石价格加到总价中
            sum += gems[right];
            // 当总价超过你拥有的钱时，将左边界的宝石价格从总价中减去，并将左边界向右移动
            while (sum > maxMoney) {
                sum -= gems[left];
                left++;
            }
            // 更新最大可购买的宝石数量
            max = Math.max(max, right - left + 1);
            // 将右边界向右移动
            right++;
        }
        // 输出最大可购买的宝石数量
        System.out.println(max);
    }
}


