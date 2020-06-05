package 三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

// dp[i][j] 以第i层第j个节点结尾的最小路径和
//以下为自顶向下
//dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + list.get(i).get(j)
//dp[i][j] = dp[i-1][j] + list.get(i).get(j)     j==0
public class Solution {
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
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    continue;
                }

                if (j != 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
            }
        }

        int res = dp[triangle.size() - 1][0];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;
    }
}