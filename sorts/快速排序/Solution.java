package 快速排序;

/**
 * 功能描述： 平均时间复杂度O(NlogN)
 * 最差退化为冒泡O(N方)
 * 快速排序，两个哨兵
 *
 * 不稳定的排序
 * @version 1.0.0
 * @since 2020-06-12
 */
public class Solution {
    public static void main(String[] args) {
        int[] n = {5, 21, 53, 67, 4, 9, 7};
        Solution solution = new Solution();
        solution.quickSort(n, 0, n.length - 1);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

    }

    public void quickSort(int[] nums, int i, int j) {

        if (i >= j) {
            return;
        }
        int mark = nums[i];

        int left = i + 1;
        int right = j;
        while (left < right) {
            while (left < right && nums[right] > mark) {
                right--;
            }
            while (left < right && nums[left] < mark) {
                left++;
            }
            swap(nums, left, right);
        }

        swap(nums, i, left);
        quickSort(nums, i, left - 1);
        quickSort(nums, right + 1, j);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
