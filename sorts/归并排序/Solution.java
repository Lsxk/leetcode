package 归并排序;

/**
 * 功能描述：
 * 先分治，再合并
 *
 * @version 1.0.0
 * @since 2020-06-13
 */
public class Solution {
    public static void main(String[] args) {
        int[] n = {4, 21, 53, 67, 5, 9, 7};
        Solution solution = new Solution();
        n = solution.mergeSort(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, right.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) {
                ans[count] = a[p1];
                p1++;
            } else {
                ans[count] = b[p2];
                p2++;
            }
            count++;
        }

        while (p1 < a.length) {
            ans[count] = a[p1];
            p1++;
            count++;
        }
        while (p2 < b.length) {
            ans[count] = b[p2];
            p2++;
            count++;
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
