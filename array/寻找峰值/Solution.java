package 寻找峰值;

/**
 * 局部有序，可使用二分查找
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) { //局部升序，则寻找右边界
                left = mid + 1;
            }
            else {
                // 局部降序，则寻找左边界
                right = mid;
            }
        }

        return left;
    }
}
