package 复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //旧->新
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }

            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }

            cur = cur.next;
        }

        return map.get(head);
    }

    class Node {
        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
