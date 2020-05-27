package 路径总和;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode node, int sum, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                return true;
            } else {
                return false;
            }
        }

        if (dfs(node.left, sum + node.val, target) || dfs(node.right, sum + node.val, target)) {
            return true;
        }
        return false;
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
