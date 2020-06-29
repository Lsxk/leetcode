package 查找两颗二叉搜索树之和;

/**
 * 功能描述：
 * 给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 * <p>
 * 如果可以找到返回 True，否则返回 False。
 *
 * @version 1.0.0
 * @since 2020-06-28
 */
public class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        if (search(root2, Integer.MIN_VALUE, Integer.MAX_VALUE, target - root1.val)) {
            return true;
        }
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    public boolean search(TreeNode root, int min, int max, int target) {
        if (root == null) {
            return false;
        }
        if (target == root.val) {
            return true;
        }
        if (target > max || target < min) {
            return false;
        }
        if (target > root.val) {
            return search(root.right, root.val, max, target);
        }
        return search(root.left, min, root.val, target);

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
