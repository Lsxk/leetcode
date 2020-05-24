package 常数时间插入删除和获取随机元素;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private Map<Integer, Integer> index = new HashMap<>();

    private List<Integer> values = new ArrayList<>();

    private Random random = new SecureRandom();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }
        int size = values.size();
        values.add(size, val);
        index.put(val, size);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (index.containsKey(val)) {

            int idx = index.remove(val);
            Integer last = values.get(values.size() - 1);
            values.set(idx, last);

            values.remove(values.size() - 1);
            if (index.containsKey(last)) {
                index.put(last, idx);
            }

            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(5);
        randomizedSet.insert(9);
        randomizedSet.insert(4);
        randomizedSet.insert(2);

        randomizedSet.remove(9);
        randomizedSet.remove(4);

        System.out.println("test");
    }
}
