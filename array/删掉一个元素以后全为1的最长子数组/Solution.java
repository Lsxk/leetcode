package 删掉一个元素以后全为1的最长子数组;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * <p>
 * 最多包含一个零的滑动窗口
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubarray(new int[] {1, 1, 0, 0, 1, 1, 1, 0, 1}));
    }

    public int longestSubarray(int[] nums) {

        int left = 0;
        int right = 0;
        int zeroCount = 0;

        int maxWindow = 0;

        while (right <= nums.length) {
            int n;
            if (right == nums.length) {
                n = 0;  //最后一位添加0
            } else {
                n = nums[right];
            }
            right++;
            if (n == 0) {
                zeroCount++;
            }
            maxWindow = Math.max(maxWindow, right - left - 1);
            if (zeroCount == 2) {

                System.out.println(String.format("windows is [%d, %d]", left, right - 1));

                //收缩left，
                while (left < right && zeroCount == 2) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
            }
        }

        return maxWindow - 1;
    }
}
