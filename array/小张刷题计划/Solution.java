package 小张刷题计划;

/**
 * 排序使用二分查找，
 * <p>
 * <p>
 * 寻找左边界的二分查找
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canComp(new int[] {4, 7, 8}, 1, 9));
    }

    public int minTime(int[] time, int m) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < time.length; ++i) {
            right += time[i];
        }

        while (left < right) {
            int middle = (left + right) / 2;

            if (canComp(time, m, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    /**
     * 判断用t分组，是否可以完成
     */
    boolean canComp(int[] cost, int day, int limit) {
        int useday, totaltime, maxtime;
        useday = 1;
        totaltime = maxtime = 0;
        for (int i = 0; i < cost.length; ++i) {
            int nexttime = Math.min(maxtime, cost[i]);
            if (nexttime + totaltime <= limit) {
                totaltime += nexttime;
                maxtime = Math.max(maxtime, cost[i]);
            } else {
                ++useday;
                totaltime = 0;
                maxtime = cost[i];
            }
        }
        return useday <= day;
    }
}
