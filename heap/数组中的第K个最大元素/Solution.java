package 数组中的第K个最大元素;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 小顶堆
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(value -> value));

        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

}
