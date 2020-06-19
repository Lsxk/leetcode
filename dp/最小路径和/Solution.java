package 最小路径和;

/**
 * dp[i][j]为(0,0)到(i,j)的最小路径和
 * dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + nums[i][j]
 */
public class Solution {
    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        //base case
        dp[0][0] = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }

            }
        }

        return dp[row - 1][col - 1];

    }
}
