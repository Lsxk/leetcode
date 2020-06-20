package 跳跃游戏2;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int count = 0;

        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            max = Math.max(max, i + nums[i]);

            if (i == end) {
                count++;
                end = max;
            }
        }
        return count;
    }
}