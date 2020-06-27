package 分割链表;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x
 * 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 类似 快速排序的一趟排序--->不行，不能保证有序
 *
 * 双指针法
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = s.partition(node1, 3);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;

        ListNode cur = pre.next;
        Queue<ListNode> queue = new LinkedBlockingQueue<>();
        while (cur != null) {

            while (cur != null && cur.val < x) {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
            queue.offer(cur);
            cur = cur.next;
        }

        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;
        }

        return head.next;

    }

    //这种是 快排的思想，并不能保证按照原有顺序
    public ListNode partition(ListNode head, int x) {

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        // 入栈
        int length = 0;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            length++;
        }
        int left = 0;
        int right = length - 1;

        cur = head;
        while (left < right) {

            while (left < right && stack.peek().val >= x) {
                right--;
                stack.pop();
            }
            // stack顶为小于x的值

            while (left < right && cur.val < x) {
                left++;
                cur = cur.next;
            }
            if (left < right) {
                swap(cur, stack.pop());
                right--;
            }
        }

        return head;
    }

    public void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}