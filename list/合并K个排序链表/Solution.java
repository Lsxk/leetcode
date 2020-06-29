package 合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {

            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);

        ListNode head = queue.poll();
        dummy.next = head;
        if (head != null) {
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                node.next = null;
                head.next = node;
                head = head.next;
            }
        }



        return dummy.next;
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
