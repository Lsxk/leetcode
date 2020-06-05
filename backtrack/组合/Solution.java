package 组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @version 1.0.0
 * @since 2020-06-04
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> combine = s.combine(4, 2);
        System.out.println(combine);
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, n, k, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, List<List<Integer>> res, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i + 1; j <= n; j++) {
            temp.add(j);
            backtrack(j, n, k, res, temp);
            temp.remove(Integer.valueOf(j));
        }

    }
}
