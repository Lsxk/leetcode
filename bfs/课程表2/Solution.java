package 课程表2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] p = new int[1][2];
        int[] temp = new int[] {1, 0};
        p[0] = temp;

        s.findOrder(2, p);

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //入度表
        int[] ind = new int[numCourses];

        //临接矩阵表
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] n : prerequisites) {
            ind[n[0]]++;
            adj.get(n[0]).add(n[1]);
        }

        List<Integer> res = new ArrayList<>();
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            Integer courses = queue.poll();
            res.add(courses);

            for (int i = 0; i < numCourses; i++) {
                if (adj.get(i).contains(courses)) {
                    ind[i]--;
                    adj.get(i).remove(courses);
                    if (ind[i] == 0) {
                        queue.offer(i);
                    }
                }
            }

        }
        boolean success = true;
        for (int i = 0; i < numCourses; i++) {
            if (ind[i] != 0) {
                success = false;
            }
        }
        if (!success) {
            return new int[0];
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}