package 合法二叉搜索树;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val > min && node.val < max) {
            return helper(node.left, min, node.val) && helper(node.right, node.val, max);
        }
        return false;
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
