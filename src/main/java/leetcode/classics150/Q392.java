package leetcode.classics150;

import java.util.Arrays;

//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
public class Q392 {
    public static void main(String[] args) {
        String s = "", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == ""||s.equals("")) {
            return true;
        }
        char[] s_tmp = s.toCharArray();
        char[] t_tmp = t.toCharArray();
        for (int i = 0; i < s_tmp.length; i++) {
            for (int j = 0; j < t_tmp.length; j++) {
                if (s_tmp[i] == t_tmp[j]) {
                    if (i == s_tmp.length - 1) {
                        return true;
                    }
                    t_tmp = Arrays.copyOfRange(t_tmp, j + 1, t_tmp.length);
                    break;
                }
                if (j == t_tmp.length - 1 && i != s_tmp.length - 1) {
                    return false;
                }
            }
        }
        return false;
    }
}
