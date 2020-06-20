package 从上到下打印二叉树3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-19
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        boolean left = true;

        Queue<TreeNode> queue = new LinkedList<>();


        LinkedList<Integer> temp = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {

                if (left) {
                    temp.addLast(curNode.val);
                } else {
                    temp.addFirst(curNode.val);
                }
                TreeNode leftNode = curNode.left;
                TreeNode rightNode = curNode.right;

                if (leftNode != null) {
                    queue.offer(leftNode);
                }
                if (rightNode != null) {
                    queue.offer(rightNode);
                }

            } else {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                left = !left;
                res.add(new ArrayList<>(temp));
                temp.clear();
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
