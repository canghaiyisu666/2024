package HWOD.C.C100;
//  找座位：  数组  字符串循环
//  题目描述
//        在一个大型体育场内举办了一场大型活动，由于疫情防控的需要，
//        要求每位观众的必须间隔至少一个空位才允许落座。
//        现在给出一排观众座位分布图，座位中存在已落座的观众，
//        请计算出，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
//    输入描述
//        一个数组，用来标识某一排座位中，每个座位是否已经坐人。
//        0表示该座位没有坐人，1表示该座位已经坐人。
//              1≤数组长度≤10000
//    输出描述
//        整数，在不移动现有观众座位的情况下，最多还能坐下多少名观众。

import java.util.Scanner;

public class Q12green {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        sc.close();

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '0' && (i == 0 || input[i - 1] == '0') && (i == (input.length - 1) || input[i + 1] == '0')) {
                //如果当前作为为空， 并且， 左侧和右侧也为空
                result++;
                input[i] = 1;
                i++;    //跳过下一个位置，因为当前位置已经做人。
            }
        }
        System.out.println(result);
    }
}
