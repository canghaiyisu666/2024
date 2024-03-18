package HWOD.C.C100;


//  最长子字符串的长度:  字符串

//  题目描述
//        给你一个字符串s，字符串s首尾相连成一个环形 ，请你在环中找出'0 字符出现了偶数次最长子字符串的长度。
//    输入描述
//        输入是一串小写字母组成的字符串
//      备注
//        1  <= s.length <= 5x10^5
//        s 只包含小写英文字母
//    输出描述
//        输出是一个整数

import java.util.Scanner;

public class Q11green {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // 将输入的字符串转换为字符数组
        char[] chrs = input.toCharArray();


        // 获取字符串的长度
        int len = chrs.length;
        // 初始化'o'字符的计数器
        int num_o = 0;
        // 遍历字符数组，统计'o'字符的数量
        for (char chr : chrs) {
            if (chr == 'o') {
                num_o += 1;
            }
        }

        // 如果'o'字符出现的次数是偶数，则输出字符串的长度
        if (num_o % 2 == 0) {
            System.out.println(len);
        } else {
            // 如果'o'字符出现的次数是奇数，则输出字符串长度减1
            System.out.println(len - 1);
        }

        // 如果"o'字符的数量是偶数，那么就输出字符串的长度;
        // 如果'o字符的数量是奇数，那么就输出字符串长度减1，
        // 因为字符串是环形的，只需要删除其中一个0然后就是偶数次最长子串。


    }
}


