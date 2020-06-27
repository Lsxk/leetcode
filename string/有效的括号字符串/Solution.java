package 有效的括号字符串;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean checkValidString(String s) {
        // possible range
        int min = 0, max = 0; // 维护当前左括号的数量范围：[min, max]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++min;
                ++max;
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                if (max-- == 0) {
                    return false;// 左括号不够
                }
            } else {
                if (min > 0) {
                    min--; // 可作为右括号，抵消
                }
                ++max; // 可作为左括号
            }
        }
        return min == 0;
    }

}
