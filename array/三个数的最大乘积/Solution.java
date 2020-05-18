package 三个数的最大乘积;

import java.util.Arrays;

/**
 * 功能描述：
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 *
 * @version 1.0.0
 * @since 2020-05-18
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
            nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
