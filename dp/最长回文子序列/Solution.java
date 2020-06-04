package 最长回文子序列;

/**
 * 功能描述：
 * 给定一个字符串s，找到其中最长的回文子序列，并返回该序列的长度。可以假设s的最大长度为1000。
 *
 * @version 1.0.0
 * @since 2020-06-04
 */
// dp[i][j] = dp[i+1,j-1] + 2 s[i]==s[j]
// dp[i][j] = max(dp[i+1][j], dp[i][j-1]) + 1 s[i]!=s[j]

public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
