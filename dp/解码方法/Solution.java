package 解码方法;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * dp[i]以s.charAt(i)结尾的字符的解码个数
 * <p>
 * 如果s[i-1] 和 s[i-2] 小于等于26（如：12、15、20、26），则 dp[i] = dp[i-2] + dp[i-1] ; 否则：dp[i] = dp[i-1]
 */
public class Solution {
    public int numDecodings(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        if (n == 0 || s[0] == '0')//边界情况
        {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;//初始化
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (s[i - 1] == '0' && (s[i - 2] == '1' || s[i - 2] == '2'))//10和20两种情况
            {
                dp[i] = dp[i - 2];
            } else if (s[i - 1] == '0')// 30,50等不符合条件的情况，直接返回0
            {
                return 0;
            } else if (s[i - 2] == '1' || s[i - 2] == '2' && s[i - 1] - '0' <= 6)//12、26、24等情况
            {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
