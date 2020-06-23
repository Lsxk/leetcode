package 最短超串;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * @version 1.0.0
 * @since 2020-06-22
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(
            s.shortestSeq(new int[] {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[] {1, 5, 9}));
    }

    public int[] shortestSeq(int[] big, int[] small) {

        Map<Integer, Integer> needs = new HashMap<>();
        Map<Integer, Integer> window = new HashMap<>();

        for (int n : small) {
            needs.put(n, needs.containsKey(n) ? needs.get(n) + 1 : 1);
        }

        int left = 0;
        int right = 0;
        int okNum = 0;

        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < big.length) {

            int n = big[right];
            right++;
            if (needs.containsKey(n)) {
                window.put(n, window.containsKey(n) ? window.get(n) + 1 : 1);
                if (needs.get(n).equals(window.get(n))) {
                    okNum++;
                }
            }
            System.out.println(String.format("window: [%d, %d)\n", left, right));

            while (okNum == small.length) {
                //缩小left
                int d = big[left];

                if (needs.containsKey(d)) {
                    if (needs.get(d).equals(window.get(d))) {
                        okNum--;

                        if (right - left < minLen) {
                            minLen = right - left + 1;
                            minLeft = left;
                        }
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? new int[0] : new int[] {minLeft, minLeft + minLen - 1};
    }
}
