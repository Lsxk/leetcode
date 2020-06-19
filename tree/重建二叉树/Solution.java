package 重建二叉树;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;

        for (rootIndex = 0; rootIndex < inorder.length; rootIndex++) {
            if (rootVal == inorder[rootIndex]) {
                break;
            }
        }

        // TODO 数组长度为0

        int leftLength = rootIndex;
        int rightLength = preorder.length - rootIndex - 1;
        int[] preOrderLeft = new int[leftLength];
        int[] inOrderLeft = new int[leftLength];
        int[] preOrderRight = new int[rightLength];
        int[] inOrderRight = new int[rightLength];

        System.arraycopy(preorder, 1, preOrderLeft, 0, leftLength);
        System.arraycopy(preorder, leftLength + 1, preOrderRight, 0, rightLength);

        System.arraycopy(inorder, 0, inOrderLeft, 0, leftLength);
        System.arraycopy(inorder, leftLength + 1, inOrderRight, 0, rightLength);

        root.left = buildTree(preOrderLeft, inOrderLeft);
        root.right = buildTree(preOrderRight, inOrderRight);

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
