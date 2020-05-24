package 二叉树的层次遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.offer(root);


        while (!queue.isEmpty()) {

            Queue<TreeNode> next =  new LinkedBlockingQueue<>();
            List<Integer> tmp = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if (poll.left != null)
                {
                    next.offer(poll.left);
                }
                if (poll.right != null) {
                    next.offer(poll.right);
                }
            }

            result.add(tmp);
            queue = next;
        }
        return result;
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
