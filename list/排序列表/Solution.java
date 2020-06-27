package 排序列表;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * <p>
 * 归并排序
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (length < 2) {
            return head;
        }

        int count = 0;
        cur = head;
        while (count < length / 2 - 1) {
            count++;
            cur = cur.next;
        }

        ListNode right = cur.next;
        cur.next = null;

        return mergeTwoLists(sortList(head), sortList(right));
    }

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

        ListNode(int x) {
            val = x;
        }
    }
}
