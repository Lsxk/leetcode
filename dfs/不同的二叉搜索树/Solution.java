package 不同的二叉搜索树;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(3));
    }

    Map<R, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        return dfs(1, n);
    }

    /**
     * 以start-end的数组组成的二叉搜索树的个数
     *
     * @param start
     * @param end
     * @return
     */
    public int dfs(int start, int end) {
        Integer cache = map.get(new R(start, end));
        if (cache != null) {
            return cache;
        }
        int res = 0;
        if (start >= end) {
            //只有一个节点,或者没有节点
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int left = dfs(start, i - 1);
            int right = dfs(i + 1, end);
            res += left * right;
        }
        map.put(new R(start, end), res);

        return res;
    }

    class R {
        int start;

        int end;

        public R(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            R r = (R) o;
            return start == r.start &&
                end == r.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
