package K个一组翻转链表;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode tail = pre;

            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    //长度不够k
                    return pre.next;
                }
            }

            ListNode next = tail.next;

            ListNode[] pair = reverseSingle(cur, tail);
            cur = pair[0];
            tail = pair[1];

            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;

        }

        return dummy.next;

    }

    ListNode[] reverseSingle(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;

        while (pre != tail) {
            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return new ListNode[] {tail, head};
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
