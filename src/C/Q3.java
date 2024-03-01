package C;

//题目描述:构成指定长度字符串的个数(本题分值100)
//        给定 M(0<M≤30)个字符(a-z)，从中取出任意字符(每个字符只能用一次)拼接成长度为N (0<N≤5)的字符串要求相同的字符不能相邻，计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回0。
//
//        输入描述
//        给定的字符列表和结果字符串长度，中间使用空格(" ")拼接
//        输出描述
//        满足条件的字符串个数

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String input =sc.nextLine();
        
        String key=input.split(" ")[0];
        int length = Integer.getInteger(input.split(" ")[1]);

        System.out.println(subString(key,length));
    }

    private static int subString(String key, int length) {

        if (key.length() < length) {
            return 0;
        }
        if (key.length() == length) {
            return 1;
        }
        if (key.length() > length) {
            return 100;
        }
        return 0;
    }


}
