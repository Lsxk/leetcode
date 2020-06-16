package LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-12
 */
public class LRUCache {

    Map<Integer, Node> value = new HashMap<>();

    Node head;

    Node tail;

    int capacity;

    int count;

    public void addFirst(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(Node node) {
        remove(node);
        addFirst(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node();
        tail = new Node();

        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        if (!value.containsKey(key)) {
            return -1;
        } else {
            Node node = value.get(key);
            this.moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = this.value.get(key);
        if (node == null) {

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            this.addFirst(newNode);
            this.value.put(key, newNode);
            count++;

            if (count > capacity) {
                Node temp = tail.pre;
                this.remove(temp);
                this.value.remove(temp.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    class Node {
        int value;

        int key;

        Node pre;

        Node next;
    }
}
