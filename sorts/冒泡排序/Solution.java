package 冒泡排序;

/**
 * 功能描述：
 * 如果是升序,则每次降最大的向后交换
 * 平均时间复杂度为O(N平方),
 * 设置flag的话，可以在最优下优化为O(n)
 *
 * @version 1.0.0
 * @since 2020-06-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] n = {4, 21, 53, 67, 5, 9, 7};
        Solution solution = new Solution();
        solution.BubbleSort(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    public void BubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
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
