package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和
 * dp[i][j]为第i行，第j个数字的值
 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 *
 * @version 1.0.0
 * @since 2020-06-12
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[][] dp = new int[rowIndex + 1][rowIndex + 1];

        dp[0][0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = 0; j < rowIndex + 1; j++) {
                if (j == 0 || j == rowIndex) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(dp[rowIndex][i]);
        }

        return res;
    }
}
