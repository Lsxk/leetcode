package 二叉搜索树中的插入操作;

import java.util.TreeMap;

/**
 * 二叉搜索树模板
 * void BST(TreeNode root, int target) {
 *     if (root.val == target)
 *         // 找到目标，做点什么
 *     if (root.val < target)
 *         BST(root.right, target);
 *     if (root.val > target)
 *         BST(root.left, target);
 * }
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right =  insertIntoBST(root.right, val);
        }
        else {
            root.left =  insertIntoBST(root.left, val);
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
