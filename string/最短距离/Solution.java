package 最短距离;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                index.add(i);
            }
        }

        int[] ans = new int[S.length()];
        for (AtomicInteger i = new AtomicInteger(0); i.get() < S.length(); i.addAndGet(1)) {
            ans[i.get()] = index.stream()
                .map(integer -> Math.abs(integer - i.get()))
                .min(Comparator.comparingInt(Integer::intValue))
                .get();
        }
        return ans;
    }
}
