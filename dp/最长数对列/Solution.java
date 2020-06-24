package 最长数对列;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能描述：
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 使用1排序，转换为求最长递增子序列问题
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            int temp = o1[0] - o2[0];
            if (temp == 0) {
                return o1[1] - o2[1];
            }
            return temp;
        });
    }
}
