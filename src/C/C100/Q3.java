package C.C100;

//题目描述:构成指定长度字符串的个数(本题分值100)
//        给定 M(0<M≤30)个字符(a-z)，从中取出任意字符(每个字符只能用一次)拼接成长度为N (0<N≤5)的字符串要求相同的字符不能相邻，计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回0。
//
//        输入描述
//        给定的字符列表和结果字符串长度，中间使用空格(" ")拼接
//        输出描述
//        满足条件的字符串个数

import java.util.HashSet;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String key = input.split(" ")[0];
        int length = Integer.parseInt(input.split(" ")[1]);

        // 调用countDistinctStrings方法计算满足条件的不同字符串的数量
        int count = subString(key, length);
        // 输出计算结果
        System.out.println(count);
    }


    // 计算满足条件的不同字符串的数量
    public static int subString(String key, int length) {
        // 创建一个HashSet来存储不同的字符串
        HashSet<String> set = new HashSet<>();
        // 创建一个boolean数组来标记字符串中的字符是否已经被使用
        boolean[] used = new boolean[key.length()];
        // 调用generateDistinctStrings方法生成满足条件的不同字符串
        generateDistinctStrings(key, length, "", set, used);
        // 打印生成的所有不同的字符串
        for (String str1 : set) {
            System.out.println(str1);
        }
        // 返回不同字符串的数量
        return set.size();
    }

    // 递归生成满足条件的不同字符串
    public static void generateDistinctStrings(String str, int length, String current, HashSet<String> set, boolean[] used) {
        // 当生成的字符串长度等于指定长度时，将其加入到HashSet中
        if (current.length() == length) {
            set.add(current);
            return;
        }

        // 遍历字符串中的字符
        for (int i = 0; i < str.length(); i++) {
            // 判断字符是否已经被使用，或者当前字符与前一个字符相同

            if (used[i] || (current.length() > 0 && current.charAt(current.length() - 1) == str.charAt(i))) {
                continue; // 如果字符已被使用或与前一个字符相同，则跳过当前字符
            }
            used[i] = true; // 标记当前字符为已使用
            // 递归调用生成下一个字符
            generateDistinctStrings(str, length, current + str.charAt(i), set, used);
            used[i] = false; // 取消标记当前字符的使用状态，以便下一次遍历
        }
    }
}














