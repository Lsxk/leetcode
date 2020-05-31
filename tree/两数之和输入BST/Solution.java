package 两数之和输入BST;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> res = new ArrayList<>();

        helper(root, res);

        int left = 0;
        int right = res.size() - 1;

        while (left < right) {
            if (res.get(left) + res.get(right) == k) {
                return true;
            }
            if (res.get(left) + res.get(right) > k) {
                right--;
            }
            else {
                left++;
            }
        }

        return false;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
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
