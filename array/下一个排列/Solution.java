package 下一个排列;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ss = {5,1,1};
        s.nextPermutation(ss);
    }
    public void nextPermutation(int[] nums) {

        int i = nums.length - 1;
        while (i - 1 >=0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i >= 1) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, j, i - 1);
        }

        reverse(nums, i);

    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
