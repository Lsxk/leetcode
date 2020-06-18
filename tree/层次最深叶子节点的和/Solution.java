package 层次最深叶子节点的和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Solution {
    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        List<TreeNode> lengthList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();
            if (curNode != null) {
                lengthList.add(curNode);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    lengthList.clear();
                }
            }
        }

        return lengthList.stream()
            .reduce((treeNode, treeNode2) -> new TreeNode(treeNode.val + treeNode2.val))
            .get().val;

    }

    class Node {
        private TreeNode node;

        private int depth;
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
