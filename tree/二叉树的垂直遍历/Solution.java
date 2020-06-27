package 二叉树的垂直遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 * <p>
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(new Node(root, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int y = node.y;
            int x = node.x;
            int val = node.node.val;
            if (map.containsKey(x)) {
                map.get(x).add(val);
            } else {
                map.put(x, new ArrayList<Integer>() {{
                    add(val);
                }});
            }

            if (node.node.left != null) {
                queue.offer(new Node(node.node.left, x - 1, y - 1));
            }
            if (node.node.right != null) {
                queue.offer(new Node(node.node.right, x + 1, y - 1));
            }

        }

        map.forEach((integer, integers) -> ans.add(integers));
        return ans;
    }

    class Node {
        TreeNode node;

        int x;

        int y;

        public Node(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    void dfs(TreeNode node, int x, int y, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }

        if (map.containsKey(y)) {
            map.get(y).add(node.val);
        } else {
            map.put(y, new ArrayList<Integer>() {{
                add(node.val);
            }});
        }

        dfs(node.left, x - 1, y - 1, map);
        dfs(node.right, x + 1, y - 1, map);
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
