package 特定深度节点链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述：
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {

        if (tree == null) {
            return null;
        }
        List<List<TreeNode>> ans = new ArrayList<>();

        List<TreeNode> temp = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                temp.add(node);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                ans.add(new ArrayList<>(temp));
                temp.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        List<ListNode> nodes = new ArrayList<>();

        for (List<TreeNode> trees : ans) {
            nodes.add(convert(trees));
        }
        return nodes.toArray(new ListNode[nodes.size()]);
    }

    public ListNode convert(List<TreeNode> treeNodes) {

        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(-1);
        dummy.next = head;
        for (TreeNode node : treeNodes) {
            head.next = new ListNode(node.val);
            head = head.next;
        }

        return dummy.next.next;
    }

    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
