package N叉树的最大深度;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 给定一个 N 叉树，找到其最大深度。

 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class Solution
{
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int length = 0;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            length++;

            Queue<Node> child = new LinkedBlockingQueue<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.children != null && !node.children.isEmpty()) {
                    child.addAll(node.children);
                }
            }

            queue = child;
        }
        return length;
    };

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
