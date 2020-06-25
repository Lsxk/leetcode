package N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<Node> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();

        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {

                temp.add(node.val);

                if (node.children != null && !node.children.isEmpty()) {
                    node.children.forEach(queue::offer);
                }

            } else {
                if (!temp.isEmpty()) {
                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                }
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return ans;
    }

    class Node {
        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
