package 最大BST子树;

/**
 * 功能描述：
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
 * <p>
 * 注意:
 * 子树必须包含其所有后代
 * <p>
 * 还是自底向上吧
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    Res dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Res left = dfs(node.left);
        Res right = dfs(node.right);

        Res res;
        int father = node.val;

        if (left == null && right == null) {
            // 左右子树为空
            max = Math.max(1, max);
            res = new Res(true, father, father, 1);
        } else if (left == null) {
            // 左子树为空，需判断右子树
            if (right.isBst && father < right.min) {
                max = Math.max(right.count + 1, max);
                res = new Res(true, father, right.max, right.count + 1);
            } else {
                res = new Res(false, father, father, right.count);
            }
        } else if (right == null) {
            if (left.isBst && father > left.max) {
                max = Math.max(left.count + 1, max);
                res = new Res(true, left.min, father, left.count + 1);
            } else {
                res = new Res(false, father, father, left.count);
            }
        } else {
            // 左右子树均不为空
            if (left.isBst && right.isBst && father > left.max && father < right.min) {
                max = Math.max(max, left.count + right.count + 1);
                res = new Res(true, left.min, right.max, left.count + right.count + 1);
            } else {
                res = new Res(false, father, father, left.count + right.count);
            }
        }

        return res;

    }

    class Res {
        private boolean isBst;

        private int min;

        private int max;

        private int count;

        public Res(boolean isBst, int min, int max, int count) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.count = count;
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
