package leetcode.classics150;

import java.util.Locale;

public class Q125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        String tmp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = tmp.toCharArray();
//        if (chars.length<2){     // 当长度为0或1时，for循环可以正常处理， 所以这里注释掉
//            return true;
//        }
        for (int i = 0, j = chars.length - 1; i < ((chars.length + 1) / 2); i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
