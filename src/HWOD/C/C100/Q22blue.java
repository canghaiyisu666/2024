package HWOD.C.C100;

//    开源项目热度榜单
//    题目描述
//        某个开源社区希望将最近热度比较高的开源项目出一个榜单，推荐给社区里面的开发者。
//        对于每个开源项目，开发者可以进行关注(watch)、收藏(star)、fork、提issue、提交合并请求(MR)等。
//        数据库里面统计了每个开源项目关注、收藏、fork、issue、MR的数量，开源项目的热度根据这5个维度的加权求和进行排序。
//         H=(Wwatch*#watch)+(Wstar* #star)+(Wfork* #fork)+ (Wissue*#issue)+(Wmr * #mr)
//        H表示热度值
//        Wwatch、Wstar、Wfork、Wissue、Wmr分别表示5个统计维度的权重。
//        #watch、#star、#fork、#issue、#mr分别表示5个统计维度的统计值。
//        榜单按照热度值降序排序，对于热度值相等的，
//        按照项目名字转换为全小写字母后的字典序排序(a',",c…,x,y,z')。
//    输入描述
//        第一行输入为N，表示开源项目的个数，0<N<100.
//        第二行输入为权重值列表，一共5个整型值，分别对应关注、收藏、fork、issue、MR的权重，
//        权重取值0<W≤50.第三行开始接下来的 N 行为开源项目的统计维度，每一行的格式为:
//             name nr watch nr start nr fork nr issue nr mr
//        其中 name 为开源项目的名字，由英文字母组成，长度≤50，
//        其余5个整型值分别为该开源项目关注、收藏、fork、issue、MR的数量数量取值 0<nr≤1000.
//    输出描述
//        按照热度降序，输出开源项目的名字，对于热度值相等的，按照项目名字转换为全小写后的字典序排序(a'> 'b'>c>…>X>V>Z)

import java.util.*;

public class Q22blue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[] quanzhong = new int[5];
        for (int i = 0; i < 5; i++) {
            quanzhong[i] = sc.nextInt();
        }
        sc.nextLine();

        String[][] xiangmu = new String[N][2];

        for (int i = 0; i < N; i++) {
            xiangmu[i][0] = sc.next();   //项目名称。

            int hot = 0;
            for (int j = 0; j < 5; j++) {
                hot += sc.nextInt() * quanzhong[j];
            }
            xiangmu[i][1] = String.valueOf(hot);
        }
        sc.close();

        //对项目xiangmu[N][2]进行排序
        Arrays.sort(xiangmu, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int hot1 = Integer.parseInt(o1[1]);
                int hot2 = Integer.parseInt(o2[1]);
                if (hot1 != hot2) {
                    return hot2 - hot1;
                } else {
                    return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
                }
            }
        });
        for (String[] perXiangmu : xiangmu) {
            System.out.println(perXiangmu[0]);
        }


    }
}
