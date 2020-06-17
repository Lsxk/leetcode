package 求和路径;

/**
 * 功能描述：
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {
    int count = 0;

    void solve(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        dfs(root, sum);
        solve(root.left, sum);
        solve(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        solve(root, sum);
        return count;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        target = target - node.val;
        if (target == 0) {
            count++;
        }
        dfs(node.left, target);
        dfs(node.right, target);
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
