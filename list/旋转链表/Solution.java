package 旋转链表;

import java.util.Stack;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        //定位到要断开的pre,断开链表，后面的入栈
        int count = 0;
        ListNode pre = head;
        while (count < length - k - 1) {
            pre = pre.next;
            count++;
        }

        cur = pre.next;
        pre.next = null; //断开
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {

            ListNode node = stack.pop();
            node.next = head;
            head = node;
        }

        return head;
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
