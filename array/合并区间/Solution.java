package 合并区间;

import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] a : intervals) {

            if (idx == -1 || a[0] > res[idx][1]) {
                res[++idx] = a;
            }
            else {
                res[idx][1] = Math.max(a[1], res[idx][1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] s = {{1,3},{2,6},{8,10},{15,18}};
        solution.merge(s);
    }
}
