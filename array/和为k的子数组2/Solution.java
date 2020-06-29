package 和为k的子数组2;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        for (int i = 1; i < nums.length; i++) {

            for (int j = -1; j < i - 1; j++) {
                if (j == -1) {
                    if (sum[i] % k == 0) {
                        return true;
                    }
                } else {
                    if ((sum[i] - sum[j]) % k == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
