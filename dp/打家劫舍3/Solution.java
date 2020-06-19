package 打家劫舍3;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-13
 */
public class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        // 抢这个节点
        int done = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
            + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        //不抢这个
        int notDone = rob(root.left) + rob(root.right);

        int res = Math.max(done, notDone);
        map.put(root, res);

        return res;
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
