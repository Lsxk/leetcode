package 对称二叉树;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的
 */
public class Solution
{
    //左树的左子树和右树的右子树相等、左树的右子树和右树的左子树相等
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }

    /**
     * 判断两个树为镜像
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null)
        {
            return true;
        }

        if (tree1 != null && tree2 != null && tree1.val == tree2.val) {
            return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
        }
        return false;
    }

    /***
     * 迭代版本
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean isMirrorIt(TreeNode tree1, TreeNode tree2) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree1);
        stack.push(tree2);

        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            TreeNode pop1 = stack.pop();

            if (pop == null && pop1 == null) {
                continue;
            }
            if (pop==null) {
                return false;
            }
            if (pop1 == null) {
                return false;
            }
            if (pop.val != pop1.val) {
                return false;
            }

            stack.push(pop.left);
            stack.push(pop1.right);

            stack.push(pop.right);
            stack.push(pop1.left);
        }

        return true;
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
