package 编辑距离1;

/**
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 * <p>
 * 注意：
 * <p>
 * 满足编辑距离等于 1 有三种可能的情形：
 * <p>
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isOneEditDistance("a", "ba"));
    }

    public boolean isOneEditDistance(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //base case
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < t.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }

            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {

                char c = s.charAt(i - 1);
                char d = t.charAt(j - 1);
                if (c == d) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + 1;
                    int edit = dp[i - 1][j - 1] + 1;
                    int remove = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min(Math.min(add, edit), remove);
                }

            }
        }

        return dp[s.length()][t.length()] == 1;
    }
}
