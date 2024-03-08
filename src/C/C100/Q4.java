package C.C100;

//    题目描述:用连续自然数之和来表达整数
//        一个整数可以由连续的自然数之和来表示。
//        给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式
//
//    输入描述
//        一个目标整数T(1<=T<= 1000)
//     输出描述
//        该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为:
//        自然数个数最少的表达式优先输出
//        每个表达式中按自然数递增的顺序输出，具体的格式参见样例。
//        在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
//     ACM输入输出模式
//          如果你经常使用Leetcode,会知道letcode是不需要编写输入输出函数的。但是华为OD机考使用的是 ACM 模式，需要手动编写输入和输出.
//        所以最好在牛·客上提前熟悉这种模式。例如C++使用 cin/cout,python使用 input()/print()。javaScript使用node的 readline()和console.log()。Java使用sacnner/system.out.print()

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        if (in < 1 || in > 1000) {
            System.out.println("invaild");
        } else {
            parse(in);
        }

    }

    private static void parse(int in) {
        System.out.println(in + "=" + in);//输出数字本身作为第一个表达式

        List<String> expressions = new ArrayList<>();// 存储所有表达式的 vector

        // 枚举从 1 开始的连续自然数的个数
        for (int i = 1; i < in; i++) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            // 从第 i 个自然数开始累加
            for (int j = i ; sum < in; j++) {
                sum = sum + j;
                sb.append(j).append("+");
                // 找到了一个表达式
                if (sum == in) {    // 将表达式加入 vector
                    expressions.add(in + "=" + sb.substring(0, sb.length()-1));
                    break;
                }
            }
        }

        // 按表达式中自然数的个数排序
        Collections.sort(expressions, Comparator.comparingInt(String::length));

        // 输出所有表达式
        for (String expression : expressions) {
            System.out.println(expression);
        }

        // 输出表达式的个数
        System.out.println("Result:" + (expressions.size() + 1));

    }
}







