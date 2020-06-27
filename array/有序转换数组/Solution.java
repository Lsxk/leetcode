package 有序转换数组;

import java.util.Arrays;

/**
 * 给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生的数组返回。
 * <p>
 * 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-transformed-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] temp = new int[nums.length];
        if (a == 0) {
            if (b == 0) {
                Arrays.fill(temp, c);
            }

            for (int i = 0; i < nums.length; i++) {
                if (b > 0) {
                    temp[i] = b * nums[i] + c;
                } else {
                    temp[nums.length - 1 - i] = b * nums[i] + c;
                }
            }
            return temp;
        }
        int index = 0;
        double mid = -b * 1.0 / a / 2;
        int l = 0, r = nums.length - 1;
        if (a > 0) {
            index = nums.length - 1;
            while (l <= r) {
                if (Math.abs(mid - nums[l]) > Math.abs(mid - nums[r]))
                // 最大值
                {
                    temp[index] = cal(nums[l++], a, b, c);
                } else {
                    temp[index] = cal(nums[r--], a, b, c);
                }
                index--;
            }

        } else {
            while (l <= r) {
                if (Math.abs(mid - nums[l]) > Math.abs(mid - nums[r]))
                // 最小值
                {
                    temp[index++] = cal(nums[l++], a, b, c);
                } else {
                    temp[index++] = cal(nums[r--], a, b, c);
                }
            }
        }
        return temp;
    }
}
