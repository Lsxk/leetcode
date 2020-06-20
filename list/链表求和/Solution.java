package 链表求和;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode head = new ListNode(-1);
        head.next = dummy;

        int marker = 0;

        while (l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }

            int temp = (value1 + value2 + marker) % 10;
            marker = (value1 + value2 + marker) / 10;

            dummy.next = new ListNode(temp);
            dummy = dummy.next;
        }
        if (marker == 1) {
            dummy.next = new ListNode(marker);
        }

        return head.next.next;
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}