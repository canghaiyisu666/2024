package leetcode.classics150;

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
public class Q222 {


    /**
     * 计算二叉树中的节点数。
     *
     * @param root 二叉树的根节点
     * @return 二叉树中节点的数量
     */
    public static int countNodes(TreeNode root) {
        // 如二叉树为空果根节点为空，说明，返回节点数0
        if (null == root)
            return 0;
        // 如果根节点既有左子节点又有右子节点，则根节点加左右子树的节点数之和
        if (null != root.left && null != root.right) {
            return 1 + countNodes(root.left) + countNodes(root.right);
        // 如果根节点只有左子节点，則根节点加左子树的节点数
        } else if (null != root.left && null == root.right) {
            return 1 + countNodes(root.left);
        // 如果根节点只有右子节点，則根节点加右子树的节点数
        } else if (null == root.left && null != root.right) {
            return 1 + countNodes(root.right);
        // 如果根节点没有子节点，则只返回根节点本身
        } else
            return 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
