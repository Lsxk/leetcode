package 验证二叉搜索树;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution
{
    // TODO 需要设置左子树最大值和右子树最小值
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min)
        {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
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
