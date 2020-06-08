package 删除二叉搜索树中的节点;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 要删除的节点，左子节点和右子节点均不为空
            // 找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;

            root.right = deleteNode(root.right, minNode.val);

        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMinNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
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
