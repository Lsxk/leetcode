package 环形链表;

/**
 * 判断链表中是否有环
 */
public class Solution
{
    public boolean hasCycle(ListNode head) {

        if (head == null)
        {
            return false;
        }
        if (head.next == null)
        {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return true;
            }
        }
        return false;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
