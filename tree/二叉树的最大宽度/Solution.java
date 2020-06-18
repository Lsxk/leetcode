package 二叉树的最大宽度;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;

        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(new Node(root, 0, 0));
        int curDepth = 0;
        int left = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.node != null) {

                queue.offer(new Node(curNode.node.left, curNode.pos * 2 + 1, curNode.depth + 1));
                queue.offer(new Node(curNode.node.right, curNode.pos * 2 + 2, curNode.depth + 1));

                if (curDepth != curNode.depth) {
                    curDepth = curNode.depth;
                    left = curNode.pos;
                }
                maxWidth = Math.max(maxWidth, curNode.pos - left + 1);
            }

        }
        return maxWidth;
    }

    class Node {
        private TreeNode node;

        private int pos;

        private int depth;

        public Node(TreeNode node, int pos, int depth) {
            this.node = node;
            this.pos = pos;
            this.depth = depth;
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
