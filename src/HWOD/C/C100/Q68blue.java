package HWOD.C.C100;

//    精准核酸检测:  图    DFS搜索    BFS搜索

//    题目描述
//        为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
//        现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
//        现在给定一组确诊人员编号 (X1,X2,X3..Xn)在所有人当中，找出哪些人需要进行核酸检测，
//        输出需要进行核酸检测的数(注意:确诊病例自身不需要再做核酸检测)
//        需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
//            例如:A是确诊病例，A和B有接触、B和C有接触 C和D有接触，D和E有接触。
//            那么B、HWOD.C、D、E都是需要进行核酸检测的人
//    输入描述
//        第一行为总人数N
//        第二行为确证病例人员编号(确证病例人员数量<N)，用逗号隔开
//        接下来N行，每一行有N个数字，用逗号隔开，其中第(行的第)个数字表名编号i是否与编号i接触过。
//        0表示没有接触，1表示有接触
//
//        备注:
//        人员编号从0开始
//        0<N<100  0<N<1000<N<100
//    输出描述
//        输出需要做核酸检测的人数


//  解题思路
//        1.初始化一个大小为N的布尔数组 visited ，用来记录每个人是否已经被访问过(即是否已经确定需要进行核酸检测)
//        2.初始化一个大小为NxN的布尔矩阵 contacts ，用来表示人与人之间的接触情况。
//              如果 contacts[i][j]为 true ，则表示编号为i的人与编号为j的人有接触。
//        3.从输入中读取确诊病例的编号，并对每个确诊病例执行深度优先搜索(DFS):
//              *在DFS中，首先将当前节点(即当前人员编号)标记为已访问，
//              *然后遍历该节点的所有邻接节点(即与当前人员有接触的所有人)，如果邻接节点未被访问，则递归地对邻接节点执行DFS
//        4.完成DFS后，遍历 visited 数组，统计除确诊病例外的已访问节点的数量，即为需要进行核酸检测的人数。

import java.util.Arrays;
import java.util.Scanner;

public class Q68blue {

    public static void dfs(boolean[][] relation, boolean[] result, int first) {
        result[first] = true;    // 标记当前节点为已访问
        for (int i = 0; i < relation.length; i++) {
            // 如果当前节点与其他节点有接触，并且该节点未被访问过
            if (relation[first][i] == true && !result[i]) {
                dfs(relation, result, i); // 递归访问该节点
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine()); // 读取总人数
        String[] sickList = scanner.nextLine().split(","); // 读取确诊病例人员编号
        boolean[][] relation = new boolean[N][N]; // 创建接触矩阵
        boolean[] result = new boolean[N]; // 创建访问记录数组

        // 构建接触矩阵
        for (int i = 0; i < N; i++) {
            String[] row = scanner.nextLine().split(",");
            for (int j = 0; j < N; j++) {
                relation[i][j] = "1".equals(row[j]); // 将接触情况转换为布尔值存储
            }
        }
        scanner.close();

        // 对每个确诊病例执行深度优先搜索
        for (String per : sickList) {
            int index = Integer.parseInt(per);
            dfs(relation, result, index);
        }

        int count = 0; // 需要进行核酸检测的人数

        // 遍历访问记录数组，统计需要进行核酸检测的人数
        for (int i = 0; i < N; i++) {
            if (result[i]) { // 如果该人员被访问过
                // 检查该人员是否为确诊病例
                boolean isConfirmedCase = Arrays.asList(sickList).contains(String.valueOf(i));
                if (!isConfirmedCase) { // 如果不是确诊病例，则计数器加一
                    count++;
                }
            }
        }

        System.out.println(count); // 输出需要进行核酸检测的人数

    }
}




