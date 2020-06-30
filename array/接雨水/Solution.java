package 接雨水;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];

        int[] maxRight = new int[height.length];

        int curMax = 0;

        int ans = 0;

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return ans;

    }
}
