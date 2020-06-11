package 选择排序;

/**
 * 功能描述：升序 ：选择排序，从头至尾扫描序列，找出最小的一个元素，和第一个元素交换，接着从剩下的元素中继续这种选择和交换方
 * 平均时间复杂度O(N的平方)
 * 最优的优化和冒泡一样为O(n)
 * 最差为O(N的平方)
 *
 * 选择排序由于发生了不相邻位置的交换，所以是不稳定的
 *
 * 空间复杂度为O(1)
 * @version 1.0.0
 * @since 2020-06-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] n = {4, 21, 53, 67, 5, 9, 7};
        Solution solution = new Solution();
        solution.selectSort(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
