package 分割等和子集;

/**
 * 功能描述：
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 0/1背包的简化
 * dp[i][j]=x,对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满
 * dp[i][j] = dp[i-1][j-num[i]] | dp[i-1[j], dp[i][j] = dp[i-1][j]
 * @version 1.0.0
 * @since 2020-06-05
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int length = nums.length;
        sum = sum / 2;

        boolean[][] dp = new boolean[length + 1][sum];

        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j <= sum; j++) {

                if (j < nums[i])

            }
        }

    }
}
