package N叉树的前序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Node> qu = new LinkedList<Node>();
        LinkedList<Node> temp = new LinkedList<Node>();

        qu.push(root);
        while (!qu.isEmpty()) {
            Node node = qu.pollFirst();
            res.add(node.val);
            temp.clear();
            if(node.children != null && node.children.size() >0) {
                node.children.forEach(c -> temp.addFirst(c));
                qu.addAll(temp);
            }
        }
        return res;

    }

    class Node {
        public int val;

        public List<Node> children;

        public Node() {
        }
    }
}
