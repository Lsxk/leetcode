package 完全二叉树插入器;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能描述：
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class CBTInserter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter c = new CBTInserter(root);
        c.insert(2);
        TreeNode root1 = c.get_root();

        System.out.println(root1);

    }

    // 数组存取，下标方便
    private List<TreeNode> nodes = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        //层次遍历
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node);
            TreeNode left = node.left;
            TreeNode rigth = node.right;
            if (left != null) {
                queue.offer(left);
            }
            if (rigth != null) {
                queue.offer(rigth);
            }
        }
    }

    public int insert(int v) {

        TreeNode node = new TreeNode(v);

        nodes.add(node);

        //获取父亲节点
        int fatherIndex = getFatherIndex();
        if (fatherIndex >= 0) {
            TreeNode father = nodes.get(fatherIndex);
            if (father.left == null) {
                father.left = node;
            } else {
                father.right = node;
            }
            return father.val;
        }
        return v;
    }

    private int getFatherIndex() {
        return (nodes.size() - 2) / 2;
    }

    public TreeNode get_root() {
        return nodes.get(0);
    }

    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
