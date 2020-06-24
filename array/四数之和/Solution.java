package 四数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {

                map1.put(A[i] + B[j], map1.containsKey(A[i] + B[j]) ? map1.get(A[i] + B[j]) + 1 : 1);
                map2.put(C[i] + D[j], map2.containsKey(C[i] + D[j]) ? map2.get(C[i] + D[j]) + 1 : 1);
            }
        }

        AtomicInteger count = new AtomicInteger(0);

        map1.forEach((sum, n) -> {
            if (map2.containsKey(0 - sum)) {
                count.getAndAdd(map2.get(0 - sum) * n);
            }
        });

        return count.get();
    }
}
