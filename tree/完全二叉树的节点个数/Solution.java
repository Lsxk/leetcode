package 完全二叉树的节点个数;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = getHeight(root.left, true);
        int hr = getHeight(root.right, false);

        if (hl == hr) {
            return (int) (Math.pow(2, hl) - 1);
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    private int getHeight(TreeNode root, boolean left) {
        int heigth = 0;
        if (root == null) {
            return 0;
        }
        if (left) {
            while (root != null) {
                heigth++;
                root = root.left;
            }
        }
        else {
            while (root != null) {
                heigth++;
                root = root.right;
            }
        }
        return heigth;
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
