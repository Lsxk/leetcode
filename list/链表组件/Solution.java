package 链表组件;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * <p>
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-components
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int numComponents(ListNode head, int[] G) {

        Set<Integer> Gset = new HashSet();
        for (int x : G) {
            Gset.add(x);
        }

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) && (cur.next == null || !Gset.contains(cur.next.val))) {
                ans++;
            }
            cur = cur.next;
        }

        return ans;

    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}