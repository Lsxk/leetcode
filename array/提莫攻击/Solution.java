package 提莫攻击;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        if (timeSeries.length == 0) {
            return 0;
        }

        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i -1 ] > duration) {
                ans = ans + duration;
            }
            else {
                ans = ans + timeSeries[i] - timeSeries[i - 1];
            }
        }
        return ans + duration;
    }
}
