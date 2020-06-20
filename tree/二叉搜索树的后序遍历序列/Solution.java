package 二叉搜索树的后序遍历序列;

/**
 * 功能描述：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * @version 1.0.0
 * @since 2020-06-20
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }

        int root = postorder[j];

        int point = i;

        //i--first为左子树
        while (postorder[point] < root) {
            point++;
        }

        int fisrt = point;

        //point---j为右子树
        while (postorder[point] > root) {
            point++;
        }

        return point == j && helper(postorder, i, fisrt - 1) && helper(postorder, fisrt, j - 1);

    }
}
