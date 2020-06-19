package 下一个更大元素1;

import java.util.HashMap;
import java.util.Stack;

/**
 * 功能描述：
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * @version 1.0.0
 * @since 2020-06-09
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        int length2 = nums2.length;
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        int t;

        Stack<Integer> stack = new Stack<>();

        for (int i = length2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            t = stack.empty() ? -1 : stack.peek();
            map.put(nums2[i], t);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
