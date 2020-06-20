package 下一个更大元素2;

import java.util.Stack;

/**
 * 单调栈 处理循环队列
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] ans = new int[nums.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            ans[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i % nums.length]);
        }
        return ans;
    }
}
