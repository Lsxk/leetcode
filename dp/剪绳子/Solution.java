package 剪绳子;

/**
 * 功能描述：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 完全背包问题，加了权重
 * 体积为1...n的物品任意个，装满容积为n的背包
 * <p>
 * dp[i][j]，使用前i个物品，装满容积为j的背包，获得的最大乘积
 * <p>
 * dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j/nums[i]])，意味着必须能够整除
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {
    public int cuttingRope(int n) {

        int[] dp = new int[n + 1];
        // base case
        dp[2] = 1;

        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }

        return dp[n];

    }
}
