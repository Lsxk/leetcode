package 机器人的运动范围;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、
 * 下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * bfs或者dp都可
 * <p>
 * dp[i][j]为(i,j)是否可到达
 * <p>
 * 一般情况下
 * dp[i][j] = canMove && (dp[i)[j-1] || dp[i-1][j])
 * i == 0时,dp[i][j] = canMove && dp[i][j-1]
 * j == 0时,dp[i][j] = canMove && dp[i-1][j]
 *
 * @version 1.0.0
 * @since 2020-06-18
 */
public class Solution {

    public int movingCount(int m, int n, int k) {

        boolean[][] dp = new boolean[m][n];

        // base case
        dp[0][0] = true;
        int res = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = canMove(i, j, k) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = canMove(i, j, k) && dp[i - 1][j];
                } else {
                    dp[i][j] = canMove(i, j, k) && (dp[i][j - 1] || dp[i - 1][j]);
                }
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean canMove(int i, int j, int k) {
        List<Integer> nums1 = splitNum(i);
        nums1.addAll(splitNum(j));

        return nums1.stream().reduce(Integer::sum).get() <= k;
    }

    public List<Integer> splitNum(int n) {
        List<Integer> res = new ArrayList<>();

        while (n > 9) {
            res.add(n % 10);
            n = n / 10;
        }

        res.add(n);
        return res;
    }

}
