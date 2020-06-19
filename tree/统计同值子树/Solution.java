package 统计同值子树;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);


        node0.left = node1;
        node0.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

        System.out.println(s.countUnivalSubtrees(node0));
    }

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    public Res dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Res left = dfs(node.left);
        Res right = dfs(node.right);
        Res res;
        if (left == null && right == null) {
            count++;
            res = new Res(true, node.val);
        } else if (left == null) {
            if (right.equals && (right.val == node.val)) {
                count++;
                res = new Res(true, node.val);
            } else {
                res = new Res(false, node.val);
            }
        } else if (right == null) {
            if (left.equals && (left.val == node.val)) {
                count++;
                res = new Res(true, node.val);
            } else {
                res = new Res(false, node.val);
            }
        } else {
            if (left.equals && right.equals && (left.val == right.val) && (left.val == node.val)) {
                count++;
                res = new Res(true, node.val);
            } else {
                res = new Res(false, node.val);
            }
        }

        return res;

    }

    class Res {
        boolean equals;

        int val;

        public Res(boolean equals, int val) {
            this.equals = equals;
            this.val = val;
        }
    }

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
