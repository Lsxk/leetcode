package 数组中数字出现的次数;

/**
 * 功能描述：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
 *
 * @version 1.0.0
 * @since 2020-06-19
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {

        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        int h = 1;
        while ((res & h) == 0) {
            h <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int n : nums) {
            if ((h & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }

        return new int[] {a, b};
    }
}
