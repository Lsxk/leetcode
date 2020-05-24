package 将有序数组转换为二叉搜索树;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution
{
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int rootIndex = nums.length / 2;

        TreeNode root = new TreeNode(nums[rootIndex]);

        int[] left = new int[rootIndex];
        int[] right = new int[nums.length - rootIndex - 1];
        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, rootIndex + 1, right, 0, right.length);

        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
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
