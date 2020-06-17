package 子树的最大平均值;

/**
 * 功能描述：
 * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
 * <p>
 * 子树是树中的任意节点和它的所有后代构成的集合。
 * <p>
 * 树的平均值是树中节点值的总和除以节点数
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {

    float max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    Res dfs(TreeNode node) {
        if (node == null) {
            return new Res(0, 0);
        }

        Res left = dfs(node.left);
        Res right = dfs(node.right);

        int curSum = node.val + left.curSum + right.curSum;
        int curSize = 1 + left.curSize + right.curSize;

        max = Math.max(max, (float) curSum / curSize);

        return new Res(curSum, curSize);
    }

    class Res {
        int curSum;

        int curSize;

        public Res(int curSum, int curSize) {
            this.curSum = curSum;
            this.curSize = curSize;
        }
    }

    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
