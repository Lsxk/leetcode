package 反转链表2;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        int start = 1;
        ListNode startNode = head;
        while (start < m - 1) {
            startNode = startNode.next;
            start++;
        }

        startNode.next = reverseList(startNode.next);

        return head;

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        if (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
