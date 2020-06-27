package 删除排序数组中的重复项;

/**
 *
 */
public class Solution {
    public int removeDuplicates(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (fast <= nums.length - 1) {
            while (nums[slow] == nums[fast]) {
                fast++;
            }

            swap(nums, slow + 1, fast);
            slow++;
            fast = slow;
        }

        return slow;

    }


    void swap(int[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}
