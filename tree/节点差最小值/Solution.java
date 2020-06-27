package 节点差最小值;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * <p>
 * 自底向上
 */
public class Solution {
    public int minDiffInBST(TreeNode root) {
        return dfs(root).c;
    }

    Res dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Res left = dfs(node.left);
        Res right = dfs(node.right);

        Res res;
        if (left == null && right == null) {
            res = new Res(node.val, node.val, Integer.MAX_VALUE);
        } else if (left == null) {
            res = new Res(node.val, right.maxVal, Math.min(right.minVal - node.val, right.c));
        } else if (right == null) {
            res = new Res(left.minVal, node.val, Math.min(node.val - left.maxVal, left.c));
        } else {

            int c = Math.min(Math.min(Math.min(node.val - left.maxVal, right.minVal - node.val), left.c), right.c);
            res = new Res(left.minVal, right.maxVal, c);
        }

        return res;

    }

    class Res {
        int minVal;

        int maxVal;

        int c;

        public Res(int minVal, int maxVal, int c) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.c = c;
        }
    }

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
