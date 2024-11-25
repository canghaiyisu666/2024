package HWOD.C.C100;

//生成哈夫曼树 ： 树优先级队列

//  题目描述
//        给定长度为n   [n] 的无序的数字数组，每个数字代表二叉树的叶子节点的权值，数字数组的值均大于等于111。
//        请完成一个函数，根据输入的数字数组，生成哈夫曼树，并将哈夫曼树按照中序遍历输出。
//        为了保证输出的二叉树中序遍历结果统一，增加以下限制:
//        又树节点中，左节点权值小于等于右节点权值，根节点权值为左右节点权值之和。
//        当左右节点权值相同时，左子树高度高度小于等于右子树。
//    注意:
//            所有用例保证有效，并能生成哈夫曼树提醒:哈夫曼树又称最优二叉树，是一种带权路径长度最短的一叉树。
//            所谓树的带权路径长度，就是树中所有的叶结点的权值乘上其到根结点的路径长度
//            (若根结点为 000 层，叶结点到根结点的路径长度为叶结点的层数)
//    输入描述
//              例如:由叶子节点5 15 40 30 10 生成的最优二叉树如下图所示，
//               该树的最短带权路径长度为 40*1+30*2+15*3+5*4+10*4=205
//    输出描述
//              输出一个哈夫曼的中序遍历数组，数值间以空格分隔


import java.util.PriorityQueue;
import java.util.Scanner;

public class Q67green {
    public static void main(String[] args) {
        // 创建Scanner对象读取输入
        Scanner sc = new Scanner(System.in);
        // 读取第一个数字，表示后续将输入多少个数字
        int n = sc.nextInt();
        // 创建数组存储输入的数字
        int[] nums = new int[n];
        // 循环读取输入的数字并存储到数组中
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 关闭Scanner对象
        sc.close();

        // 构建哈夫曼树，并返回根节点
        Node root = buildTree(nums);   //用debug模式可以查看返回的树的详细结构，根据树的生成算法， 选择优先级队列，每次弹出两个最小值，来生成父节点,非常的巧妙。

        // 使用StringBuilder来构建输出结果
        StringBuilder result = new StringBuilder();

        // 对哈夫曼树进行中序遍历，并将结果存储到result中
        mid_Order(root, result);

        // 输出结果，并去除末尾的空格
        System.out.println(result.toString().trim());
    }

    // 定义Node类，用于构建哈夫曼树的节点
    private static class Node implements Comparable<Node> {
        int value; // 节点存储的数值
        Node left; // 节点的左子节点
        Node right; // 节点的右子节点

        // 构造函数，初始化节点的数值
        Node(int value) {
            this.value = value;
        }

        // 实现Comparable接口的compareTo方法，用于比较节点的数值大小
        @Override
        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    // 构建哈夫曼树的方法
    private static Node buildTree(int[] values) {
        // 创建优先队列，用于存储节点并按数值大小排序
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 将输入的每个数值作为节点加入到优先队列中
        for (int value : values) {
            pq.add(new Node(value));
        }
        // 循环处理，直到优先队列中只剩下一个节点
        while (pq.size() > 1) {
            // 弹出两个数值最小的节点
            Node left = pq.poll();
            Node right = pq.poll();
            // 创建新节点，其数值为两个子节点数值之和
            Node parent = new Node(left.value + right.value);
            // 设置新节点的左右子节点
            parent.left = left;
            parent.right = right;
            // 将新节点加入到优先队列中
            pq.add(parent);
        }
        // 返回优先队列中剩下的最后一个节点，即哈夫曼树的根节点
        return pq.poll();
    }

    // 中序遍历哈夫曼树的方法
    private static void mid_Order(Node root, StringBuilder result) {
        // 如果当前节点不为空，则进行遍历
        if (root != null) {
            // 递归遍历左子树
            mid_Order(root.left, result);
            // 访问当前节点，将数值加入到结果中
            result.append(root.value).append(" ");
            // 递归遍历右子树
            mid_Order(root.right, result);
        }
    }

}

