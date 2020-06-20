package 分裂二叉树的最大乘积;

public class Solution {

    double max = 0;

    double sum = 0;

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum = dfs(root);
        dfs(root);
        return (int) (max % (10 ^ 9 + 7));

    }

    public double dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        double left = dfs(node.left);
        double right = dfs(node.right);

        max = Math.max(max, (sum - left) * left);
        max = Math.max(max, (sum - right) * right);

        return left + right + node.val;
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
