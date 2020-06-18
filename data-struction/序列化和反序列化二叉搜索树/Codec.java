package 序列化和反序列化二叉搜索树;

import java.util.ArrayDeque;

/**
 * 功能描述：
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的
 *
 * @version 1.0.0
 * @since 2020-06-17
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = postorder(root, new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("\\s+")) {
            nums.add(Integer.valueOf(s));
        }
        return rebuild(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);

    }

    public TreeNode rebuild(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }

        Integer val = nums.getLast();
        if (val < lower || val > upper) {
            return null;
        }
        nums.removeLast();

        TreeNode root = new TreeNode(val);
        root.right = rebuild(val, upper, nums);
        root.left = rebuild(lower, val, nums);
        return root;
    }

    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
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
