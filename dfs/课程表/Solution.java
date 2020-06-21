package 课程表;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表 dfs解法
 * <p>
 * 每一个节点设置flag
 * flag==0，未被访问
 * <p>
 * flag==-1，被其他节点开始的dfs访问
 * <p>
 * flag==1，被本节点开始的dfs访问--->有环
 * <p>
 * 对所有节点 依次dfs，未发现环
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 临接表，存入度节点
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] n : prerequisites) {
            adj.get(n[1]).add(n[0]);
        }

        int[] flags = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(adj, i, flags)) {
                return false;
            }
        }
        return true;

    }

    //以i为起点，检测是否有环
    // true,存在环
    public boolean dfs(List<List<Integer>> adj, int i, int[] flags) {
        if (flags[i] == -1) {
            return false;
        }
        if (flags[i] == 1) {
            return true;
        }

        flags[i] = 1;

        for (int j = 0; j < adj.get(i).size(); j++) {
            if (dfs(adj, adj.get(i).get(j), flags)) {
                return true;
            }
        }

        flags[i] = -1;
        return false;
    }
}
