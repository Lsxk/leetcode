package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];

            if (map.containsKey(x)) {
                return new int[] {i, map.get(x)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 双指针
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }

        return new int[0];
    }
}
