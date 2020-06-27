package 重排链表;

import java.util.Stack;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        //后半部分加入栈
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        cur = head;
        while (count < length / 2) {
            cur = cur.next;
            count++;
        }

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        count = 0;

        while (count < length / 2) {
            ListNode temp = cur.next;
            cur.next = stack.pop();
            cur.next.next = temp;

            cur = cur.next.next;
            count++;
        }
        cur.next = null;

    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
