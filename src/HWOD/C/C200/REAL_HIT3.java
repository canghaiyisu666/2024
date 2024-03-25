package HWOD.C.C200;


//有一棵二叉树，每个节点由一个大写字母标识(最多26个节点）。现有两组字母，
// 分别表示后序遍历（左孩子->右孩子->父节点）和中序遍历（左孩子->父节点->右孩子）的结果，
// 请输出层次遍历的结果。

//二叉树广度优先遍历
//        GEFBIJDHCA GEBFAIDJCH  -> A B C E F D H G I J
//        CBEFDA CBAEDF-> ABDCEF

import java.util.*;


class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val) {
        this.val = val;

    }
}

public class REAL_HIT {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        char[] hou = input[0].toCharArray();
        char[] zhong = input[1].toCharArray();

        TreeNode root = buildTree(zhong, hou);
        levelOrderTraversal(root);
    }


    public static TreeNode buildTree(char[] zhong, char[] hou) {
        if (hou.length == 0) return null;

        return buildTreeHelper(zhong, 0, zhong.length, hou, 0, hou.length);
    }

    private static TreeNode buildTreeHelper(char[] inorder, int inStart, int inEnd, char[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd) return null;

        char rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        int leftSize = inIndex - inStart;
        root.left = buildTreeHelper(inorder, inStart, inIndex, postorder, postStart, postStart + leftSize);
        root.right = buildTreeHelper(inorder, inIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }


}