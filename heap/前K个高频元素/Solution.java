package 前K个高频元素;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 功能描述：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * @version 1.0.0
 * @since 2020-06-13
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        //堆排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int n : map.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.remove());
        }
        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
