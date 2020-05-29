package 二叉树的锯齿形层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-05-28
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean orderLeft = true;
        LinkedList<Integer> temp = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                if (!orderLeft) {
                    temp.offerFirst(node.val);
                } else {
                    temp.offerLast(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                // 一层结束
                orderLeft = !orderLeft;
                res.add(temp);
                temp = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return res;

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



