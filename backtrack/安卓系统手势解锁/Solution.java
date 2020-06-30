package 安卓系统手势解锁;

/**
 * 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
 * <p>
 * 给你两个整数，分别为 ​​m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/android-unlock-patterns
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 回溯
 * visited 0:未访问 1:选泽该节点为路径 2：cover
 */
public class Solution {
    private boolean used[] = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calcPatterns(-1, len);
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(int index, int last) {
        if (used[index]) {
            return false;
        }
        // first digit of the pattern
        if (last == -1) {
            return true;
        }
        // knight moves or adjacent cells (in a row or in a column)
        if ((index + last) % 2 == 1) {
            return true;
        }
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (index + last) / 2;
        if (mid == 4) {
            return used[mid];
        }
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }

    private int calcPatterns(int last, int len) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                used[i] = true;
                sum += calcPatterns(i, len - 1);
                used[i] = false;
            }
        }
        return sum;
    }

}
