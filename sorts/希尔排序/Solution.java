package 希尔排序;

/**
 * 功能描述：
 * 又称为缩小增量排序，知道增量为0停止。
 * 划分为子序列，对每个子序列执行插入排序    ---->不稳定的排序
 *
 * @version 1.0.0
 * @since 2020-06-11
 */
public class Solution {
    public static void main(String[] args) {
        int[] n = {4, 21, 53, 67, 5, 9, 7};
        Solution solution = new Solution();
        solution.shellSort(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

    }

    public void shellSort(int[] nums) {
        int k = nums.length / 2;
        while (k > 0) {
            for (int i = 0; i < k; i++) {
                for (int j = i; j < nums.length; j = j + k) {
                    for (int l = j; l > k ; l = l -k) {
                        if (nums[l] < nums[l -k]) {
                            swap(nums, l, l - k);
                        }
                    }
                }
            }
            k = k / 2;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
