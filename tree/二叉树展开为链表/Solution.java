package 二叉树展开为链表;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //找到左子树的最有节点
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }

                left.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;

            }
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
