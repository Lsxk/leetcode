package 二叉搜索树与双向链表;

/**
 * 功能描述：0
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    private Node first;

    private Node last;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);

        last.right = first;
        first.left = last;
        return first;

    }

    //左 头 右
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;

        inOrder(node.right);

    }

    class Node {
        public int val;

        public Node left;

        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
