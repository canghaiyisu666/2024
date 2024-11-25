package leetcode.classics150;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
// 如果 needle 不是 haystack 的一部分，则返回  -1 。

public class Q28 {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        int resultLength = needle.length();
        for (int i =0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.substring(i,i+resultLength).equals(needle)){
                return  i;
            }

        }

    return -1;
    }

}
