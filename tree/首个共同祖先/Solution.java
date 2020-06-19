package 首个共同祖先;

/**
 * 功能描述：设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * <p>
 * 3种情况：
 * 1.qp分别在左右子树   ----> root
 * 2.pq在都在左子树或右子树 ----> 使用子树继续递归
 * 3.pq有一个是root   ----> root
 *
 * @version 1.0.0
 * @since 2020-06-16
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            // 分别在左右子树
            return root;
        }
        if (left == null) {
            // 都在右子树
            return right;
        } else {
            // 都在左子树
            return left;
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
