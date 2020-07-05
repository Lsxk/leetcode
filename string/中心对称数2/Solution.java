package 中心对称数2;

import java.util.ArrayList;
import java.util.List;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 找到所有长度为 n 的中心对称数。
 * <p>
 * 示例 :
 * <p>
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        //只由 0, 1, 6, 8, 9组成，0不能放开头 -------> 全排列问题
        int count = 0;
        boolean ji = false;
        if (n % 2 == 0) {
            count = n / 2;
        } else {
            ji = true;
            count = n / 2 + 1;
        }

        char[] ok = new char[] {'0', '1', '6', '8', '9'};
        List<String> ans = new ArrayList<>();

        //count位的全排列 --> dfs
        backtrack(ok, ans, new StringBuilder(), 0, n);
        return ans;
    }

    public void backtrack(char[] ok, List<String> ans, StringBuilder temp, int index, int n) {
        if ((n % 2 == 0 && index == n / 2) || (n % 2 == 1 && index == n / 2 + 1)) {
            StringBuilder sb = new StringBuilder(temp.toString());
            int length;
            if (n % 2 == 1) {
                length = sb.length() - 1;
            } else {
                length = sb.length();
            }

            for (int i = length - 1; i >= 0; i--) {
                switch (sb.charAt(i)) {
                    case '0':
                        sb.append('0');
                        break;
                    case '1':
                        sb.append('1');
                        break;
                    case '6':
                        sb.append('9');
                        break;
                    case '8':
                        sb.append('8');
                        break;
                    case '9':
                        sb.append('6');
                        break;
                }
            }

            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < ok.length; i++) {
            if (i == 0 && index == 0 && n > 1) {
                continue;
            }
            if ((i == 2 || i == 4) && n <= 1) {
                continue;
            }
            if (n % 2 == 1 && index == n / 2 && (i == 2 || i == 4)) {
                continue;
            }
            temp.append(ok[i]);
            backtrack(ok, ans, temp, index + 1, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
