package 检查子树;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class Solution {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (isSame(t1, t2)) {
            return true;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
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
