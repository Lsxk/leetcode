package 四数相加2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        Map<Integer, Integer> sumCD = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int keyAB = A[i] + B[j];
                if (sumAB.containsKey(keyAB)) {
                    sumAB.put(keyAB, sumAB.get(keyAB) + 1);
                }
                else {
                    sumAB.put(keyAB, 1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int keyAB = C[i] + D[j];
                if (sumCD.containsKey(keyAB)) {
                    sumCD.put(keyAB, sumCD.get(keyAB) + 1);
                }
                else {
                    sumCD.put(keyAB, 1);
                }
            }
        }

        AtomicInteger res = new AtomicInteger(0);
        sumAB.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                if (sumCD.containsKey(0-integer)) {
                    res.addAndGet(integer2* sumCD.get(0-integer));
                }
            }
        });
        return res.get();
    }
}
