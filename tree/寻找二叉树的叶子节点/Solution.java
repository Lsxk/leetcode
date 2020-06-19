package 寻找二叉树的叶子节点;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
 *
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 *
 * 还是自底向上吧  --> ^_^真是万金油
 *
 * 定义：dfs返回值为 节点的height(从底向上计数)
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int curHeight = Math.max(left, right) + 1;
        if (res.size() < curHeight) {
            res.add(new ArrayList<>());
        }

        res.get(curHeight - 1).add(node.val);
        return curHeight;
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
