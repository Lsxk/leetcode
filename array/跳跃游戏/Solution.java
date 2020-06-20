package 跳跃游戏;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {

            max = Math.max(max, i + nums[i]);

            if (max <= i) {
                return false;
            }
        }

        return max >= length - 1;

    }
}
