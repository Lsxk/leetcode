package 重建最大二叉树;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(nums[i]);
        }

        int maxValue = nums[i];
        int index = i;

        for (int k = i; k <= j; k++) {
            if (nums[k] > maxValue) {
                maxValue = nums[k];
                index = k;
            }
        }

        TreeNode node = new TreeNode(maxValue);
        node.left = helper(nums, i, index - 1);
        node.right = helper(nums, index + 1, j);

        return node;
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
