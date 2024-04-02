package leetcode.classics150;

//  给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//  这里的 遵循 指完全匹配，
//  例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Q290 {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }


    public static boolean wordPattern(String pattern, String s) {
        Map<String, String> dic = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pattern.length(); i++) {
            if (dic.containsKey(pattern.charAt(i) + "")) {
                if (!dic.get(pattern.charAt(i) + "").equals(words[i])) {
                    return false;
                }
            }
            dic.put(pattern.charAt(i) + "", words[i]);
        }
        int dic_value_count = (int) dic.entrySet().stream().map(Map.Entry::getValue).distinct().count();
        if (dic.keySet().size() != dic_value_count) {  //value去重后， 如果和key的数量不同， 也不匹配
            return false;
        }

        return true;

    }
}
