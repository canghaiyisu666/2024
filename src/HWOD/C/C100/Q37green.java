package HWOD.C.C100;
//  执行任务赚积分
//   ？？？？？？？？？？？？未看
//  题目描述
//        现有N个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为1。
//        每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
//        可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
//    输入描述
//        第一行为一个数 N，表示有 N 个任务
//                  1≤ N ≤100
//        第二行为一个数T，表示可用于处理任务的时间
//                  1≤ T ≤100
//        接下来 N 行，每行两个空格分隔的整数(SLA和V)，SLA表示任务的最晚处理时间，V表示任务对应的积分。
//                  1≤ SLA ≤100
//                  0≤ V ≤100000
//    输出描述
//        可获得的最多积分

import java.util.*;

public class Q37green {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 读取任务数量
        int total_task = sc.nextInt();
        // 读取可用于处理任务的总时间
        int max_Time = sc.nextInt();

        // 创建任务列表，每个任务是一个包含两个整数的数组，分别代表最晚处理时间和积分
        List<int[]> tasks = new ArrayList<>();

        // 循环读取每个任务的信息
        for (int i = 0; i < total_task; i++) {
            // 读取任务的最晚处理时间
            int deadline = sc.nextInt();
            // 读取任务的积分
            int score = sc.nextInt();
            // 将任务添加到列表中
            tasks.add(new int[]{deadline, score});
        }
        sc.close();


        // 按照任务的最晚处理时间升序排序
        tasks.sort(Comparator.comparingInt(a -> a[0]));


        // 创建优先队列，用于存储任务的积分
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 遍历每个任务
        for (int[] task : tasks) {
            // 获取任务的最晚处理时间和积分
            int deadline = task[0], score = task[1];

            // 如果当前队列的大小小于任务的最晚处理时间，说明任务还未过期，可以添加到队列中
            // （每个任务所需要的时间固定为1）
            if (queue.size() < deadline) {
                queue.add(score);
            }
            // 如果队列不为空，且队列顶部的任务积分小于当前任务的积分
            else if (!queue.isEmpty() && queue.peek() < score) {
                // 移除队列顶部的任务
                queue.poll();
                // 将当前任务的积分添加到队列中
                queue.add(score);
            }
            // 如果当前队列的大小已经达到总时间T，说明不可以再处理新的任务
            if (queue.size() > max_Time) {
                // 移除队列顶部的任务
                queue.poll();
            }
        }

        // 初始化总积分为0
        int totalScore = 0;
        // 当队列不为空时，继续处理
        while (!queue.isEmpty()) {
            // 累加队列顶部的任务积分到总积分
            totalScore += queue.poll();
        }

        // 输出可以获得的最多积分
        System.out.println(totalScore);
    }
}
