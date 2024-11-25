package HWOD.C.C200;

//    员工派遣：二分查找

//  题目描述
//        某公司部门需要派遣员工去国外做项目。
//        现在，代号为x的国家和代号为y的国家分别需要 cntx 名和 cnty 名员工。
//        部门每个员工有一个员工号(1,2,3,...)，工号连续，从1开始。
//        部长派遣员工的规则:
//          规则1:从[1,k]中选择员工派遣出去
//          规则2:编号为x的倍数的员工不能去x国，编号为y的倍数的员工不能去y国。
//    问题:
//        找到最小的k，使得可以将编号在[1,K] 中的员工分配给x国和y国，且满足x国和y国的需求。
//    输入描述
//        四个整数 x，y，cntx，cnty。
//          2≤x<y≤30000
//          x和y一定是质数
//          1≤cntx, cnty< 10^9
//          cntx + cnty≤ 10^9
//    输出描述
//        满足条件的最小的k

import java.util.Scanner;

public class Q23green {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y, cntX, cntY; // 定义静态变量x, y, cntX, cntY

        x = sc.nextLong(); // 读取国家X的倍数限制
        y = sc.nextLong(); // 读取国家Y的倍数限制
        cntX = sc.nextLong(); // 读取国家X需要的员工数量
        cntY = sc.nextLong(); // 读取国家Y需要的员工数量
        sc.close(); // 关闭扫描器

        long min = cntX + cntY; // 设置员工ID的最小值，初值为两国需要的员工总数
        long max = (long) Math.pow(10, 9); // 设置员工ID的最大值

        // 通过二分查找算法找到满足条件的最小员工ID
        while (min <= max) {
            long middle = min + (max - min) / 2; // 计算中间值midID

            long noX = middle / x; // 计算在[1, middle]范围内不能去X国的员工数
            long noY = middle / y; // 计算在[1, middle]范围内不能去Y国的员工数
            long noXY = middle / (x * y); // 计算在[1, middle]范围内同时不能去X国和Y国的员工数

            long neededX = Math.max(0, cntX - (noY - noXY)); // 计算X国实际需要的员工数???????????
            long neededY = Math.max(0, cntY - (noX - noXY)); // 计算Y国实际需要的员工数?????????????
            long totalAvalible = middle - noX - noY + noXY; // 计算总共能使用的员工数

            // 判断当前middle是否满足条件
            if (neededX + neededY <= totalAvalible) {
                max = middle - 1; // 如果满足条件，降低最大ID的搜索范围
            } else {
                min = middle + 1; // 如果不满足条件，提高最小ID的搜索范围
            }
        }

        System.out.println(min); // 输出满足条件的最小员工ID

    }

}
