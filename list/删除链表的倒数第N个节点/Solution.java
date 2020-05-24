package 删除链表的倒数第N个节点;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Solution
{
    //Dummy node + 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (p.next != null)
        {
            p = p.next;
            length++;
        }

        int index = length - n;

        p = dummy;

        while (index > 0)
        {
            p = p.next;
            index--;
        }
        p.next = p.next.next;


        return dummy.next;

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}