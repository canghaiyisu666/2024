package leetcode.classics150;

//  给你一个字符串 s，由若干单词组成，
//  单词前后用一些空格字符隔开。
//  返回字符串中 最后一个 单词的长度。
//  单词 是指仅由字母组成、不包含任何空格字符的最大子字符串 。

public class Q58 {
    public static void main(String[] args) {
        String s = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        String[] s1 = s.trim().split(" ");
        return s1[s1.length - 1].length();

    }

}
