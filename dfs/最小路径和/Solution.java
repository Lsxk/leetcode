package 最小路径和;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ss = new ArrayList<>();
        List<List<Integer>> sss = new ArrayList<>();
        ss.add(2);
        sss.add(ss);

        ss = new ArrayList<>();
        ss.add(3);
        ss.add(4);
        sss.add(ss);

        ss = new ArrayList<>();
        ss.add(6);
        ss.add(5);
        ss.add(7);
        sss.add(ss);

        ss = new ArrayList<>();
        ss.add(4);
        ss.add(1);
        ss.add(8);
        ss.add(3);
        sss.add(ss);

        System.out.println(s.minimumTotal(sss));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        helper(0, 0, triangle, res, triangle.get(0).get(0));
        return Collections.min(res);
    }

    public void helper(int deepth, int index,  List<List<Integer>> triangle, List<Integer> res, int sum) {
        if (deepth >= triangle.size()) {
            return;
        }

        if (deepth == triangle.size() - 1) {
            res.add(sum);
            return;
        }


        helper(deepth + 1, index, triangle, res, sum + triangle.get(deepth + 1).get(index));

        helper(deepth + 1, index + 1, triangle, res, sum + triangle.get(deepth + 1).get(index + 1));

    }
}
