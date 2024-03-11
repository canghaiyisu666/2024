package HWOD.C.C100;

// 寻找身高相近的小朋友: 数组

//    题目描述
//        小明今年升学到了小学1年级来到新班级后，发现其他小朋友身高参差不齐，
//        然后就想基于各小朋友和自己的身高差，对他们进行排序，
//        请帮他实现排序。
//    输入描述
//        第一行为正整数 h和n，0<h<200 为小明的身高，0<n<50 为新班级其他小朋友个数。
//        第二行为n个正整数，h1~hn分别是其他小朋友的身高，取值范围0<hi<200，且n个正整数各不相同。
//    输出描述
//        输出排序结果，各正整数以 空格 分割，
//        和小明身高差绝对值最小的小朋友排在前面
//        和小明身高差绝对值最大的小朋友排在后面
//        如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。

import java.util.*;

public class Q24blue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xiaoming = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> heights = new ArrayList<Integer>();
        // 读取其他小朋友的身高并添加到ArrayList中
        for (int i = 0; i < num; i++) {
            int height = sc.nextInt();
            heights.add(height);
        }
        sc.close();

        // 对ArrayList中的身高进行排序
        Collections.sort(heights, new Comparator<Integer>() {
            // 自定义比较器，根据与小明身高差的绝对值进行排序
            public int compare(Integer a, Integer b) {
                int diff_a = Math.abs(a - xiaoming);
                int diff_b = Math.abs(b - xiaoming);
                // 如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面
                if (diff_a == diff_b) {
                    return a - b;
                }
                // 否则，根据与小明身高差的绝对值进行排序
                return diff_a - diff_b;
            }
        });
        // 输出排序后的结果
        for (int i = 0; i < num; i++) {
            System.out.print(heights.get(i) + " ");
        }
    }
}




