package 回文串数量;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j=0; j < length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        for (int j = 0; j < length; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                        res++;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;

    }
}
