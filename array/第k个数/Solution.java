package 第k个数;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 */
public class Solution {
    public int getKthMagicNumber(int k) {
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;

        int[] res = new int[k];
        res[0] = 1;
        for (int i = 1; i < k; i++) {

            res[i] = Math.min(Math.min(3 * res[p3], 5 * res[p5]), 7 * res[p7]);
            if (res[i] == 3 * res[p3]) {
                p3++;
            }
            if (res[i] == 5 * res[p5]) {
                p5++;
            }
            if (res[i] == 7 * res[p7]) {
                p7++;
            }
        }

        return res[k - 1];
    }
}
