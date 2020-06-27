package 最接近的数组和;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 */
public class Solution {
    public int findBestValue(int[] arr, int target) {

        int min = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;

        int left = target / arr.length - 1;
        int right = Arrays.stream(arr).max().getAsInt();

        while (left < right) {

            int middle = (left + right) / 2;
            int cac = cac(arr, middle, target);

            if (cac < 0) {
                left = middle;
            }
            else {
                right = middle;
            }

        }
        return left;

    }

    public int cac(int[] arr, int n, int target) {
        int count = 0;

        for (int i1 : arr) {
            if (i1 >= n) {
                count += n;
            } else {
                count += i1;
            }
        }

        return count - target;
    }
}
