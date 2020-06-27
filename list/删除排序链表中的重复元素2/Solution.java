package 删除排序链表中的重复元素2;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 三指针
 * <p>
 * 1个慢，1个快。一个前序
 * <p>
 * 当slow=fast时，没有重复，slow != fast时有重复的。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;

        head = prev; //新的头

        ListNode slow;
        ListNode fast;

        while (prev.next != null) {
            slow = prev.next;
            fast = prev.next;

            while (fast.next != null && slow.val == fast.next.val) {
                fast = fast.next;
            }

            if (slow == fast) {
                //没有重复的
                prev = prev.next;
            } else {
                //有重复的
                prev.next = fast.next;
            }
        }

        return head.next;
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
