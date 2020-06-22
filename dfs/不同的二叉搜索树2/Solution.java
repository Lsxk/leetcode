package 不同的二叉搜索树2;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return dfs(1, n);
    }

    /**
     * 以start-end的数组组成的二叉搜索树的个数
     *
     * @param start
     * @param end
     * @return
     */
    public LinkedList<TreeNode> dfs(int start, int end) {

        LinkedList<TreeNode> allTrees = new LinkedList<>();

        /*if (start == end) {
            //只有一个节点,或者没有节点
            return new TreeNode(start);
        }*/
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left = dfs(start, i - 1);
            LinkedList<TreeNode> right = dfs(i + 1, end);
            // connect left and right trees to the root i
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
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
