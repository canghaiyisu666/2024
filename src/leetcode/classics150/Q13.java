package leetcode.classics150;

//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//给定一个罗马数字，将其转换成整数。


import java.util.HashMap;
import java.util.Map;

public class Q13 {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> dic = new HashMap<String, Integer>();
        dic.put("I", 1);
        dic.put("V", 5);
        dic.put("X", 10);
        dic.put("L", 50);
        dic.put("C", 100);
        dic.put("D", 500);
        dic.put("M", 1000);

        StringBuffer sb = new StringBuffer();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            sb.append(dic.get(array[i] + "") + " "); //需要注意 ， 把char转换为String
        }

        String[] result = sb.toString().trim().split(" ");

        int sum = 0;
        for (int j = 0; j < result.length; j++) {
            if (j == result.length - 1) {
                sum += Integer.parseInt(result[j]);
                return sum;
            }
            if (Integer.parseInt(result[j]) < Integer.parseInt(result[j + 1])) {
                sum -= Integer.parseInt(result[j]);
            } else {
                sum += Integer.parseInt(result[j]);
            }
        }
        return sum;
    }
}
