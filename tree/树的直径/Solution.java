package 树的直径;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 *
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 *
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 *
 *
 * @version 1.0.0
 * @since 2020-06-15
 */
public class Solution {
    int ans, index = 0;
    List<List<Integer>> q;
    public int treeDiameter(int[][] edges) {
        q = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            q.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            q.get(edges[i][0]).add(edges[i][1]);
            q.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0, -1, 0);
        dfs(index, -1, 0);
        return ans;

    }

    public void dfs(int u, int point, int sum) {
        for (int i = 0; i < q.get(u).size(); i++) {
            if (q.get(u).get(i) == point) {
                continue;
            }
            dfs(q.get(u).get(i), u, sum + 1);
        }

        if (sum > ans) {
            ans = sum;
            index = u;
        }
    }

}
