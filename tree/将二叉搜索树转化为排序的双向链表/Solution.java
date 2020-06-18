package 将二叉搜索树转化为排序的双向链表;

/**
 * 功能描述：
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * <p>
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    private Node first = null;

    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        last.right = first;

        first.left = last;

        return first;
    }

    public void inOrder(Node node) {
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
