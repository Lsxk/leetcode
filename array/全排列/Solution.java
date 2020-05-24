package 全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int depth, List<Integer> path, List<List<Integer>> res) {
        if (nums.length == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int n : nums) {
            if (!path.contains(n)) {
                path.add(n);

                dfs(nums, depth + 1, path, res);
                path.remove(Integer.valueOf(n));
            }
        }
    }
}
