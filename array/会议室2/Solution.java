package 会议室2;

import java.util.Arrays;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            int temp = o1[0] - o2[0];
            if (temp == 0) {
                return o1[1] - o2[1];
            }
            return temp;
        });

        //有重叠的，必须分配单独会议室
        //无重叠的，可以共用会议室

        int res = 1;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= intervals[i - 1][1]) {
                continue;
            } else {
                res++;
            }
        }

        return res;

    }
}
