package 有效的括号;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (!pop.equals('(')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop1 = stack.pop();
                    if (!pop1.equals('{')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop2 = stack.pop();
                    if (!pop2.equals('[')) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}