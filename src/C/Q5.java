package C;

//题目描述:全量和已占用字符集、字符串统计(分值100)
//      给定两个字符集合，一个是全量字符集，一个是已占用字符集，已占用字符集中的字符不能再使用,。要求输出剩余可用字符集。

//  输入描述:
//        1.输入一个字符串 一定包含@，@前为全量字符集 @后的为已占用字符集
//        2.已占用字符集中的字符一定是全量字符集中的字符
//        3.字符集中的字符跟字符之间使用英文逗号隔开
//        4.每个字符都表示为字符+数字的形式用英文冒号分隔，比如a.1标识一个a字符
//        5.字符只考虑英文字母，区分大小写
//        6.数字只考虑正整型 不超过100
//        7.如果一个字符都没被占用 @标识仍存在，例如 a:3.b:5.c:2@
//  输出描述:
//          输出可用字符集
//          不同的输出字符集之间用回车换行
//          注意: 输出的字符顺序要跟输入的一致，如下面用例不能输出b:3,a.2.c:2
//          如果某个字符已全部占用 则不需要再输出
//        ACM输入输出模式
//        如果你经常使用Leetcode,会知道letcode是不需要编写输入输出函数的。但是华为OD机考使用的是 ACM 模式，需要手动编写输入和输出。
//        所以最好在牛-客上提前熟悉这种模式。例如C++使用 cin/cout ,python使用 input()/print()。davaScript使用node的readline()和console.log()。Java 使用sacnner/system.out.print()

//  用例:
//        输入
//        a:3,b:5,c:2@a:1,b:2
//        输出
//        a:2 b:3,c:2

//说明
//        全量字符集为3个a，5个b，2个c
//        已占用字符集为1个a，2个b
//        由于已占用字符不能再使用因此剩余可用字符为2个a，3个b，2个C
//        因此输出a:2.b:3.c:2

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        String full = in.split("@")[0];
        String used = in.split("@")[1];


        Map<String, Integer> fullMap = Parse(full);
        Map<String, Integer> usedMap = Parse(used);

        StringBuffer sb = new StringBuffer();

        for (String key : fullMap.keySet()) {
            if (usedMap.containsKey(key)) {
                if (fullMap.get(key) > usedMap.get(key)) {
                    sb.append(key + ":" + (fullMap.get(key) - usedMap.get(key)) + ",");
                }
            } else {
                sb.append(key + ":" + fullMap.get(key) + ",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }


    private static Map<String, Integer> Parse(String input) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] fullList = input.split(",");

        for (String single : fullList) {
            map.put(single.split(":")[0], Integer.valueOf(single.split(":")[1]));

        }
        return map;
    }
}
