package 在二叉树中分配硬币;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftReq = dfs(root.left);
        int rightReq = dfs(root.right);
        ans += Math.abs(leftReq) + Math.abs(rightReq);

        return root.val + leftReq + rightReq - 1;
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
