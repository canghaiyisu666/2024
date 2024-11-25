package HWOD.C.C100;

//  万能字符单词拼写: 数组字符串  哈希表
//  题目描述
//        有一个字符串数组 words 和一个字符串 chars。
//        假如可以用 chars 中的字母拼写出 words 中的某个“单词”(字符串)，
//        那么我们就认为你掌握了这个单词。
//        words 的字符仅由 a-z 英文小写字母组成，例如“abc”
//        chars 由 a-z 英文小写字母和“?"组成。
//        其中英文"?”表示万能字符，能够在拼写时当作任意一个英文字母。例如:"?"可以当作“a"等字母。
//    注意:每次拼写时，chars 中的每个字母和万能字符都只能使用一次。
//        输出词汇表 words 中你掌握的所有单词的个数。
//        没有掌握任何单词，则输出0。
//    输入描述
//        第一行:输入数组 words 的个数，记作N。
//        第二行~第N+1行:依次输入数组words的每个字符串元素
//        第N+2行:输入字符串chars
//    输出描述
//        输出一个整数，表示词汇表 words 中你掌握的单词个数
//    备注
//        1 ≤ words.length ≤ 100
//        1≤ words[i].length, chars.length ≤ 100
//        所有字符串中都仅包含小写英文字母、英文问号

import java.util.Scanner;

public class Q40blue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 创建一个扫描器用于读取输入
        int N = sc.nextInt(); // 读取输入的第一个整数，即单词的数量
        sc.nextLine();  // 消耗掉换行符

        // 创建一个字符串数组用于存储所有的单词
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine(); // 读取每一个单词
        }

        // 读取包含字母和问号的字符串
        String chars = sc.nextLine();
        sc.close();


        // 创建一个数组用于计数字母的出现次数
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            if (c != '?') {
                count[c - 'a']++; // 如果字符不是问号，则计数
            }
        }

        // 计算问号的数量    int wildcards = (int) chars.chars().filter(c -> c == '?').count();
        int qNum = 0;
        for (char i : chars.toCharArray()) {
            if (i == '?') {
                qNum++;
            }
        }

        // 初始化结果为0
        int res = 0;
        // 遍历所有的单词
        for (String word : words) {
            // 创建一个数组用于计数单词中字母的出现次数
            int[] letterCount = new int[26];
            for (char c : word.toCharArray()) {
                letterCount[c - 'a']++; // 计数单词中的字母
            }

            // 如果可以拼写单词，则结果加1
            if (canSpell(letterCount, count, qNum)) {
                res++;
            }
        }

        // 输出结果
        System.out.println(res);
    }

    // 判断是否可以拼写单词
    private static boolean canSpell(int[] wordCount, int[] count, int wildcards) {
        for (int i = 0; i < 26; i++) {
            int x = wordCount[i] - count[i];
            if (x > 0) {
                wildcards -= x; // 如果单词中的字母数量大于字符集中的字母数量，则使用问号替代
                if (wildcards < 0) {
                    return false; // 如果问号不足，则返回false
                }
            }
        }
        return true; // 如果所有的字母都可以匹配，则返回true
    }
}


