package 二叉树的垂序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给定二叉树，按垂序遍历返回其结点值。
 * <p>
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 * <p>
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 * <p>
 * 如果两个结点位置相同，则首先报告的结点值较小。
 * <p>
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<Node> allNode = new ArrayList<>();
        helper(root, allNode, 0, 0);

        allNode.sort((o1, o2) -> {
            int first = o1.x - o2.x;
            if (first == 0) {
                int second = o1.y - o2.y;
                if (second == 0) {
                    return o1.value - o2.value;
                }
                return second;
            }
            return first;
        });

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int pre = allNode.get(0).x;

        for (Node node : allNode) {
            if (node.x != pre) {
                pre = node.x;
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(node.value);
        }

        return ans;

    }

    public void helper(TreeNode node, List<Node> ans, int x, int y) {
        if (node == null) {
            return;
        }

        ans.add(new Node(x, y, node.val));
        helper(node.left, ans, x - 1, y - 1);
        helper(node.right, ans, x + 1, y - 1);

    }

    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Node {
        private int x;

        private int y;

        private int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

}
