package 长度最小的子数组;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 非负数组，优先考虑前缀和、滑动窗口（左闭右开）
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int window = 0;
        int left = 0;
        int right = 0;

        int ans = Integer.MAX_VALUE;

        while (right < nums.length) {

            int n = nums[right];
            right++;
            window = window + n;

            if (window >= s) {
                ans = Math.min(ans, right - left);

                System.out.println(String.format("windows is [%d, %d)", left, right));

                //缩小窗口
                while (window >= s) {
                    window = window - nums[left];
                    left++;
                }
                //最后还有一个
                ans = Math.min(ans, right - left + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}
