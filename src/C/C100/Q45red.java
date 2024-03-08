package C.C100;

//    英文输入法:  数组  字符串排序循环
//    题目描述
//        主管期望你来实现英文输入法单词联想功能。
//    需求如下:
//        依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列
//        如果联想不到，请输出用户输入的单词前缀。
//    注意:
//        1.英文单词联想时，区分大小写
//        2.缩略形式如"don't”，判定为两个单词，"don”和”t”
//        3.输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
//    输入描述
//        输入为两行
//        首行输入一段由英文单词word和标点符号组成的语句str;
//        接下来一行为一个英文单词前缀pre。
//            0< word.length()<=20
//            0<str.length <= 10000
//            0< pre <= 20
//    输出描述
//        输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Q45red {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = "";
        String prefix = "";

        sentence = scanner.nextLine();

        prefix = scanner.nextLine();

        sentence = sentence.replaceAll("[^a-zA-Z]", " ");                    // 将标点符号替换为空格
        Set<String> wordSet = new TreeSet<>(); // 存储单词的集合，自动去重且按照字典序排序


        String[] words = sentence.split("\\s+");                                      //   “\s”代表一个空白符
        for (String word : words) {
            wordSet.add(word);
        }
        StringBuilder ans = new StringBuilder();
        for (String s : wordSet) { // 遍历单词集合
            if (s.startsWith(prefix)) { // 如果单词以前缀开头
                ans.append(s).append(" "); // 将单词加入答案字符串
            }
        }
        if (ans.length() > 0) { // 如果答案字符串不为空
            System.out.println(ans.toString().trim()); // 输出单词序列
        } else {
            System.out.println(prefix); // 否则输出前缀
        }

    }
}








