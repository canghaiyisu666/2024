package HWOD.C.C100;

//  小朋友来自多少小区：贪心
//
//  题目描述
//        幼儿园组织活动，老师布置了一个任务:
//        每个小朋友去了解与自己同一个小区的小朋友还有几个。
//        我们将这些数量汇总到数组 garden 中。
//        请根据这些小朋友给出的信息，计算班级小朋友至少来自几个小区?
//  按照示例和说明，“计算班级小朋友至少来自几个小区?”这个问题是不正确。正确的问题应该是“计算班级里至少有几个小朋友？” **********

//    输入描述
//        输入:garden[]={2,2,3}
//           garden 数组长度最大为 999
//          每个小区的小朋友数量最多 1000 人，也就是 garden[i] 的范围为 [0,999]
//    输出描述
//        输出:7

//分析：  运用贪心
//        首先，如果两个小朋友所反馈的人数不一致，那么他们必然不可能来自同一个小区。这是非常显而易见的结论。
//        因此我们只需要考虑反馈人数相同的那些小朋友的数量即可。
//        假设存在n个小朋友均反馈有m个其他小朋友和他来自同一小区，那么小区人数应该为m+1（+1表示包含这个小朋友自己）。
//        为了使得总的小区数尽可能地少，我们会贪心地将尽可能多的小朋友安排到同一个小区里。一个小区的人数上限为m+1，因此此时所需要的小区数量为ceil(n / (m+1))。
//        这些小区所包含的小朋友数量为ceil(n ``/ (m+1)``) * (m+1)。


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q72green {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split(" ");
        sc.close();

        Map<Integer, Integer> dic = new HashMap<>();
        for (String tmp : input) {
            int val = Integer.parseInt(tmp);
            dic.put(val, dic.getOrDefault(val, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            int m = entry.getKey();
            int n = entry.getValue();
            result += Math.ceil((double)n / (m + 1)) * (m + 1);  //本行是重点,ceil函数参数必须为double，如果不是double，不报错，但是不会向上取整。
//          ans += (n / (m + 1)+1)*(m+1);   //本行逻辑是错误的， 如果输入是“0 0”结果错误，如果相除是整数，则不用加一
        }

        System.out.println(result);
    }
}