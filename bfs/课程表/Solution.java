package 课程表;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 检测有向无环图---> 拓扑排序
 * <p>
 * 逐渐删除入度为0的节点
 *
 * bfs解法
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度表
        int[] indu = new int[numCourses];

        // 临接表，存入度节点
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] n : prerequisites) {
            indu[n[1]]++;
            adj.get(n[1]).add(n[0]);
        }

        Queue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numCourses; i++) {
            if (indu[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            Integer cours = queue.poll();// 入度为0的课程，即没有先修限制的课程，先学习
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).contains(cours)) {
                    adj.get(i).remove(cours);
                    indu[i]--;

                    if (indu[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        boolean res = true;
        for (int i = 0; i < numCourses; i++) {
            if (indu[i] > 0) {
                res = false;
            }
        }

        return res;

    }
}
