package leetcode.classics150;

//给定两个字符串 s 和 t ，判断它们是否是同构的。
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
// 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

import java.util.HashMap;
import java.util.Map;

public class Q205 {
    public static void main(String[] args) {
        String s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> s2m = new HashMap<Character, Character>();
        Map<Character, Character> t2m = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2m.containsKey(x) && s2m.get(x) != y) || (t2m.containsKey(y) && t2m.get(y) != x)) {
                return false;
            }
            s2m.put(x, y);
            t2m.put(y, x);
        }
        return true;

    }
}
