package 可被三整除的最大和;

/**
 * 功能描述：
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * dp[i][0] nums[0...i]整除最大和
 * dp[i][1] 模为1最大和
 * dp[i][2] 模为2最大和
 * <p>
 * dp[i][j] = Math.max(num[i] + dp[i-1][(j-x) % 3], dp[i-1][j])             , num[i] % 3 = x
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumDivThree(new int[] {3, 6, 5, 1, 8}));
    }

    public int maxSumDivThree(int[] nums) {

        int length = nums.length;

        int[][] dp = new int[length + 1][3];

        //base case
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i < length + 1; i++) {
            int x = nums[i - 1] % 3;
            if (x == 0) {
                dp[i][0] = Math.max(nums[i - 1] + dp[i - 1][0], dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i - 1] + dp[i - 1][1], dp[i - 1][1]);
                dp[i][2] = Math.max(nums[i - 1] + dp[i - 1][2], dp[i - 1][2]);
            }
            if (x == 1) {
                dp[i][0] = Math.max(nums[i - 1] + dp[i - 1][2], dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i - 1] + dp[i - 1][0], dp[i - 1][1]);
                dp[i][2] = Math.max(nums[i - 1] + dp[i - 1][1], dp[i - 1][2]);
            }
            if (x == 2) {
                dp[i][0] = Math.max(nums[i - 1] + dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i - 1] + dp[i - 1][2], dp[i - 1][1]);
                dp[i][2] = Math.max(nums[i - 1] + dp[i - 1][0], dp[i - 1][2]);
            }
        }

        return dp[length][0];

    }
}
