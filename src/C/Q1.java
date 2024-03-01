package C;

import java.util.Scanner;

//输入两个字符串S和L，都只包含英文小写字母。S长度小于100，L长度小于500000。判定S是否是L的有效子串。
//判定规则：  S中的每个字符在L都能找到，可以不连续。
//          S在L中字符的前后顺序要和S中的顺序保持一致。

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        String L = scanner.nextLine();

        int indexS = 0;
        int indexL = 0;

        while (indexS < S.length() && indexL < L.length()) {

            if (S.charAt(indexS) == L.charAt(indexL)) {
                indexS++;
            }
            indexL++;
        }

        if (indexS == S.length()) {
            System.out.println(indexL - 1);
        } else {
            System.out.println(-1);
        }
    }
}
