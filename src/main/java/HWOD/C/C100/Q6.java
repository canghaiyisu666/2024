package HWOD.C.C100;

//   题目描述:密码输入检测(本题分值100)
//        给定用户密码输入流input，输入流中字符<表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，并判断密码是否满足如下的密码安全要求。
//
//   空码安全要求如下:
//        1.密码长度>=8:
//        2.密码至少需要包含1个大写字母
//        3.密码至少需要包含1个小写字母
//        4.密码至少需要包含1个数字,
//        5.密码至少需要包含1个字母和数字以外的非空白特殊字符
//        注意空串退格后仍然为空串，且用户输入的字符串不包含'’字符和空白字符。
//   输入描述
//        用一行字符串表示输入的用户数据，输入的字符串中'<"字符标识退格，用户输入的字符串不包含空白字符，例如:ABC<c89%000<
//   输出描述
//        输出经过程序处理后，输出的实际密码字符串，并输出改密码字符串是否满足密码安全要求。两者间由,分隔，例如:ABc89%00,true
//   示例1
//        输入
//            ABC<c89%000<
//        输出
//            ABc89%00,true
//        说明
//        解释:多余的C和0由于退格被去除,最终用户输入的密码为ABc89%00，且满足密码安全要求，输出true


import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringBuffer sb = new StringBuffer();

        for (char i : input.toCharArray()) {

            if (i == '<') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(i);
            }
        }
//        System.out.println(sb);

        boolean result = verify(sb);
        System.out.println(sb + "," + result);
    }

    private static boolean verify(StringBuffer sb) {

        boolean upCase = false;
        boolean lowCase = false;
        boolean num = false;
        boolean symbol = false;

        char[] tmp = sb.toString().toCharArray();

        for (char i : tmp) {
            if (Character.isUpperCase(i)) {
                upCase = true;
            } else if (Character.isLowerCase(i)) {
                lowCase = true;
            } else if (Character.isDigit(i)) {
                num = true;
            } else symbol = true;
        }
        return sb.length() > 8 && upCase && lowCase && num && symbol;

    }
}
