package 最长公共子序列;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * dp[i][j]是s1[0...i]和s2[0...j]的最长公共子序列的长度
 * <p>
 * dp[i][j]=dp[i-1][j-1] + 1  {s1.charAt(i) == s2.charAt(j)}
 * <p>
 * dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //LCS

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // base case
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
