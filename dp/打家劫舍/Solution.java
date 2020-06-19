package 打家劫舍;

/**
 * 功能描述：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 变化的是什么？  ---偷的位置
 * 选择是什么？该位置偷不偷？
 * <p>
 * dp[i] 偷以i结尾，的最大收益
 * <p>
 * dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
 *
 * @version 1.0.0
 * @since 2020-06-13
 */
public class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
