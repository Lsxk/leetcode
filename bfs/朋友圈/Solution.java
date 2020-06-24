package 朋友圈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述：
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A
 * 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数
 *
 * @version 1.0.0
 * @since 2020-06-24
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    visited[node] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[node][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }

        return count;

    }
}
