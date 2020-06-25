package 最长数对列;

import java.util.Arrays;

/**
 * 功能描述：
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 最长递增子序列问题
 * <p>
 * dp[i] = Math.max(dp[i], dp[j] + 1), nums[j] < num[i]   j < i
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (o1, o2) -> {
            int temp = o1[0] - o2[0];
            if (temp == 0) {
                return o1[1] - o2[1];
            }
            return temp;
        });

        int ans = 0;

        int[] dp = new int[pairs.length];

        dp[0] = 1;

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(dp[i], ans);
        }

        return Math.max(1, ans);
    }
}
