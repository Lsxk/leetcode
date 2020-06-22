package 最小K个数;

import java.util.PriorityQueue;

public class Solution {
    public int[] smallestK(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int n : arr) {
            if (heap.size() == k + 1) {
                heap.poll();
            }
            heap.offer(n);
        }
        if (heap.size() > k) {
            heap.poll();
        }

        int[] n = new int[k];
        for (int i = 0; i < k; i++) {
            n[i] = heap.poll();
        }
        return n;
    }
}
