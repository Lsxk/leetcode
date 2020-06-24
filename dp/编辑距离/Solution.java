package 编辑距离;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 先用递归实现，然后尝试转为动态规划
 */
public class Solution {
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //base case
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }

            }
        }

        for (int i = 1; i <= length1; i++) {

            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int a = dp[i][j - 1] + 1;
                    int b = dp[i - 1][j] + 1;
                    int c = dp[i - 1][j - 1] + 1;

                    int min = Math.min(a, b);
                    dp[i][j] = Math.min(c, min);
                }
            }
        }

        return dp[length1][length2];

    }

    public int recursion(String word1, String word2, int i, int j) {
        if (i < 0 || j < 0) {
            return Math.abs(i - j);
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return recursion(word1, word2, i - 1, j - 1);
        } else {
            //有三种选择
            //编辑word1
            //删除word1
            //新增word1

            int a = recursion(word1, word2, i - 1, j - 1) + 1;
            int b = recursion(word1, word2, i - 1, j) + 1;
            int c = recursion(word1, word2, i, j - 1) + 1;

            return Math.min(Math.min(a, b), c);
        }
    }
}
