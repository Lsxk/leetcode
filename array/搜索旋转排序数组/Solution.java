package 搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    public int searchHelper(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        if (nums[left] < nums[middle]) {
            // 左半边有序
            if (nums[left] <= target && nums[middle] > target) {
                return searchHelper(nums, left, middle - 1, target);
            }
            else {
                return searchHelper(nums, middle + 1, right, target);
            }
        }
        else {
            // 右半边有序
            if (nums[middle] < target && target < nums[right]) {
                return searchHelper(nums, middle + 1, right, target);
            }
            else {
                return searchHelper(nums, left, middle - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = {4,5,6,7,0,1,2};
        System.out.println(s.search(ints, 0));
    }
}
