package leetcode.classics150;

//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//        单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
public class Q151 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");  // s 为要分隔的字符串
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i > -1; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}
