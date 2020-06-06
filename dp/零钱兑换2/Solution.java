package 零钱兑换2;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 转化为完全背包问题，也就是物体的数量无限
 * 变化的状态：可选择的物品,背包的容量.
 * dp[i][j] 可选coins前i个物品，填满容量j的包，有多少中方法。
 * dp[i][j]= dp[i-1][j] + dp[i][j-coins[i]]
 *
 */
public class Solution {
    public int change(int amount, int[] coins) {

        int length = coins.length;

        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 0; i < length + 1; i++) {

            dp[i][0] = 1;
        }

        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[length][amount];



    }
}
