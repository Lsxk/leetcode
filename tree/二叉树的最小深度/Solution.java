package 二叉树的最小深度;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deepth = 1;
        Queue<TreeNode> rootQueue = new LinkedBlockingQueue<>();
        rootQueue.offer(root);

        while (!rootQueue.isEmpty()) {

            Queue<TreeNode> childQueue = new LinkedBlockingQueue<>();
            while (!rootQueue.isEmpty()) {
                TreeNode poll = rootQueue.poll();
                if (poll.left == null && poll.right == null) {
                    return deepth;
                }
                if (poll.left != null) {
                    childQueue.offer(poll.left);
                }
                if (poll.right != null){
                    childQueue.offer(poll.right);
                }
            }
            deepth++;
            rootQueue = childQueue;
        }
        return deepth;
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
