package 马戏团人塔;

import java.util.Arrays;

/**
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一
 * 点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * <p>
 * 类似 最长递增子序列 长度
 */
public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {

        int[][] person = new int[height.length][2];

        for (int i = 0; i < height.length; i++) {
            person[i] = new int[] {height[i], weight[i]};
        }

        Arrays.sort(person, (o1, o2) -> {
            int res = o1[0] - o2[0];
            if (res == 0) {
                return o2[1] - o1[1];
            } else {
                return res;
            }
        });

        int[] dp = new int[height.length];

        //base case
        dp[0] = 1;
        int res = dp[0];

        for (int i = 1; i < height.length; i++) {

            int max_val = 0, base_weight = person[i][1];
            for (int j = 0; j < i; ++j) {
                if (base_weight > person[j][1]) {
                    max_val = Math.max(max_val, dp[j]);
                }
            }
            dp[i] = max_val + 1;

            res = Math.max(res, dp[i]);
        }

        return res;

    }
}
