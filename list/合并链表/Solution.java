package 合并链表;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummp = new ListNode(-1);
        dummp.next = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }

        while (l1 != null) {
            head.next = new ListNode(l1.val);
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            head.next = new ListNode(l2.val);
            l2 = l2.next;
            head = head.next;
        }
        return dummp.next.next;

    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
