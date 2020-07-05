package 中心对称数;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        char[] nn = new char[len];

        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                nn[len - i - 1] = '0';
            } else if (c == '1') {
                nn[len - i - 1] = '1';
            } else if (c == '6') {
                nn[len - i - 1] = '9';
            } else if (c == '8') {
                nn[len - i - 1] = '8';
            } else if (c == '9') {
                nn[len - i - 1] = '6';
            } else {
                return false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : nn) {
            sb.append(c);
        }

        return num.equals(sb.toString());
    }
}
