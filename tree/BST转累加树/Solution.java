package BST转累加树;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 自底向上
 * @version 1.0.0
 * @since 2020-06-09
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> node = new ArrayList<>();
        if (root == null) {
            return null;
        }
        inOrder(root, node);
        int sum = 0;
        for (int i = node.size() - 1; i >= 0 ; i--) {
            sum = sum + node.get(i).val;
            node.get(i).val = sum;
        }
        return root;
    }

    public void inOrder(TreeNode node, List<TreeNode> res) {
        if (node.left != null) {
            inOrder(node.left, res);
        }
        res.add(node);
        if (node.right != null) {
            inOrder(node.right, res);
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
