package 丑数2;

public class Solution {

    public int nthUglyNumber(int n) {

        int[] nums = new int[n];
        nums[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {

            int ugly = Math.min(Math.min(nums[p2] * 2, nums[p3] * 3), nums[p5] * 5);

            nums[i] = ugly;

            if (ugly == nums[p2] * 2) {
                p2++;
            }
            if (ugly == nums[p3] * 3) {
                p3++;
            }
            if (ugly == nums[p5] * 5) {
                p5++;
            }
        }

        return nums[n - 1];

    }

}