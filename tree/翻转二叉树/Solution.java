package 翻转二叉树;

/**
 * 翻转一棵二叉树。
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tep = root.left;
            root.left = root.right;
            root.right = tep;

            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
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
