package 打乱数组;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 */
public class Solution {
    int[] array;

    int[] origin;

    public Solution(int[] nums) {
        array = nums.clone();
        origin = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = origin.clone();
        return array;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            swap(array, i, new Random().nextInt(length));
        }

        return array;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
