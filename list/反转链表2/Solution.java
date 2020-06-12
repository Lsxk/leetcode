package 反转链表2;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == n) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        // pre为m的前驱
        ListNode cur = pre.next

        for (int i = m; i < n; i++) {
            ListNode next = cur.next;

            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;


    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
