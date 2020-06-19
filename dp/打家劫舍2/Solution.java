package 打家劫舍2;

/**
 * 功能描述：
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 房屋是个环形   --> base case怎么来？
 * dp[i][j]为nums[i...j]的最高金额
 * <p>
 * dp[i][j] = Math.max(dp[i][j - 2] + nums[j], dp[i][j-1])
 * <p>
 * ans = Math.max(dp[0][length - 2], dp[1][length - 1])
 *
 * @version 1.0.0
 * @since 2020-06-13
 */
public class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];

        // base case
        dp[0][0] = nums[0];
        dp[0][1] = Math.max(nums[0], nums[1]);

        dp[1][1] = nums[1];

        for (int i = 0; i < 2; i++) {
            for (int j = 2; j < nums.length; j++) {

                dp[i][j] = Math.max(dp[i][j - 2] + nums[j], dp[i][j - 1]);
            }
        }

        return Math.max(dp[0][nums.length - 2], dp[1][nums.length - 1]);

    }
}
