package leetcode.classics150;

//回文数判断
public class Q9 {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        if (s.startsWith("-")) {
            return false;
        }
        for (int i = 0; i < ((s.length() + 1) / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
