package 递增子序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 功能描述：
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * @version 1.0.0
 * @since 2020-06-04
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = {4,6,7,7};
        solution.findSubsequences(s);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sub, int[] nums, int cur){
        if(sub.size() > 1) {
            res.add(new ArrayList(sub));
        }

        Set<Integer> set = new HashSet<>();
        for(int i = cur; i < nums.length; i++){
            if (set.contains(nums[i])) {
                continue;
            }
            if(sub.size() == 0 || nums[i] >= sub.get(sub.size() - 1)){
                set.add(nums[i]);

                sub.add(nums[i]);
                dfs(res, sub, nums, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

}
