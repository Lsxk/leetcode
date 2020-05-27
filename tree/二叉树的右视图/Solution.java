package 二叉树的右视图;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能描述：
 * 二叉树的层序遍历
 * @version 1.0.0
 * @since 2020-05-27
 */
public class Solution {


    public List<Integer> rightSideView(TreeNode root) {
        LinkedBlockingDeque<TreeNode> father = new LinkedBlockingDeque<>();
        LinkedBlockingDeque<TreeNode> child = new LinkedBlockingDeque<>();

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        father.offer(root);
        res.add(root.val);


        while (!father.isEmpty()) {
            TreeNode f = father.poll();

            TreeNode left = f.left;
            TreeNode right = f.right;

            if (left != null) {
                child.offer(left);
            }
            if (right != null) {
                child.offer(right);
            }

            if (father.isEmpty() && !child.isEmpty()) {

                res.add(child.getLast().val);
                father = child;
                child = new LinkedBlockingDeque<>();
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
