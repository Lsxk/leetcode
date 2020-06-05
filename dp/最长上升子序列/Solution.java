package 最长上升子序列;

/**
 * 功能描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * dp[i] = Math.max(dp[i], dp[j] + 1) num[i] >= num[j]
 *
 * @version 1.0.0
 * @since 2020-06-05
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
