package 插入排序;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-11
 */
public class Solution {

    public static void main(String[] args) {
        int[] n = {4, 21, 53, 67, 5, 9, 7};
        Solution solution = new Solution();
        solution.insertSort(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

    }

    public void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
                else {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
