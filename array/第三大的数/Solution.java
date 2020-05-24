package 第三大的数;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
class Solution {
    public int thirdMax(int[] nums) {
        int max = nums[0];
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                third = second;
                second = max;
                max = n;
            } else if (n == max) {
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n == second) {
            } else if (n > third) {
                third = n;
            }
        }
        return (int) (third == Long.MIN_VALUE ? max : third);
    }
}
