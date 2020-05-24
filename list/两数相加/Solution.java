package 两数相加;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = new ListNode(0);

        dummy.next = tmp;
        int tracker = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                if (tracker == 1) {
                    tmp.next = new ListNode(1);
                }
                return dummy.next.next;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }

            int val = l1.val + l2.val + tracker;
            if (val > 9) {
                val = val - 10;
                tracker = 1;
            }
            else {
                tracker = 0;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;

            l1 = l1.next;
            l2 = l2.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
