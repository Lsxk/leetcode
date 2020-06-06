package 最长公共子序列;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * s1, s2
 * dp[i][j]为s1[1...i]，s2[1...j]的最长公共子序列长度
 * dp[i][j] = {
 *     dp[i-1][j-1] + 1   s1[i]==s2[j]
 *     max(dp[i-1][j], dp[i][j-1]) s1[i] != s2[j]
 * }
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        // base case
        for (int i = 0; i < length1 + 1; i++) {
            for (int j = 0; j < length2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        return dp[length1][length2];
    }

    /**
     * 递归，会超时
     * @param i
     * @param j
     * @param text1
     * @param text2
     * @return  dg(text1.length() - 1, text2.length() -1, text1, text2);
     */
    public int dg(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dg(--i, --j, text1, text2) + 1;
        }
        else {
            return Math.max(dg(--i, j, text1, text2), dg(i, --j, text1, text2));
        }
    }
}
