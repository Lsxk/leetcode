package 回文链表;

/**
 * 请判断一个链表是否为回文链表。
 */
public class Solution
{
    public boolean isPalindrome(ListNode head) {
        if (head == null)
        {
            return true;
        }

        int length = 0;
        ListNode p = head;
        while (p != null) {
            length ++;
            p = p.next;
        }

        // 翻转链表前半部分
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;

        for (int i = 0; i < length / 2; i++)
        {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        ListNode start;

        if (length % 2 == 0)
        {
            start = cur;
        }
        else {
            start = cur.next;
        }

        while (start != null)
        {
            if (start.val != pre.val)
            {
                return false;
            }
            start = start.next;
            pre = pre.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
