package 搜索选择数组2;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0);
        System.out.println();
    }

    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        if (nums[left] == target) {
            return true;
        }
        if (nums[right] == target) {
            return true;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return true;
        }

        if (nums[left] < nums[mid]) {
            //左边有序
            if (target > nums[left] && target < nums[mid]) {
                return binarySearch(nums, target, left + 1, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, right - 1);
            }

        } else if (nums[left] > nums[mid]) {
            if (target > nums[mid] && target < nums[right]) {
                return binarySearch(nums, target, mid + 1, right - 1);
            }
            return binarySearch(nums, target, left + 1, mid - 1);

        } else {
            //有重复值
            return binarySearch(nums, target, left + 1, right - 1);
        }
    }
}
