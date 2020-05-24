package 反转链表;

public class Solution
{
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode p = head.next;
        ListNode pHead = reverseList(p);
        p.next = head;

        head.next = null;

        return pHead;
    }
    // 迭代版本
    public ListNode reverseListIt(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;

        if (head == null)
        {
            return null;
        }

        while (cur.next != null)
        {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        cur.next = pre;
        return cur;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
