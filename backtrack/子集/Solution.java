package 子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * @version 1.0.0
 * @since 2020-06-04
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int j = i; j <= nums.length - 1; j++) {
            temp.add(nums[j]);
            backtrack(res, nums, j + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
