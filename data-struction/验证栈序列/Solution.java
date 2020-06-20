package 验证栈序列;

import java.util.Stack;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-20
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int i = 0; i < pushed.length; i++) {

            stack.push(pushed[i]);
            while (!stack.isEmpty() && popIndex < pushed.length && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return popIndex == pushed.length;
    }
}
