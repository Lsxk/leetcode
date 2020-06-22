package LRU缓存;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private int capacity;

    private HashMap<Integer, Integer> map;

    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            map.put(key, value);
            return;
        }
        if (list.size() == capacity) {
            map.remove(list.removeFirst());
            map.put(key, value);
            list.addLast(key);
        } else {
            map.put(key, value);
            list.addLast(key);
        }
    }
}
