package 完全平方数;

// 容积为n的背包，体积为1，4，9...的物体数量不限，用最少的物体装满背包
// 完全背包问题
//dp[i][j] 为用前i个物体，装忙容量为j的背包，需要的最少物体个数
//dp[i][j] = Math.min(dp[i][j-nums[i] + 1, dp[i-1][j])

class Solution {
    public int numSquares(int n) {
        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];

        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        int[][] dp = new int[max_square_index][n + 1];

        //base case
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < max_square_index; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (j >= square_nums[i]) {
                    dp[i][j] = Math.min(dp[i][j - square_nums[i]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[max_square_index - 1][n];
    }
}
