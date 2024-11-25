package HWOD.C.C200;

//  贪心歌手:贪心
//  题目描述
//        一个歌手准备从A城去B城参加演出。
//           1.按照合同，他必须在T天内赶到
//           2.歌手途经 N 座城市
//           3.歌手不能往回走
//           4.每两座城市之间需要的天数都可以提前获知。
//           5.歌手在每座城市都可以在路边卖唱赚钱,
//                  经过调研，歌手提前获知了每座城市卖唱的收入预期:
//                  如果在一座城市第一天卖唱可以赚M，后续每天的收入会减少D
//                  (第二天赚的钱是 M -D，第三天是 M-2D …)。如果收入减少到 0 就不会再少了
//          6.歌手到达后的第二天才能开始卖唱。如果今天卖过唱，第二天才能出发,
//        贪心的歌手最多可以赚多少钱?
//    输入描述
//        第一行两个数字T和 N，中间用空格隔开。
//           ·T代表总天数，0<T<1000
//           ·N代表路上经过N座城市，0<N<100
//        第二行 N+1 个数字，中间用空格隔开。代表每两座城市之间耗费的时间。
//           ·其总和 ≤T.
//        接下来 N 行，每行两个数字 M 和 D，中间用空格隔开。代表每个城市的输入预期。
//           ·0<M<1000
//           ·0<D<100
//    输出描述
//        一个数字。代表歌手最多可以赚多少钱。以回车结束。


//      具体 步骤
//        1.初始化一个优先队列，用于记录每天的收益。优先队列的特性是，队列中的元素总是按照一定的顺序排列，这里是按照收益的大小排列。
//        2.遍历每个城市，对于每个城市，计算从第一天开始每天的收益，并将其加入优先队列。
//        3.如果优先队列的大小超过了剩余的天数，那么就取出优先队列中最小的收益，并与当天的收益进行比较。
//          如果当天的收益更高，那么就将最小的收益移出队列，并将当天的收益加入队列。
//          这样做的目的是，始终保持队列中的元素是最高的收益。
//        4.当收益为0时，即当前城市的收益已经减少到0，那么就不再在该城市卖唱，跳出循环，继续处理下一个城市。
//        5.最后，将优先队列中的所有收益相加，得到最大收益，并输出。
//      核心思想是贪心算法，即每一步都做出在当前看来最好的选择，最终得到的就是全局最优解。

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q38green {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxDays = sc.nextInt(); // 总天数
        int cityNum = sc.nextInt(); // 城市数量

        int[] travelDays = new int[cityNum + 1]; // 每两座城市之间耗费的时间
        for (int i = 0; i <= cityNum; i++) {
            travelDays[i] = sc.nextInt();
        }

        int[] M = new int[cityNum]; // 每个城市的收入预期M
        int[] D = new int[cityNum]; // 每个城市的收入递减值D
        for (int i = 0; i < cityNum; i++) {
            M[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }
        sc.close();

        // 计算路上的宗总时间
        int roadDays = 0;
        for (int i = 0; i <= cityNum; i++) {
            roadDays += travelDays[i];
        }
        // 可用于卖唱赚钱的时间
        int freeDays = maxDays - roadDays;

        // 使用优先队列记录每天的收益
        PriorityQueue<Integer> earningsQueue = new PriorityQueue<>();

        // 遍历每个城市,第i个城市
        for (int i = 0; i < cityNum; i++) {
            int days = 0; // 当前城市卖唱的天数
            while ((M[i] - days * D[i]) > 0) {
                int profitToday = Math.max(M[i] - days * D[i], 0);
                if (earningsQueue.size() < freeDays) {
                    earningsQueue.add(profitToday);
                } else {
                    if ( profitToday > earningsQueue.peek()) {
                        earningsQueue.poll(); // 移除最小收益
                        earningsQueue.add(profitToday); // 加入今天的收益
                    }
                }
                if (profitToday == 0) break; // 如果收益为0，不在当前城市卖唱
                days++;
            }
        }

        // 计算总收益
        int maxEarnings = 0;
        while (!earningsQueue.isEmpty()) {
            maxEarnings += earningsQueue.poll();
        }

        System.out.println(maxEarnings);
    }

}







