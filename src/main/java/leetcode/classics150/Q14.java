package leetcode.classics150;

//  最长公共前缀:
//  编写一个函数来查找字符串数组中的最长公共前缀。
//  如果不存在公共前缀，返回空字符串 ""

public class Q14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        int shortest = findShortest(strs);
        int i = 0;
        while (i < shortest) {
            if (jugde(strs, i)) {
                i++;
            } else break;
        }
        return strs[0].substring(0, i);
    }

    private static boolean jugde(String[] strs, int index) {
        boolean result = true;
        char tmp = strs[0].charAt(index);
        for (int j = 1; j < strs.length; j++) {
            if (strs[j].charAt(index) != tmp) {
                result = false;
            }
        }
        return result;
    }

    private static int findShortest(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
//            min = str.length() < min ? str.length() : min;
        }
        return min;
    }

}
