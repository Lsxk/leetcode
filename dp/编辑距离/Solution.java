package 编辑距离;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 先用递归实现，然后尝试转为动态规划
 *
 * dp[i][j],word1[0...i]转为word2[0...j]所需要的最少操作数
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        //base case
        for (int i = 0; i < length1 + 1; i++) {
            for (int j = 0; j < length2 + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }



        for (int i = 1; i < length1 + 1; i++) {

            for (int j = 1; j < length2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int a = dp[i][j-1] + 1;
                    int b = dp[i-1][j] + 1;
                    int c = dp[i-1][j-1] + 1;

                    int min = Math.min(a, b);
                    dp[i][j] = Math.min(c, min);
                }
            }
        }

        return dp[length1][length2];

    }

    //返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    //recursion(length1 - 1, length2 -1, word1, word2);
    int recursion(int i, int j, String word1, String word2) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return recursion(i - 1, j - 1, word1, word2);
        }
        else {
            int a = recursion(i, j - 1, word1, word2) + 1;// 插入
            int b = recursion(i - 1, j, word1, word2) + 1;// 删除一个字符
            int c = recursion(i- 1, j - 1, word1, word2) + 1;//替换

            return Math.min(Math.min(b, c), a);
        }

    }
}
