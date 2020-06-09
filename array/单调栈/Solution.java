package 单调栈;

import java.util.Stack;

/**
 * 功能描述：
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @version 1.0.0
 * @since 2020-06-09
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        int[] ans = new int[T.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0 ; i--) {
            while (!stack.empty() && stack.peek()[1] <= T[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? -1 : stack.peek()[0] - i;
            stack.push(new int[]{i, T[i]});
        }
        return ans;
    }
}
