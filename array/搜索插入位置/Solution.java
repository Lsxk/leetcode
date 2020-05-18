package 搜索插入位置;

/**
 * 功能描述：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @version 1.0.0
 * @since 2020-05-18
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    private int searchHelper(int[] nums, int left, int right, int target) {
        int middle = (left + right) / 2;
        if (left == middle) {
            return left + 1;
        }

        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] > target) {
            return searchHelper(nums, left, middle, target);
        } else {
            return searchHelper(nums, middle, right, target);
        }
    }
}
