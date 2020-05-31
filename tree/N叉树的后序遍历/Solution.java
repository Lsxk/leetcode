package N叉树的后序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedBlockingDeque<Node> deque = new LinkedBlockingDeque<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        deque.push(root);

        while (!deque.isEmpty()){

            Node pop = deque.pop();
            tmp.addFirst(pop.val);
            if (pop.children != null && !pop.children.isEmpty()) {
                for (Node n : pop.children) {
                    deque.push(n);
                }
            }
        }

        res.addAll(tmp);
        return res;

    }

    class Node {
        public int val;

        public List<Node> children;

        public Node() {
        }
    }
}
