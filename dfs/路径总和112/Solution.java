package 路径总和112;

/**
 * 功能描述：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * @version 1.0.0
 * @since 2020-06-28
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    public boolean helper(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return node.val == sum;
        }
        boolean left = false;
        if (node.left != null) {
            left = helper(node.left, sum - node.val);
        }

        boolean rigth = false;
        if (node.right != null) {
            rigth = helper(node.right, sum - node.val);
        }

        return left || rigth;

    }

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
