package 存在重复;

import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Solution
{
    public static boolean containsDuplicate(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        return count != nums.length;
    }
}
