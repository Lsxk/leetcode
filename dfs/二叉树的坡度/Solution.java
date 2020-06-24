package 二叉树的坡度;

/**
 * 功能描述：
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 * <p>
 * <p>
 * dfs自顶向上 又来了
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    int count = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return count;
    }

    Res dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Res left = dfs(node.left);
        Res right = dfs(node.right);

        if (left == null && right == null) {
            return new Res(node.val, 0);
        }
        int pod;
        if (left == null) {
            pod = Math.abs(right.sum);
            count += pod;
            return new Res(node.val + right.sum, pod);
        } else if (right == null) {
            pod = Math.abs(left.sum);
            count += pod;
            return new Res(node.val + left.sum, pod);
        } else {

            pod = Math.abs(left.sum - right.sum);
            count += pod;
            return new Res(node.val + left.sum + right.sum, pod);
        }
    }

    class Res {
        int sum;

        int pod;

        public Res(int sum, int pod) {
            this.sum = sum;
            this.pod = pod;
        }
    }

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
