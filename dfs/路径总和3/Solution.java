package 路径总和3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dfs(node, sum);

            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }

        return count;
    }

    void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (node.val == sum) {
            count++;
        }

        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
    }

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
