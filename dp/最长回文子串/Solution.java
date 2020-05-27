package 最长回文子串;

/**
 * 功能描述：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * dp[i][j]表示s[i...j]是不是一个回文串
 * <p>
 * 状态转移方程：
 * dp[i][j] = (s[i] == s[j]) && (j - i < 3 || dp[i+1][j-1])
 *
 * @version 1.0.0
 * @since 2020-05-27
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                }
            }
        }

        int maxLe = 0;
        int mLeft = 0;
        int mRight = 0;

        for (int i = s.length() - 2; i >= 0; i--) {

            for (int j = 1; j < s.length(); j++) {

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (j - i + 1 > maxLe) {
                            maxLe = j - i + 1;
                            mLeft = i;
                            mRight = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return s.substring(mLeft, mRight + 1);
    }

}
